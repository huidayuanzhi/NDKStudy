package com.cheng.ndkstudy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class BinaryTreeDemo {

     public static class TreeNode {
         Integer val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(Integer val) { this.val = val; }
         TreeNode(Integer val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

    /**
     * 104. 二叉树的最大深度
     * 示例 1：
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：3
     * 示例 2：
     * 输入：root = [1,null,2]
     * 输出：2
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    /**
     * 111. 二叉树的最小深度
     * 示例 1：
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：2
     * 示例 2：
     * 输入：root = [2,null,3,null,4,null,5,null,6]
     * 输出：5
     */
    // 方法一：深度优先搜索
    public static int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepth, minDepth1(root.left));
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth, minDepth1(root.right));
        }
        return minDepth + 1;
    }

    // 迭代
    public static int minDepth2(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int minDepth = 1;
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode currNode = queue.poll();
                if (currNode.left == null && currNode.right == null) {
                    return minDepth;
                }
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
            minDepth++;
        }
        return minDepth;
    }

    /**
     * 二叉树中节点的个数
     */
    public static int numOfTreeNode(TreeNode root) {
        if (root == null) return 0;
        int left = numOfTreeNode(root.left);
        int right = numOfTreeNode(root.right);
        return left + right + 1;
    }

    /**
     * 二叉树中叶子节点的个数
     */
    public static int numOfNoChildNode(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int left = numOfNoChildNode(root.left);
        int right = numOfNoChildNode(root.right);
        return left + right;
    }

    /**
     * 二叉树中第k层节点的个数
     */
    public static int numOfkLevelTreeNode(TreeNode root, int k) {
        if (root == null || k < 1) return 0;
        if (k == 1) return 1;
        int left = numOfkLevelTreeNode(root.left, k - 1);
        int right = numOfkLevelTreeNode(root.right, k - 1);
        return left + right;
    }

    /**
     * 110. 平衡二叉树
     * 示例 1：
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：true
     * 示例 2：
     * 输入：root = [1,2,2,3,3,null,null,4,4]
     * 输出：false
     */
    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return height(root) >= 0;
    }

    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    /**
     * 958. 二叉树的完全性检验
     * 在一棵完全二叉树中，除了最后一层外，所有层都被完全填满，
     * 并且最后一层中的所有节点都尽可能靠左。
     * 最后一层（第 h 层）中可以包含 1 到 2h 个节点。
     * 示例 1：
     * 输入：root = [1,2,3,4,5,6]
     * 输出：true
     * 示例 2：
     * 输入：root = [1,2,3,4,5,null,7]
     * 输出：false
     */
    public static boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean result = true;
        boolean hasNoChild = false;
        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            if (hasNoChild) {
                if (currNode.left != null || currNode.right != null) {
                    result = false;
                    break;
                }
            } else {
                if (currNode.left != null && currNode.right != null) {
                    queue.offer(currNode.left);
                    queue.offer(currNode.right);
                } else if (currNode.left != null && currNode.right == null) {
                    queue.offer(currNode.left);
                    hasNoChild = true;
                } else if (currNode.left == null && currNode.right != null) {
                    result = false;
                    break;
                } else {
                    hasNoChild = true;
                }
            }
        }
        return result;
    }

    /**
     * 两个二叉树是否完全相同
     */
    public static boolean isSameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (!Objects.equals(t1.val, t2.val)) {
            return false;
        }
        boolean left = isSameTree(t1.left, t2.left);
        boolean right = isSameTree(t1.right, t2.right);
        return left && right;
    }

    /**
     * 两个二叉树是否互为镜像
     */
    public static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (!Objects.equals(t1.val, t2.val)) {
            return false;
        }
        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    /**
     * 镜像二叉树
     */
    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null) return root;
        TreeNode left = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(left);
        return root;
    }

    /**
     * 二叉树的搜索区间
     */
    public static List<Integer> searchRange(TreeNode root, int k1, int k2) {
        if (root == null) return Collections.emptyList();
        List<Integer> result = new ArrayList<>();
        searchHelper(root, k1, k2, result);
        return result;
    }

    private static void searchHelper(TreeNode root, int k1, int k2, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.val > k1) {
            searchHelper(root.left, k1, k2, result);
        }
        if (root.val >= k1 && root.val <= k2) {
            result.add(root.val);
        }
        if (root.val < k2) {
            searchHelper(root.right, k1, k2, result);
        }
    }

    /**
     * 783. 二叉搜索树节点最小距离
     * 给你一个二叉搜索树的根节点 root，返回树中任意两不同节点值之间的最小差值。
     * 差值是一个正数，其数值等于两值之差的绝对值。
     * 示例 1：
     * 输入：root = [4,2,6,1,3]
     * 输出：1
     * 示例 2：
     * 输入：root = [1,0,48,null,null,12,49]
     * 输出：1
     */
    // 方法一：中序遍历
    private static int pre = -1;
    private static int ans = Integer.MAX_VALUE;
    public static int minDiffInBST(TreeNode root) {
        if (root == null) return 0;
        pre = -1;
        ans = Integer.MAX_VALUE;
        dfs(root);
        return ans;
    }

    private static void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }

    /**
     * 96. 不同的二叉搜索树
     * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
     * 示例 1：
     * 输入：n = 3
     * 输出：5
     */
    // 当 i 为根节点时，其左子树节点个数为 i-1 个，右子树节点为 n-i，则
    // f(i)=G(i−1)∗G(n−i)
    public static int numTrees(int n) {
        if (n < 1) return 0;
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    /**
     * 判断二叉树是否是合法的二叉查找树(BST)
     */
    private static int lastVal = Integer.MAX_VALUE;
    private static boolean firstNode = true;

    public static void resetIsValidBST() {
        lastVal = Integer.MAX_VALUE;
        firstNode = true;
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) {
            return false;
        }
        if (!firstNode && lastVal >= root.val) {
            return false;
        }
        firstNode = false;
        lastVal = root.val;
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }

    /**
     * 二叉树广度优先遍历(层序遍历)
     */
    public static List<Integer> levelOrderTree(TreeNode root) {
        if (root == null) return Collections.emptyList();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            result.add(currNode.val);
            if (currNode.left != null) {
                queue.offer(currNode.left);
            }
            if (currNode.right != null) {
                queue.offer(currNode.right);
            }
        }
        return result;
    }

    /**
     * 二叉树的深度优先遍历
     */
    public static List<Integer> depthOrderTree(TreeNode root) {
        if (root == null) return Collections.emptyList();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode currNode = stack.pop();
            result.add(currNode.val);
            if (currNode.right != null) {
                stack.push(currNode.right);
            }
            if (currNode.left != null) {
                stack.push(currNode.left);
            }
        }
        return result;
    }

    /**
     * 144.二叉树的前序遍历
     * 示例 1：
     * 输入：root = [1,null,2,3]
     * 输出：[1,2,3]
     * 示例 2：
     * 输入：root = [1,2,3,4,5,null,8,null,null,6,7,9]
     * 输出：[1,2,4,5,6,7,3,8,9]
     */
    // 方法一：递归
    public static List<Integer> preorderTraversal1(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    private static void preOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preOrder(root.left, result);
        preOrder(root.right, result);
    }

    // 方法二：迭代
    public static List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode currNode = stack.pop();
            result.add(currNode.val);
            if (currNode.right != null) {
                stack.push(currNode.right);
            }
            if (currNode.left != null) {
                stack.push(currNode.left);
            }
        }
        return result;
    }

    public static List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            // 一边向左遍历，一边将遍历到的节点入栈，节点值入数组
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            // 指针指向栈顶节点（即上一个节点），并将栈顶节点出栈
            node = stack.pop();
            // 指针指向该节点的右子树，开始下一轮的遍历
            node = node.right;
        }
        return res;
    }

    /**
     * 94.二叉树的中序遍历
     * 示例 1：
     * 输入：root = [1,null,2,3]
     * 输出：[1,3,2]
     */
    // 方法一：递归
    public static List<Integer> inorderTraversal1(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private static void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    // 方法二：迭代
    public static List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }

    /**
     * 145.二叉树的后序遍历
     * 示例 1：
     * 输入：root = [1,null,2,3]
     * 输出：[3,2,1]
     * 示例 2：
     * 输入：root = [1,2,3,4,5,null,8,null,null,6,7,9]
     * 输出：[4,6,7,5,2,9,8,3,1]
     */
    public static List<Integer> postorderTraversal1(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private static void postorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
    }

    // 方法二：迭代
    public static List<Integer> postorderTraversal2(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        // 关键在于定义一个cur的前驱节点
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 若该节点的右节点为空，或者右节点被遍历过，数组才能存储该节点的数值（也就是我们最后才遍历的根）
            if (root.right == null || root.right == prev) {
                result.add(root.val);
                prev = root;
                root = null;
            } else { // 如果不满足，说明该节点的右节点还没有被遍历过，那么接着向右子节点遍历
                stack.push(root);
                root = root.right;
            }
        }
        return result;
    }

    /**
     * 102. 二叉树的层序遍历
     * 给你二叉树的根节点 root，返回其节点值的层序遍历。（即逐层地，从左到右访问所有节点）。
     * 示例 1：
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：[[3],[9,20],[15,7]]
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = stack.pop();
                level.add(node.val);
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
            result.add(level);
        }
        return result;
    }

    /**
     * 107. 二叉树的层序遍历 II
     * 给你二叉树的根节点 root，返回其节点值自底向上的层序遍历。
     * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     * 示例 1：
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：[[15,7],[9,20],[3]]
     */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(0, level);
        }
        return result;
    }

    /**
     * 606. 根据二叉树创建字符串
     * 给你二叉树的根节点 root，请你采用前序遍历的方式，
     * 将二叉树转化为一个由括号和整数组成的字符串，返回构造出的字符串。
     * 空节点使用一对空括号对 "()" 表示，转化后需要
     * 省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
     * 示例 1：
     * 输入：root = [1,2,3,4]
     * 输出："1(2(4))(3)"
     * 解释：初步转化后得到 "1(2(4)())(3()())" ，但省略所有不必要的空括号对后，字符串应该是"1(2(4))(3)" 。
     * 示例 2：
     * 输入：root = [1,2,3,null,4]
     * 输出："1(2()(4))(3)"
     */
    // 方法一：递归
    public static String tree2str1(TreeNode root) {
        if (root == null) return "";
        if (root.left == null && root.right == null) {
            return root.val + "";
        }
        if (root.right == null) {
            return new StringBuilder()
                    .append(root.val)
                    .append("(")
                    .append(tree2str1(root.left))
                    .append(")")
                    .toString();
        }
        return new StringBuilder()
                .append(root.val)
                .append("(")
                .append(tree2str1(root.left))
                .append(")")
                .append("(")
                .append(tree2str1(root.right))
                .append(")")
                .toString();
    }

    // 方法二：迭代
    public static String tree2str2(TreeNode root) {
        if (root == null) return "";
        StringBuilder result = new StringBuilder();
        Set<TreeNode> visited = new HashSet<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.peek();
            if (!visited.add(curr)) {
                // 当前节点已访问过且不是根节点，封闭括号
                if (curr != root) {
                    result.append(")");
                }
                stack.pop();
            } else {
                // 当前节点未访问过且不是根节点，准备访问该节点，添加左括号
                if (curr != root) {
                    result.append("(");
                }
                result.append(curr.val);
                if (curr.left == null && curr.right != null) {
                    result.append("()");
                }
                if (curr.right != null) {
                    stack.push(curr.right);
                }
                if (curr.left != null) {
                    stack.push(curr.left);
                }
            }
        }
        return result.toString();
    }

    /**
     * JZ36 二叉搜索树与双向链表
     */
    // 方法一：递归中序遍历
    // 返回的第一个指针，即为最小值，先定为null
    private static TreeNode headJZ36 = null;
    // 中序遍历当前值的上一位，初值为最小值，先定为null
    private static TreeNode preJZ36 = null;
    public static TreeNode treeToDoublyList1(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 首先递归到最左最小值
        treeToDoublyList1(root.left);
        // 找到最小值，初始化head和pre
        if (preJZ36 == null) {
            headJZ36 = root;
            preJZ36 = root;
        } else {
            // 当前节点与上一节点建立连接，将pre设置为当前值
            preJZ36.right = root;
            root.left = preJZ36;
            preJZ36 = root;
        }
        treeToDoublyList1(root.right);
        return headJZ36;
    }

    // 方法二：非递归中序遍历
    public static TreeNode treeToDoublyList2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode head = null;
        TreeNode prev = null;
        boolean isFirst = true;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (isFirst) {
                head = root;
                prev = root;
                isFirst = false;
            } else {
                prev.right = root;
                root.left = prev;
                prev = root;
            }
            root = root.right;
        }
        return head;
    }

}
