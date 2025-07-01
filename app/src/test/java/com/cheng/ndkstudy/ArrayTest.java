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
    public void topKFrequent() {
        int[] nums = { 1,1,1,2,2,3 };
        Logger.log("topKFrequent before");
        Logger.log(nums);
        int[] result = ArrayDemo.topKFrequent(nums, 2);
        Logger.log("topKFrequent - result = ");
        Logger.log(result);
    }

}
