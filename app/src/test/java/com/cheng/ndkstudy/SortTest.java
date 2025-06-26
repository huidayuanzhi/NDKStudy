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
}
