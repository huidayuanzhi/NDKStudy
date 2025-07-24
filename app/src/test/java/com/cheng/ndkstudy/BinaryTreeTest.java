package com.cheng.ndkstudy;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeTest {

    private BinaryTreeDemo.TreeNode createComplete(Integer[] nums) {
        if (nums == null || nums.length <= 0) return null;
        return buildTreeHelper(nums, 0);
    }

    private BinaryTreeDemo.TreeNode buildTreeHelper(Integer[] nums, int index) {
        if (index >= nums.length || nums[index] == null) return null; // 越界检查
        BinaryTreeDemo.TreeNode node = new BinaryTreeDemo.TreeNode(nums[index]); // 创建当前节点
        node.left = buildTreeHelper(nums, 2 * index + 1); // 左子节点，对应2*index+1
        node.right = buildTreeHelper(nums, 2 * index + 2); // 右子节点，对应2*index+2
        return node;
    }

    private BinaryTreeDemo.TreeNode create(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) {
            return null;
        }
        Queue<BinaryTreeDemo.TreeNode> queue = new LinkedList<>();
        BinaryTreeDemo.TreeNode root = new BinaryTreeDemo.TreeNode(arr[0]);
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty() && index < arr.length) {
            BinaryTreeDemo.TreeNode current = queue.poll();
            if (index < arr.length && arr[index] != null) {
                current.left = new BinaryTreeDemo.TreeNode(arr[index]);
                queue.offer(current.left);
            }
            index++;
            if (index < arr.length && arr[index] != null) {
                current.right = new BinaryTreeDemo.TreeNode(arr[index]);
                queue.offer(current.right);
            }
            index++;
        }
        return root;
    }

    @Test
    public void testMaxDepth() {
        BinaryTreeDemo.TreeNode root1 = create(new Integer[]{3,9,20,null,null,15,7});
        int result = BinaryTreeDemo.maxDepth(root1);
        Logger.log("maxDepth result = " + result); // 3
        BinaryTreeDemo.TreeNode root2 = create(new Integer[]{1,null,2});
        result = BinaryTreeDemo.maxDepth(root2);
        Logger.log("maxDepth result = " + result); // 2
    }

    @Test
    public void testMinDepth1() {
        Logger.log("minDepth1");
        BinaryTreeDemo.TreeNode root1 = create(new Integer[]{3,9,20,null,null,15,7});
        int result = BinaryTreeDemo.minDepth1(root1);
        Logger.log("minDepth1 result = " + result); // 2
        BinaryTreeDemo.TreeNode root2 = create(new Integer[]{2,null,3,null,4,null,5,null,6});
        result = BinaryTreeDemo.minDepth1(root2);
        Logger.log("minDepth1 result = " + result); //5
    }

    @Test
    public void testMinDepth2() {
        Logger.log("minDepth2");
        BinaryTreeDemo.TreeNode root1 = create(new Integer[]{3,9,20,null,null,15,7});
        int result = BinaryTreeDemo.minDepth2(root1);
        Logger.log("minDepth2 result = " + result); // 2
        BinaryTreeDemo.TreeNode root2 = create(new Integer[]{2,null,3,null,4,null,5,null,6});
        result = BinaryTreeDemo.minDepth2(root2);
        Logger.log("minDepth2 result = " + result); //5
    }

    @Test
    public void testNumOfTreeNode() {
        Logger.log("numOfTreeNode");
        BinaryTreeDemo.TreeNode root = create(new Integer[]{3,9,20,null,null,15,7});
        int result = BinaryTreeDemo.numOfTreeNode(root);
        Logger.log("numOfTreeNode result = " + result);
    }

    @Test
    public void testNumOfNoChildNode() {
        Logger.log("numOfNoChildNode");
        BinaryTreeDemo.TreeNode root = create(new Integer[]{3,9,20,null,null,15,7});
        int result = BinaryTreeDemo.numOfNoChildNode(root);
        Logger.log("numOfNoChildNode result = " + result);
    }

    @Test
    public void testNumOfkLevelTreeNode() {
        Logger.log("numOfkLevelTreeNode");
        BinaryTreeDemo.TreeNode root = create(new Integer[]{3,9,20,null,null,15,7});
        int result = BinaryTreeDemo.numOfkLevelTreeNode(root, 1);
        Logger.log("numOfkLevelTreeNode 1 result = " + result);
        result = BinaryTreeDemo.numOfkLevelTreeNode(root, 2);
        Logger.log("numOfkLevelTreeNode 2 result = " + result);
        result = BinaryTreeDemo.numOfkLevelTreeNode(root, 3);
        Logger.log("numOfkLevelTreeNode 3 result = " + result);
    }

    @Test
    public void testIsBalanced() {
        Logger.log("isBalanced");
        BinaryTreeDemo.TreeNode root1 = create(new Integer[]{3,9,20,null,null,15,7});
        boolean result = BinaryTreeDemo.isBalanced(root1);
        Logger.log("isBalanced result = " + result); // true
        BinaryTreeDemo.TreeNode root2 = create(new Integer[]{1,2,2,3,3,null,null,4,4});
        result = BinaryTreeDemo.isBalanced(root2);
        Logger.log("isBalanced result = " + result); // false
    }

    @Test
    public void testIsCompleteTree() {
        Logger.log("isCompleteTree");
        BinaryTreeDemo.TreeNode root1 = create(new Integer[]{1,2,3,4,5,6});
        boolean result = BinaryTreeDemo.isCompleteTree(root1);
        Logger.log("isCompleteTree result = " + result); // true
        BinaryTreeDemo.TreeNode root2 = create(new Integer[]{1,2,3,4,5,null,7});
        result = BinaryTreeDemo.isCompleteTree(root2);
        Logger.log("isCompleteTree result = " + result); // false
    }

    @Test
    public void testIsSameTree() {
        Logger.log("isSameTree");
        BinaryTreeDemo.TreeNode tree1 = create(new Integer[]{1,2,3,4,5,null,7});
        BinaryTreeDemo.TreeNode tree2 = create(new Integer[]{1,2,3,4,5,null,7});
        BinaryTreeDemo.TreeNode tree3 = create(new Integer[]{1,2,3,4,5,6,7});
        boolean result = BinaryTreeDemo.isSameTree(tree1, tree2);
        Logger.log("isSameTree result = " + result);
        result = BinaryTreeDemo.isSameTree(tree2, tree3);
        Logger.log("isSameTree result = " + result);
        result = BinaryTreeDemo.isSameTree(tree1, tree3);
        Logger.log("isSameTree result = " + result);
    }

    @Test
    public void testIsMirror() {
        Logger.log("isMirror");
        BinaryTreeDemo.TreeNode t1 = create(new Integer[]{1,2,2,3,4,4,3});
        BinaryTreeDemo.TreeNode t2 = create(new Integer[]{1,2,2,3,4,4,3});
        BinaryTreeDemo.TreeNode t3 = create(new Integer[]{1,3,2,5,4,6});
        boolean result = BinaryTreeDemo.isMirror(t1, t2);
        Logger.log("isMirror result = " + result);
        result = BinaryTreeDemo.isMirror(t1, t3);
        Logger.log("isMirror result = " + result);
    }

    @Test
    public void testMirrorTree() {
        Logger.log("mirrorTree");
        BinaryTreeDemo.TreeNode root = create(new Integer[]{5,7,9,8,3,2,4});
        BinaryTreeDemo.TreeNode mirror = BinaryTreeDemo.mirrorTree(root);
        boolean result = BinaryTreeDemo.isMirror(root, mirror);
        Logger.log("mirrorTree result = " + result);
    }

    @Test
    public void testSearchRange() {
        Logger.log("searchRange");
        BinaryTreeDemo.TreeNode root = create(new Integer[]{4,2,7,1,3});
        List<Integer> result = BinaryTreeDemo.searchRange(root, 3, 7);
        Logger.log("searchRange result -");
        Logger.log(result);
    }

}
