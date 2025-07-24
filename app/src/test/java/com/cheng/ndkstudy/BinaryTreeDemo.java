package com.cheng.ndkstudy;

import java.util.Deque;
import java.util.LinkedList;

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


}
