package com.cheng.ndkstudy;

import org.junit.Test;

import java.util.LinkedList;
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

}
