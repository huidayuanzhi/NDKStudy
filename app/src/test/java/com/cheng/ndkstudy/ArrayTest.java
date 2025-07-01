package com.cheng.ndkstudy;

import org.junit.Test;

public class ArrayTest {
    
    @Test
    public void testFindMax() {
        int[] nums = { 1,3,5,7,9,8,6,4,2 };
        Logger.log("findMax before");
        Logger.log(nums);
        int max = ArrayDemo.findMax(nums);
        Logger.log("findMax - max = " + max);
    }

    @Test
    public void testTopKFrequent() {
        int[] nums = { 1,1,1,2,2,3 };
        Logger.log("topKFrequent before");
        Logger.log(nums);
        int[] result = ArrayDemo.topKFrequent(nums, 2);
        Logger.log("topKFrequent - result = ");
        Logger.log(result);
    }

    @Test
    public void testMinSubArrayLen1() {
        int[] nums = { 2,3,1,2,4,3 };
        Logger.log("minSubArrayLen1 before");
        Logger.log(nums);
        int result = ArrayDemo.minSubArrayLen1(nums, 7);
        Logger.log("minSubArrayLen1 - result = " + result);
    }

    @Test
    public void testMinSubArrayLen2() {
        int[] nums = { 2,3,1,2,4,3 };
        Logger.log("minSubArrayLen2 before");
        Logger.log(nums);
        int result = ArrayDemo.minSubArrayLen2(nums, 7);
        Logger.log("minSubArrayLen2 - result = " + result);
    }

}
