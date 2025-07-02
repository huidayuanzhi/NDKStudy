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

    @Test
    public void testContainsNearByDuplicate1() {
        int[] nums1 = { 1,2,3,1 };
        Logger.log("containsNearByDuplicate1 before");
        Logger.log(nums1);
        boolean result1 = ArrayDemo.containsNearByDuplicate1(nums1, 3);
        Logger.log("containsNearByDuplicate1 - result = " + result1);
        int[] nums2 = { 1,0,1,1 };
        Logger.log("containsNearByDuplicate1 before");
        Logger.log(nums2);
        boolean result2 = ArrayDemo.containsNearByDuplicate1(nums2, 1);
        Logger.log("containsNearByDuplicate1 - result = " + result2);
        int[] nums3 = { 1,2,3,1,2,3 };
        Logger.log("containsNearByDuplicate1 before");
        Logger.log(nums3);
        boolean result3 = ArrayDemo.containsNearByDuplicate1(nums3, 2);
        Logger.log("containsNearByDuplicate1 - result = " + result3);
    }

    @Test
    public void testContainsNearByDuplicate2() {
        int[] nums1 = { 1,2,3,1 };
        Logger.log("containsNearByDuplicate2 before");
        Logger.log(nums1);
        boolean result1 = ArrayDemo.containsNearByDuplicate2(nums1, 3);
        Logger.log("containsNearByDuplicate2 - result = " + result1);
        int[] nums2 = { 1,0,1,1 };
        Logger.log("containsNearByDuplicate2 before");
        Logger.log(nums2);
        boolean result2 = ArrayDemo.containsNearByDuplicate2(nums2, 1);
        Logger.log("containsNearByDuplicate2 - result = " + result2);
        int[] nums3 = { 1,2,3,1,2,3 };
        Logger.log("containsNearByDuplicate2 before");
        Logger.log(nums3);
        boolean result3 = ArrayDemo.containsNearByDuplicate2(nums3, 2);
        Logger.log("containsNearByDuplicate2 - result = " + result3);
    }

    @Test
    public void testMoveZeroes1() {
        int[] nums = { 0,2,3,0,1,0,2,4,3 };
        Logger.log("moveZeroes1 before");
        Logger.log(nums);
        ArrayDemo.moveZeroes1(nums);
        Logger.log("moveZeroes1 after");
        Logger.log(nums);
    }

    @Test
    public void testMoveZeroes2() {
        int[] nums = { 0,2,3,0,1,0,2,4,3 };
        Logger.log("moveZeroes2 before");
        Logger.log(nums);
        ArrayDemo.moveZeroes2(nums);
        Logger.log("moveZeroes2 after");
        Logger.log(nums);
    }

    @Test
    public void testFindLengthOfLCIS1() {
        int[] nums = { 1,2,3,0,1,0,2,4,6,7 };
        Logger.log("findLengthOfLCIS1 before");
        Logger.log(nums);
        int result = ArrayDemo.findLengthOfLCIS1(nums);
        Logger.log("findLengthOfLCIS1 result = " + result);
    }

    @Test
    public void testFindLengthOfLCIS2() {
        int[] nums = { 1,2,3,0,1,0,2,4,6,7 };
        Logger.log("findLengthOfLCIS2 before");
        Logger.log(nums);
        int result = ArrayDemo.findLengthOfLCIS2(nums);
        Logger.log("findLengthOfLCIS2 result = " + result);
    }

    @Test
    public void testLongestConsecutive() {
        int[] nums = { 100,4,200,1,3,2 };
        Logger.log("longestConsecutive before");
        Logger.log(nums);
        int result = ArrayDemo.longestConsecutive(nums);
        Logger.log("longestConsecutive result = " + result);
    }

    @Test
    public void testMaxArea() {
        int[] nums = { 1,8,6,2,5,4,8,3,7 };
        Logger.log("maxArea before");
        Logger.log(nums);
        int result = ArrayDemo.maxArea(nums);
        Logger.log("maxArea result = " + result);
    }

    @Test
    public void testRemoveDuplicates() {
        int[] nums = { 0,0,1,1,1,2,2,3,3,4 };
        Logger.log("removeDuplicates before");
        Logger.log(nums);
        int result = ArrayDemo.removeDuplicates(nums);
        Logger.log("removeDuplicates result = " + result);
        Logger.log(nums);
    }

}
