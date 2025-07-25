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

    @Test
    public void testMinDiffInBST() {
        Logger.log("minDiffInBST");
        BinaryTreeDemo.TreeNode root1 = create(new Integer[]{4,2,6,1,3});
        int result = BinaryTreeDemo.minDiffInBST(root1);
        Logger.log("minDiffInBST result = " + result);
        BinaryTreeDemo.TreeNode root2 = create(new Integer[]{1,0,48,null,null,12,49});
        result = BinaryTreeDemo.minDiffInBST(root2);
        Logger.log("minDiffInBST result = " + result);
    }

    @Test
    public void testNumTrees() {
        Logger.log("numTrees");
        int result = BinaryTreeDemo.numTrees(3);
        Logger.log("numTrees result = " + result); // 5
    }

    @Test
    public void testIsValidBST() {
        Logger.log("isValidBST");
        BinaryTreeDemo.resetIsValidBST();
        BinaryTreeDemo.TreeNode root1 = create(new Integer[]{1,2,3,4,5,6});
        boolean result = BinaryTreeDemo.isValidBST(root1);
        Logger.log("isValidBST result = " + result); // false
        BinaryTreeDemo.resetIsValidBST();
        BinaryTreeDemo.TreeNode root2 = create(new Integer[]{4,2,6,1,3});
        result = BinaryTreeDemo.isValidBST(root2);
        Logger.log("isValidBST result = " + result); // true
    }

    @Test
    public void testLevelOrderTree() {
        Logger.log("levelOrderTree");
        BinaryTreeDemo.TreeNode root = create(new Integer[]{1,2,3,4,5,6,7,8,9});
        List<Integer> result = BinaryTreeDemo.levelOrderTree(root);
        Logger.log("levelOrderTree result - ");
        Logger.log(result);
    }

    @Test
    public void testDepthOrderTree() {
        Logger.log("depthOrderTree");
        BinaryTreeDemo.TreeNode root = create(new Integer[]{1,2,3,4,5,6,7,8,9});
        List<Integer> result = BinaryTreeDemo.depthOrderTree(root);
        Logger.log("depthOrderTree result - "); // 1,2,4,8,9,5,3,6,7
        Logger.log(result);
    }

    @Test
    public void testPreorderTraversal1() {
        Logger.log("preorderTraversal1");
        BinaryTreeDemo.TreeNode root = create(new Integer[]{1,null,2,3});
        List<Integer> result = BinaryTreeDemo.preorderTraversal1(root);
        Logger.log("preorderTraversal1 result = "); // 1,2,3
        Logger.log(result);
        BinaryTreeDemo.TreeNode root2 = create(new Integer[]{1,2,3,4,5,null,8,null,null,6,7,9});
        List<Integer> result2 = BinaryTreeDemo.preorderTraversal1(root2);
        Logger.log("preorderTraversal1 result = "); // 1,2,4,5,6,7,3,8,9
        Logger.log(result2);
    }

    @Test
    public void testPreorderTraversal2() {
        Logger.log("preorderTraversal2");
        BinaryTreeDemo.TreeNode root = create(new Integer[]{1,null,2,3});
        List<Integer> result = BinaryTreeDemo.preorderTraversal2(root);
        Logger.log("preorderTraversal2 result = "); // 1,2,3
        Logger.log(result);
        BinaryTreeDemo.TreeNode root2 = create(new Integer[]{1,2,3,4,5,null,8,null,null,6,7,9});
        List<Integer> result2 = BinaryTreeDemo.preorderTraversal2(root2);
        Logger.log("preorderTraversal2 result = "); // 1,2,4,5,6,7,3,8,9
        Logger.log(result2);
    }

    @Test
    public void testPreorderTraversal3() {
        Logger.log("preorderTraversal3");
        BinaryTreeDemo.TreeNode root = create(new Integer[]{1,null,2,3});
        List<Integer> result = BinaryTreeDemo.preorderTraversal3(root);
        Logger.log("preorderTraversal3 result = "); // 1,2,3
        Logger.log(result);
        BinaryTreeDemo.TreeNode root2 = create(new Integer[]{1,2,3,4,5,null,8,null,null,6,7,9});
        List<Integer> result2 = BinaryTreeDemo.preorderTraversal3(root2);
        Logger.log("preorderTraversal3 result = "); // 1,2,4,5,6,7,3,8,9
        Logger.log(result2);
    }

    @Test
    public void testInorderTraversal1() {
        Logger.log("inorderTraversal1");
        BinaryTreeDemo.TreeNode root = create(new Integer[]{1,null,2,3});
        List<Integer> result = BinaryTreeDemo.inorderTraversal1(root);
        Logger.log("inorderTraversal1 result -");
        Logger.log(result); // 1,3,2
        BinaryTreeDemo.TreeNode root2 = create(new Integer[]{1,2,3,4,5,6,7,8,9});
        List<Integer> result2 = BinaryTreeDemo.inorderTraversal1(root2);
        Logger.log("inorderTraversal1 result -");
        Logger.log(result2); // 8,4,9,2,5,1,6,3,7
    }

    @Test
    public void testInorderTraversal2() {
        Logger.log("inorderTraversal2");
        BinaryTreeDemo.TreeNode root = create(new Integer[]{1,null,2,3});
        List<Integer> result = BinaryTreeDemo.inorderTraversal2(root);
        Logger.log("inorderTraversal2 result -");
        Logger.log(result); // 1,3,2
        BinaryTreeDemo.TreeNode root2 = create(new Integer[]{1,2,3,4,5,6,7,8,9});
        List<Integer> result2 = BinaryTreeDemo.inorderTraversal1(root2);
        Logger.log("inorderTraversal1 result -");
        Logger.log(result2); // 8,4,9,2,5,1,6,3,7
    }

    @Test
    public void testPostorderTraversal1() {
        Logger.log("postorderTraversal1");
        BinaryTreeDemo.TreeNode root = create(new Integer[]{1,null,2,3});
        List<Integer> result = BinaryTreeDemo.postorderTraversal1(root);
        Logger.log("postorderTraversal1 result -");
        Logger.log(result); // 3,2,1
        BinaryTreeDemo.TreeNode root2 = create(new Integer[]{1,2,3,4,5,null,8,null,null,6,7,9});
        List<Integer> result2 = BinaryTreeDemo.postorderTraversal1(root2);
        Logger.log("postorderTraversal1 result -");
        Logger.log(result2); // 4,6,7,5,2,9,8,3,1
    }

    @Test
    public void testPostorderTraversal2() {
        Logger.log("postorderTraversal2");
        BinaryTreeDemo.TreeNode root = create(new Integer[]{1,null,2,3});
        List<Integer> result = BinaryTreeDemo.postorderTraversal2(root);
        Logger.log("postorderTraversal2 result -");
        Logger.log(result); // 3,2,1
        BinaryTreeDemo.TreeNode root2 = create(new Integer[]{1,2,3,4,5,null,8,null,null,6,7,9});
        List<Integer> result2 = BinaryTreeDemo.postorderTraversal2(root2);
        Logger.log("postorderTraversal2 result -");
        Logger.log(result2); // 4,6,7,5,2,9,8,3,1
    }

    @Test
    public void testLevelOrder() {
        Logger.log("levelOrder");
        BinaryTreeDemo.TreeNode root = create(new Integer[]{3,9,20,null,null,15,7});
        List<List<Integer>> result = BinaryTreeDemo.levelOrder(root);
        Logger.log("levelOrder result -"); // [3],[9,20],[15,7]
        Logger.log(result);
    }

    @Test
    public void testLevelOrderBottom() {
        Logger.log("levelOrderBottom");
        BinaryTreeDemo.TreeNode root = create(new Integer[]{3,9,20,null,null,15,7});
        List<List<Integer>> result = BinaryTreeDemo.levelOrderBottom(root);
        Logger.log("levelOrderBottom result -"); // [15,7],[9,20],[3]
        Logger.log(result);
    }

    @Test
    public void testTree2str1() {
        Logger.log("tree2str1");
        BinaryTreeDemo.TreeNode root1 = create(new Integer[]{1,2,3,4});
        String result = BinaryTreeDemo.tree2str1(root1);
        Logger.log("tree2str1 result = " + result); // 1(2(4))(3)
        BinaryTreeDemo.TreeNode root2 = create(new Integer[]{1,2,3,null,4});
        String result2 = BinaryTreeDemo.tree2str1(root2);
        Logger.log("tree2str1 result = " + result2); // 1(2()(4))(3)
    }

    @Test
    public void testTree2str2() {
        Logger.log("tree2str2");
        BinaryTreeDemo.TreeNode root1 = create(new Integer[]{1,2,3,4});
        String result = BinaryTreeDemo.tree2str2(root1);
        Logger.log("tree2str2 result = " + result); // 1(2(4))(3)
        BinaryTreeDemo.TreeNode root2 = create(new Integer[]{1,2,3,null,4});
        String result2 = BinaryTreeDemo.tree2str2(root2);
        Logger.log("tree2str2 result = " + result2); // 1(2()(4))(3)
    }

}
