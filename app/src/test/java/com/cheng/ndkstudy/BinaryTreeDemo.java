package com.cheng.ndkstudy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

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

}
