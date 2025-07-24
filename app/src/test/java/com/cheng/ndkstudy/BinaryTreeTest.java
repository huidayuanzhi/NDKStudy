package com.cheng.ndkstudy;

import org.junit.Test;

public class BinaryTreeTest {

    private BinaryTreeDemo.TreeNode create(Integer[] nums) {
        if (nums == null || nums.length <= 0) return null;
        return buildTreeHelper(nums, 0);
    }

    private BinaryTreeDemo.TreeNode buildTreeHelper(Integer[] nums, int index) {
        if (index >= nums.length) return null; // 越界检查
        BinaryTreeDemo.TreeNode node = new BinaryTreeDemo.TreeNode(nums[index]); // 创建当前节点
        node.left = buildTreeHelper(nums, 2 * index + 1); // 左子节点，对应2*index+1
        node.right = buildTreeHelper(nums, 2 * index + 2); // 右子节点，对应2*index+2
        return node;
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


}
