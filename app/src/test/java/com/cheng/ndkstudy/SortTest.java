package com.cheng.ndkstudy;

import org.junit.Test;

public class SortTest {

    @Test
    public void testBubbleSort() {
        int[] nums = { 9,3,4,2,1,5,8,6,7 };
        Logger.log("bubbleSort before");
        Logger.log(nums);
        Logger.log("bubbleSort after");
        int[] sortedNums = SortDemo.bubbleSort(nums);
        Logger.log(sortedNums);
    }

    @Test
    public void testSelectionSort() {
        int[] nums = { 9,3,4,2,1,5,8,6,7 };
        Logger.log("selectionSort before");
        Logger.log(nums);
        Logger.log("selectionSort after");
        int[] sortedNums = SortDemo.selectionSort(nums);
        Logger.log(sortedNums);
    }

    @Test
    public void testInsertSort() {
        int[] nums = { 9,3,4,2,1,5,8,6,7 };
        Logger.log("insertSort before");
        Logger.log(nums);
        Logger.log("insertSort after");
        int[] sortedNums = SortDemo.insertSort(nums);
        Logger.log(sortedNums);
    }

    @Test
    public void testShellSort() {
        int[] nums = { 9,3,4,2,1,5,8,6,7 };
        Logger.log("shellSort before");
        Logger.log(nums);
        Logger.log("shellSort after");
        int[] sortedNums = SortDemo.shellSort(nums);
        Logger.log(sortedNums);
    }

}
