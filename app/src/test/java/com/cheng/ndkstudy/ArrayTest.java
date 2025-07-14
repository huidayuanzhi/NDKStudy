package com.cheng.ndkstudy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void testSubarraySum1() {
        int[] nums = { 1,1,1 };
        Logger.log("subarraySum1 before");
        Logger.log(nums);
        int result = ArrayDemo.subarraySum1(nums, 2);
        Logger.log("subarraySum1 result = " + result);
        int[] nums2 = { 1,2,3 };
        Logger.log("subarraySum1 before");
        Logger.log(nums2);
        int result2 = ArrayDemo.subarraySum1(nums2, 3);
        Logger.log("subarraySum1 result = " + result2);
    }

    @Test
    public void testSubarraySum2() {
        int[] nums = { 1,1,1 };
        Logger.log("subarraySum2 before");
        Logger.log(nums);
        int result = ArrayDemo.subarraySum2(nums, 2);
        Logger.log("subarraySum2 result = " + result);
        int[] nums2 = { 1,2,3 };
        Logger.log("subarraySum2 before");
        Logger.log(nums2);
        int result2 = ArrayDemo.subarraySum2(nums2, 3);
        Logger.log("subarraySum2 result = " + result2);
    }

    @Test
    public void testSubarraysDivByK1() {
        int[] nums = { 4,5,0,-2,-3,1 };
        Logger.log("subarraysDivByK1 before");
        Logger.log(nums);
        int result = ArrayDemo.subarraysDivByK1(nums, 5);
        Logger.log("subarraysDivByK1 result = " + result);
        Logger.log(nums);
    }

    @Test
    public void testSubarraysDivByK2() {
        int[] nums = { 4,5,0,-2,-3,1 };
        Logger.log("subarraysDivByK2 before");
        Logger.log(nums);
        int result = ArrayDemo.subarraysDivByK2(nums, 5);
        Logger.log("subarraysDivByK2 result = " + result);
        Logger.log(nums);
    }

    @Test
    public void testSubarraysDivByK3() {
        int[] nums = { 4,5,0,-2,-3,1 };
        Logger.log("subarraysDivByK3 before");
        Logger.log(nums);
        int result = ArrayDemo.subarraysDivByK3(nums, 5);
        Logger.log("subarraysDivByK3 result = " + result);
        Logger.log(nums);
    }

    @Test
    public void testTwoSum1() {
        int[] nums = { 2,7,11,15 };
        Logger.log("twoSum1 before");
        Logger.log(nums);
        int[] result = ArrayDemo.twoSum1(nums, 9);
        Logger.log("twoSum1 result");
        Logger.log(result);
    }

    @Test
    public void testTwoSum2() {
        int[] nums = { 2,7,11,15 };
        Logger.log("twoSum2 before");
        Logger.log(nums);
        int[] result = ArrayDemo.twoSum2(nums, 9);
        Logger.log("twoSum2 result");
        Logger.log(result);
    }

    @Test
    public void testTwoSumII1() {
        int[] nums = { 2,7,11,15 };
        Logger.log("twoSumII1 before");
        Logger.log(nums);
        int[] result = ArrayDemo.twoSumII1(nums, 9);
        Logger.log("twoSumII1 result");
        Logger.log(result);
    }

    @Test
    public void testTwoSumII2() {
        int[] nums = { 2,7,11,15 };
        Logger.log("twoSumII2 before");
        Logger.log(nums);
        int[] result = ArrayDemo.twoSumII2(nums, 9);
        Logger.log("twoSumII2 result");
        Logger.log(result);
    }

    @Test
    public void testThreeSum() {
        int[] nums = { -1,0,1,2,-1,-4 };
        Logger.log("threeSum before");
        Logger.log(nums);
        List<List<Integer>> result = ArrayDemo.threeSum(nums);
        Logger.log("threeSum result");
        for (List<Integer> list : result) {
            Logger.log(list);
        }
    }

    @Test
    public void testFourSum() {
        int[] nums = { 1,0,-1,0,-2,2 };
        Logger.log("fourSum before");
        Logger.log(nums);
        List<List<Integer>> result = ArrayDemo.fourSum(nums, 0);
        Logger.log("fourSum result");
        for (List<Integer> list : result) {
            Logger.log(list);
        }
    }

    @Test
    public void testCanJump() {
        int[] nums1 = { 2,3,1,1,4 };
        Logger.log("canJump before");
        Logger.log(nums1);
        boolean result1 = ArrayDemo.canJump(nums1);
        Logger.log("canJump result = " + result1);
        int[] nums2 = { 3,2,1,0,4 };
        Logger.log("canJump before");
        Logger.log(nums2);
        boolean result2 = ArrayDemo.canJump(nums2);
        Logger.log("canJump result = " + result2);
    }

    @Test
    public void testJumpII1() {
        int[] nums1 = { 2,3,1,1,4 };
        Logger.log("jumpII1 before");
        Logger.log(nums1);
        int result1 = ArrayDemo.jumpII1(nums1);
        Logger.log("jumpII1 result = " + result1);
        int[] nums2 = { 2,3,0,1,4 };
        Logger.log("jumpII1 before");
        Logger.log(nums2);
        int result2 = ArrayDemo.jumpII1(nums2);
        Logger.log("jumpII1 result = " + result2);
    }

    @Test
    public void testJumpII2() {
        int[] nums1 = { 2,3,1,1,4 };
        Logger.log("jumpII2 before");
        Logger.log(nums1);
        int result1 = ArrayDemo.jumpII2(nums1);
        Logger.log("jumpII2 result = " + result1);
        int[] nums2 = { 2,3,0,1,4 };
        Logger.log("jumpII2 before");
        Logger.log(nums2);
        int result2 = ArrayDemo.jumpII2(nums2);
        Logger.log("jumpII2 result = " + result2);
    }

    @Test
    public void testUniquePaths1() {
        Logger.log("uniquePaths1 - 3, 7");
        int result = ArrayDemo.uniquePaths1(3, 7);
        Logger.log("uniquePaths1 result = " + result);
        Logger.log("uniquePaths1 - 7, 3");
        result = ArrayDemo.uniquePaths1(7, 3);
        Logger.log("uniquePaths1 result = " + result);
        Logger.log("uniquePaths1 - 3, 2");
        result = ArrayDemo.uniquePaths1(3, 2);
        Logger.log("uniquePaths1 result = " + result);
    }

    @Test
    public void testUniquePaths2() {
        Logger.log("uniquePaths2 - 3, 7");
        int result = ArrayDemo.uniquePaths2(3, 7);
        Logger.log("uniquePaths2 result = " + result);
        Logger.log("uniquePaths2 - 7, 3");
        result = ArrayDemo.uniquePaths2(7, 3);
        Logger.log("uniquePaths2 result = " + result);
        Logger.log("uniquePaths2 - 3, 2");
        result = ArrayDemo.uniquePaths2(3, 2);
        Logger.log("uniquePaths2 result = " + result);
    }

    @Test
    public void testUniquePathsWithObstacles1() {
        // [0,0,0],[0,1,0],[0,0,0]
        int[][] obstacleGrid1 = new int[][] {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        Logger.log("uniquePathsWithObstacles1");
        int result = ArrayDemo.uniquePathsWithObstacles1(obstacleGrid1);
        Logger.log("uniquePathsWithObstacles1 result = " + result);
        // [0,1],[0,0]
        int[][] obstacleGrid2 = new int[][] {
                {0, 1},
                {0, 0}
        };
        result = ArrayDemo.uniquePathsWithObstacles1(obstacleGrid2);
        Logger.log("uniquePathsWithObstacles1 result = " + result);
    }

    @Test
    public void testUniquePathsWithObstacles2() {
        // [0,0,0],[0,1,0],[0,0,0]
        int[][] obstacleGrid1 = new int[][] {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        Logger.log("uniquePathsWithObstacles2");
        int result = ArrayDemo.uniquePathsWithObstacles2(obstacleGrid1);
        Logger.log("uniquePathsWithObstacles2 result = " + result);
        // [0,1],[0,0]
        int[][] obstacleGrid2 = new int[][] {
                {0, 1},
                {0, 0}
        };
        result = ArrayDemo.uniquePathsWithObstacles2(obstacleGrid2);
        Logger.log("uniquePathsWithObstacles2 result = " + result);
    }

    @Test
    public void testFindMinArrowShots() {
        // [10,16],[2,8],[1,6],[7,12]
        int[][] points1 = new int[][]{
                {10, 16},
                {2, 8},
                {1, 6},
                {7, 12}
        };
        Logger.log("findMinArrowShots");
        int result = ArrayDemo.findMinArrowShots(points1);
        Logger.log("findMinArrowShots - result = " + result);
        // [1,2],[3,4],[5,6],[7,8]
        int[][] points2 = new int[][]{
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8}
        };
        result = ArrayDemo.findMinArrowShots(points2);
        Logger.log("findMinArrowShots - result = " + result);
        // [1,2],[2,3],[3,4],[4,5]
        int[][] points3 = new int[][]{
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 5}
        };
        result = ArrayDemo.findMinArrowShots(points3);
        Logger.log("findMinArrowShots - result = " + result);
    }

    @Test
    public void testEraseOverlapIntervals1() {
        // [1,2],[2,3],[3,4],[1,3] -> 1
        int[][] intervals1 = new int[][] {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3}
        };
        Logger.log("eraseOverlapIntervals1");
        int result = ArrayDemo.eraseOverlapIntervals1(intervals1);
        Logger.log("eraseOverlapIntervals1 - result = " + result);
        // [1,2], [1,2], [1,2] -> 2
        int[][] intervals2 = new int[][] {
                {1, 2},
                {1, 2},
                {1, 2}
        };
        result = ArrayDemo.eraseOverlapIntervals1(intervals2);
        Logger.log("eraseOverlapIntervals1 - result = " + result);
        // [1,2], [2,3] -> 0
        int[][] intervals3 = new int[][] {
                {1, 2},
                {2, 3}
        };
        result = ArrayDemo.eraseOverlapIntervals1(intervals3);
        Logger.log("eraseOverlapIntervals1 - result = " + result);
    }

    @Test
    public void testEraseOverlapIntervals2() {
        // [1,2],[2,3],[3,4],[1,3] -> 1
        int[][] intervals1 = new int[][] {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3}
        };
        Logger.log("eraseOverlapIntervals2");
        int result = ArrayDemo.eraseOverlapIntervals2(intervals1);
        Logger.log("eraseOverlapIntervals2 - result = " + result);
        // [1,2], [1,2], [1,2] -> 2
        int[][] intervals2 = new int[][] {
                {1, 2},
                {1, 2},
                {1, 2}
        };
        result = ArrayDemo.eraseOverlapIntervals2(intervals2);
        Logger.log("eraseOverlapIntervals2 - result = " + result);
        // [1,2], [2,3] -> 0
        int[][] intervals3 = new int[][] {
                {1, 2},
                {2, 3}
        };
        result = ArrayDemo.eraseOverlapIntervals2(intervals3);
        Logger.log("eraseOverlapIntervals2 - result = " + result);
    }

    @Test
    public void testMerge() {
        // [1,3],[2,6],[8,10],[15,18] -> [1,6],[8,10],[15,18]
        int[][] intervals1 = new int[][] {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
        Logger.log("merge");
        Logger.log(intervals1);
        int[][] result1 = ArrayDemo.merge(intervals1);
        Logger.log("merge result - ");
        Logger.log(result1);
        Logger.log("merge");
        // [1,4],[4,5] -> [1,5]
        int[][] intervals2 = new int[][] {
                {1, 4},
                {4, 5}
        };
        Logger.log(intervals2);
        int[][] result2 = ArrayDemo.merge(intervals2);
        Logger.log("merge result - ");
        Logger.log(result2);
    }

    @Test
    public void testInsert() {
        // intervals = [[1,3],[6,9]], newInterval = [2,5] -> [[1,5],[6,9]]
        int[][] intervals1 = new int[][] {
                {1, 3},
                {6, 9}
        };
        int[] newInterval1 = new int[]{2, 5};
        Logger.log("insert");
        Logger.log(intervals1);
        Logger.log(newInterval1);
        int[][] result1 = ArrayDemo.insert(intervals1, newInterval1);
        Logger.log("insert result - ");
        Logger.log(result1);
        Logger.log("insert");
        // intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8] -> [[1,2],[3,10],[12,16]]
        int[][] intervals2 = new int[][] {
                {1, 2},
                {3, 5},
                {6, 7},
                {8, 10},
                {12, 16}
        };
        int[] newInterval2 = new int[]{4, 8};
        Logger.log(intervals2);
        int[][] result2 = ArrayDemo.insert(intervals2, newInterval2);
        Logger.log("insert result - ");
        Logger.log(result2);
    }

    @Test
    public void testFindLongestChain1() {
       // [[1,2], [2,3], [3,4]] -> 2
       int[][] pairs1 = new int[][] {
               {1, 2},
               {2, 3},
               {3, 4}
       };
       Logger.log("findLongestChain1");
       Logger.log(pairs1);
       int result = ArrayDemo.findLongestChain1(pairs1);
       Logger.log("findLongestChain1 result - " + result);
       // [[1,2],[7,8],[4,5]] -> 3
       int[][] pairs2 = new int[][] {
               {1, 2},
               {7, 6},
               {4, 5}
       };
       Logger.log("findLongestChain1");
       Logger.log(pairs2);
       result = ArrayDemo.findLongestChain1(pairs2);
       Logger.log("findLongestChain1 result - " + result);
    }

    @Test
    public void testFindLongestChain3() {
       // [[1,2], [2,3], [3,4]] -> 2
       int[][] pairs1 = new int[][] {
               {1, 2},
               {2, 3},
               {3, 4}
       };
       Logger.log("findLongestChain3");
       Logger.log(pairs1);
       int result = ArrayDemo.findLongestChain3(pairs1);
       Logger.log("findLongestChain3 result - " + result);
       // [[1,2],[7,8],[4,5]] -> 3
       int[][] pairs2 = new int[][] {
               {1, 2},
               {7, 6},
               {4, 5}
       };
       Logger.log("findLongestChain3");
       Logger.log(pairs2);
       result = ArrayDemo.findLongestChain3(pairs2);
       Logger.log("findLongestChain3 result - " + result);
    }

    @Test
    public void testMinPathSum() {
        // [[1,3,1],[1,5,1],[4,2,1]] -> 7
        int[][] grid1 = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        Logger.log("minPathSum");
        Logger.log(grid1);
        int result = ArrayDemo.minPathSum(grid1);
        Logger.log("minPathSum result - " + result);
        // [[1,2,3],[4,5,6]] -> 12
        int[][] grid2 = new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        };
        Logger.log("minPathSum");
        Logger.log(grid2);
        result = ArrayDemo.minPathSum(grid2);
        Logger.log("minPathSum result - " + result);
    }

    @Test
    public void testClimbStairs1() {
        Logger.log("climbStairs1");
        int result = ArrayDemo.climbStairs1(2);
        Logger.log("climbStairs1 result - " + result);
        result = ArrayDemo.climbStairs1(3);
        Logger.log("climbStairs1 result - " + result);
    }

    @Test
    public void testClimbStairs2() {
        Logger.log("climbStairs2");
        int result = ArrayDemo.climbStairs2(2);
        Logger.log("climbStairs2 result - " + result);
        result = ArrayDemo.climbStairs2(3);
        Logger.log("climbStairs2 result - " + result);
    }

    @Test
    public void testNumDecoding1() {
        Logger.log("numDecoding1");
        int result = ArrayDemo.numDecoding1("12"); // 2
        Logger.log("numDecoding1 12 -> result = " + result);
        result = ArrayDemo.numDecoding1("226"); // 3
        Logger.log("numDecoding1 226 -> result = " + result);
        result = ArrayDemo.numDecoding1("06"); // 0
        Logger.log("numDecoding1 06 -> result = " + result);
    }

    @Test
    public void testNumDecoding2() {
        Logger.log("numDecoding2");
        int result = ArrayDemo.numDecoding2("12"); // 2
        Logger.log("numDecoding2 12 -> result = " + result);
        result = ArrayDemo.numDecoding2("226"); // 3
        Logger.log("numDecoding2 226 -> result = " + result);
        result = ArrayDemo.numDecoding2("06"); // 0
        Logger.log("numDecoding2 06 -> result = " + result);
    }

    @Test
    public void testMinEatingSpeed() {
        Logger.log("minEatingSpeed");
        int[] piles1 = {3,6,7,11};
        int result = ArrayDemo.minEatingSpeed(piles1, 8); // 4
        Logger.log(piles1);
        Logger.log("minEatingSpeed result - " + result);
        int[] piles2 = {30,11,23,4,20};
        result = ArrayDemo.minEatingSpeed(piles2, 5); // 30
        Logger.log(piles2);
        Logger.log("minEatingSpeed result - " + result);
        int[] piles3 = {30,11,23,4,20};
        result = ArrayDemo.minEatingSpeed(piles3, 6); // 23
        Logger.log(piles3);
        Logger.log("minEatingSpeed result - " + result);
    }

    @Test
    public void testShipWithinDays() {
        Logger.log("shipWithinDays");
        // weights = [1,2,3,4,5,6,7,8,9,10], days = 5 -> 15
        int[] weights1 = {1,2,3,4,5,6,7,8,9,10};
        int result = ArrayDemo.shipWithinDays(weights1, 5);
        Logger.log(weights1);
        Logger.log("shipWithinDays result - " + result);
        // weights = [3,2,2,4,1,4], days = 3 -> 6
        int[] weights2 = {3,2,2,4,1,4};
        result = ArrayDemo.shipWithinDays(weights2, 3);
        Logger.log(weights2);
        Logger.log("shipWithinDays result - " + result);
        // weights = [1,2,3,1,1], days = 4 -> 3
        int[] weights3 = {1,2,3,1,1};
        result = ArrayDemo.shipWithinDays(weights3, 4);
        Logger.log(weights3);
        Logger.log("shipWithinDays result - " + result);
    }

    @Test
    public void testMySqrt() {
        Logger.log("mySqrt");
        int result = ArrayDemo.mySqrt(4);
        Logger.log("mySqrt 4 result - " + result);
        result = ArrayDemo.mySqrt(8);
        Logger.log("mySqrt 8 result - " + result);
        result = ArrayDemo.mySqrt(9);
        Logger.log("mySqrt 9 result - " + result);
    }

    @Test
    public void testSearchRange() {
        int[] nums1 = new int[]{5,7,7,8,8,10};
        int[] result1 = ArrayDemo.searchRange(nums1, 8); // [3,4]
        Logger.log("searchRange");
        Logger.log(nums1);
        Logger.log("searchRange result");
        Logger.log(result1);
        int[] nums2 = new int[]{5,7,7,8,8,10};
        int[] result2 = ArrayDemo.searchRange(nums2, 6); // [-1,-1]
        Logger.log("searchRange");
        Logger.log(nums2);
        Logger.log("searchRange result");
        Logger.log(result2);
    }

    @Test
    public void testLengthOfLIS() {
        // [10,9,2,5,3,7,101,18] -> 4
        int[] nums1 = new int[]{10,9,2,5,3,7,101,18};
        int result1 = ArrayDemo.lengthOfLIS(nums1);
        Logger.log("lengthOfLIS");
        Logger.log(nums1);
        Logger.log("lengthOfLIS result - " + result1);
        // [0,1,0,3,2,3] -> 4
        int[] nums2 = new int[]{0,1,0,3,2,3};
        int result2 = ArrayDemo.lengthOfLIS(nums2);
        Logger.log("lengthOfLIS");
        Logger.log(nums2);
        Logger.log("lengthOfLIS result - " + result2);
        // [7,7,7,7,7,7,7] -> 1
        int[] nums3 = new int[]{7,7,7,7,7,7,7};
        int result3 = ArrayDemo.lengthOfLIS(nums3);
        Logger.log("lengthOfLIS");
        Logger.log(nums3);
        Logger.log("lengthOfLIS result - " + result3);
    }

    @Test
    public void testMaximalSquare1() {
        // [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]] -> 4
        char[][] matrix1 = new char[][] {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        };
        Logger.log("maximalSquare1");
        int result = ArrayDemo.maximalSquare1(matrix1);
        Logger.log("maximalSquare1 result - " + result);
        // [["0","1"],["1","0"]] -> 1
        char[][] matrix2 = new char[][] {
                {'0', '1'},
                {'1', '0'},
        };
        Logger.log("maximalSquare1");
        result = ArrayDemo.maximalSquare1(matrix2);
        Logger.log("maximalSquare1 result - " + result);
    }

    @Test
    public void testMaximalSquare2() {
        // [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]] -> 4
        char[][] matrix1 = new char[][] {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        };
        Logger.log("maximalSquare2");
        int result = ArrayDemo.maximalSquare2(matrix1);
        Logger.log("maximalSquare2 result - " + result);
        char[][] matrix2 = new char[][] {
                {'0', '1'},
                {'1', '0'},
        };
        Logger.log("maximalSquare2");
        result = ArrayDemo.maximalSquare2(matrix2);
        Logger.log("maximalSquare2 result - " + result);
    }

    @Test
    public void testMaxAreaOfIsland1() {
        int[][] grid = new int[][] {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        Logger.log("maxAreaOfIsland1");
        Logger.log(grid);
        int result = ArrayDemo.maxAreaOfIsland1(grid);
        Logger.log("maxAreaOfIsland1 result - " + result);
    }

    @Test
    public void testMaxAreaOfIsland2() {
        int[][] grid = new int[][] {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        Logger.log("maxAreaOfIsland2");
        Logger.log(grid);
        int result = ArrayDemo.maxAreaOfIsland2(grid);
        Logger.log("maxAreaOfIsland2 result - " + result);
    }

    @Test
    public void testMaxAreaOfIsland3() {
        int[][] grid = new int[][] {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        Logger.log("maxAreaOfIsland3");
        Logger.log(grid);
        int result = ArrayDemo.maxAreaOfIsland3(grid);
        Logger.log("maxAreaOfIsland3 result - " + result);
    }

    @Test
    public void testMaxProduct1() {
        // [2,3,-2,4] -> 6
        Logger.log("maxProduct1");
        int[] nums1 = {2,3,-2,4};
        int result = ArrayDemo.maxProduct1(nums1);
        Logger.log(nums1);
        Logger.log("maxProduct1 result - " + result);
        // [-2,0,-1] -> 0
        Logger.log("maxProduct1");
        int[] nums2 = {-2,0,-1};
        result = ArrayDemo.maxProduct1(nums2);
        Logger.log(nums2);
        Logger.log("maxProduct1 result - " + result);
    }

    @Test
    public void testMaxProduct2() {
        // [2,3,-2,4] -> 6
        Logger.log("maxProduct2");
        int[] nums1 = {2,3,-2,4};
        int result = ArrayDemo.maxProduct2(nums1);
        Logger.log(nums1);
        Logger.log("maxProduct2 result - " + result);
        // [-2,0,-1] -> 0
        Logger.log("maxProduct2");
        int[] nums2 = {-2,0,-1};
        result = ArrayDemo.maxProduct2(nums2);
        Logger.log(nums2);
        Logger.log("maxProduct2 result - " + result);
    }

    @Test
    public void testPremute() {
        int[] nums1 = {1, 2, 3};
        Logger.log("premute");
        Logger.log(nums1);
        List<List<Integer>> result = ArrayDemo.premute(nums1);
        Logger.log(result);
        int[] nums2 = {0, 1};
        Logger.log("premute");
        Logger.log(nums2);
        result = ArrayDemo.premute(nums2);
        Logger.log(result);
    }

    @Test
    public void testPermuteUnique() {
        Logger.log("permuteUnique");
        int[] nums1 = {1,1,2};
        Logger.log(nums1);
        List<List<Integer>> result = ArrayDemo.permuteUnique(nums1);
        Logger.log("permuteUnique result");
        Logger.log(result);
        Logger.log("permuteUnique");
        int[] nums2 = {1,2,3};
        Logger.log(nums2);
        result = ArrayDemo.permuteUnique(nums2);
        Logger.log("permuteUnique result");
        Logger.log(result);
        Logger.log("permuteUnique");
        int[] nums3 = {1,2,2,3};
        Logger.log(nums3);
        result = ArrayDemo.permuteUnique(nums3);
        Logger.log("permuteUnique result");
        Logger.log(result);
    }

    @Test
    public void testSubsets1() {
        Logger.log("subsets1");
        int[] nums1 = {1, 2, 3};
        List<List<Integer>> result = ArrayDemo.subsets1(nums1);
        Logger.log(nums1);
        Logger.log(result);
        Logger.log("subsets1");
        int[] nums2 = {0};
        result = ArrayDemo.subsets1(nums2);
        Logger.log(nums2);
        Logger.log(result);
    }

    @Test
    public void testSubsets2() {
        Logger.log("subsets2");
        int[] nums1 = {1, 2, 3};
        List<List<Integer>> result = ArrayDemo.subsets2(nums1);
        Logger.log(nums1);
        Logger.log(result);
        Logger.log("subsets2");
        int[] nums2 = {0};
        result = ArrayDemo.subsets1(nums2);
        Logger.log(nums2);
        Logger.log(result);
    }

    @Test
    public void testGenerateParenthesis() {
        // n = 3
        // ["((()))","(()())","(())()","()(())","()()()"]
        Logger.log("generateParenthesis - n = 3");
        List<String> res = ArrayDemo.generateParenthesis(3);
        Logger.log("generateParenthesis result");
        Logger.log(res);
        // n = 1
        // ["()"]
        Logger.log("generateParenthesis - n = 1");
        res = ArrayDemo.generateParenthesis(1);
        Logger.log("generateParenthesis result");
        Logger.log(res);
    }

    @Test
    public void maxSubArray() {
        // [-2,1,-3,4,-1,2,1,-5,4] -> 6
        Logger.log("maxSubArray");
        int[] nums1 = {-2,1,-3,4,-1,2,1,-5,4};
        int result = ArrayDemo.maxSubArray(nums1);
        Logger.log(nums1);
        Logger.log("maxSubArray result - " + result);
        // [5,4,-1,7,8] -> 23
        int[] nums2 = {5,4,-1,7,8};
        Logger.log("maxSubArray");
        result = ArrayDemo.maxSubArray(nums2);
        Logger.log(nums2);
        Logger.log("maxSubArray result - " + result);
    }

    @Test
    public void testGeneratePascalsTriangle() {
        Logger.log("generatePascalsTriangle");
        List<List<Integer>> result = ArrayDemo.generatePascalsTriangle(5);
        Logger.log("generatePascalsTriangle result");
        Logger.log(result);
    }

    @Test
    public void testGetPascalsTriangle1Row() {
        Logger.log("getPascalsTriangleRow1");
        List<Integer> result = ArrayDemo.getPascalsTriangleRow1(3);
        Logger.log("getPascalsTriangleRow1 3 result");
        Logger.log(result);
        result = ArrayDemo.getPascalsTriangleRow1(1);
        Logger.log("getPascalsTriangleRow1 1 result");
        Logger.log(result);
    }

    @Test
    public void testGetPascalsTriangle2Row() {
        Logger.log("getPascalsTriangleRow2");
        List<Integer> result = ArrayDemo.getPascalsTriangleRow2(3);
        Logger.log("getPascalsTriangleRow2 3 result");
        Logger.log(result);
        result = ArrayDemo.getPascalsTriangleRow2(1);
        Logger.log("getPascalsTriangleRow2 1 result");
        Logger.log(result);
    }

    @Test
    public void testMinimumTotal1() {
        Logger.log("minimumTotal1");
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        int result = ArrayDemo.minimumTotal1(triangle);
        Logger.log("minimumTotal1 result - " + result);
    }

    @Test
    public void testMinimumTotal2() {
        Logger.log("minimumTotal2");
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        int result = ArrayDemo.minimumTotal2(triangle);
        Logger.log("minimumTotal2 result - " + result);
    }

    @Test
    public void testFindMaxAverage() {
        int[] nums1 = {1,12,-5,-6,50,3};
        Logger.log("findMaxAverage");
        Logger.log(nums1);
        double result = ArrayDemo.findMaxAverage(nums1, 4);
        Logger.log("findMaxAverage result - " + result);
        int[] nums2 = {5};
        Logger.log("findMaxAverage");
        Logger.log(nums2);
        result = ArrayDemo.findMaxAverage(nums2, 1);
        Logger.log("findMaxAverage result - " + result);
    }

    @Test
    public void testMaxProfit1() {
        int[] prices1 = {7,1,5,3,6,4}; // 5
        Logger.log("maxProfit1");
        Logger.log(prices1);
        int result = ArrayDemo.maxProfit1(prices1);
        Logger.log("maxProfit1 result - " + result);
        int[] prices2 = {7,6,4,3,1}; // 0
        Logger.log("maxProfit1");
        Logger.log(prices2);
        result = ArrayDemo.maxProfit2(prices2);
        Logger.log("maxProfit2 result - " + result);
    }

    @Test
    public void testMaxProfit2() {
        int[] prices1 = {7,1,5,3,6,4}; // 5
        Logger.log("maxProfit2");
        Logger.log(prices1);
        int result = ArrayDemo.maxProfit2(prices1);
        Logger.log("maxProfit2 result - " + result);
        int[] prices2 = {7,6,4,3,1}; // 0
        Logger.log("maxProfit2");
        Logger.log(prices2);
        result = ArrayDemo.maxProfit2(prices2);
        Logger.log("maxProfit2 result - " + result);
    }

    @Test
    public void testMaxProfit3() {
        int[] prices1 = {7,1,5,3,6,4}; // 5
        Logger.log("maxProfit3");
        Logger.log(prices1);
        int result = ArrayDemo.maxProfit3(prices1);
        Logger.log("maxProfit3 result - " + result);
        int[] prices2 = {7,6,4,3,1}; // 0
        Logger.log("maxProfit3");
        Logger.log(prices2);
        result = ArrayDemo.maxProfit3(prices2);
        Logger.log("maxProfit3 result - " + result);
    }

    @Test
    public void testCanCompleteCircuit1() {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2}; // 3
        Logger.log("canCompleteCircuit - gas");
        Logger.log(gas);
        Logger.log("canCompleteCircuit - cost");
        Logger.log(cost);
        int result = ArrayDemo.canCompleteCircuit1(gas, cost);
        Logger.log("canCompleteCircuit result - " + result);
    }

    @Test
    public void testCanCompleteCircuit2() {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2}; // 3
        Logger.log("canCompleteCircuit - gas");
        Logger.log(gas);
        Logger.log("canCompleteCircuit - cost");
        Logger.log(cost);
        int result = ArrayDemo.canCompleteCircuit2(gas, cost);
        Logger.log("canCompleteCircuit result - " + result);
    }

    @Test
    public void testLargestNumber1() {
        int[] nums1 = {10,2}; // 210
        Logger.log("largestNumber");
        Logger.log(nums1);
        String result = ArrayDemo.largestNumber1(nums1);
        Logger.log("largestNumber result - " + result);
        int[] nums2 = {3,30,34,5,9}; // 9534330
        Logger.log("largestNumber");
        Logger.log(nums2);
        result = ArrayDemo.largestNumber1(nums2);
        Logger.log("largestNumber result - " + result);
    }

    @Test
    public void testLargestNumber2() {
        int[] nums1 = {10,2}; // 210
        Logger.log("largestNumber");
        Logger.log(nums1);
        String result = ArrayDemo.largestNumber2(nums1);
        Logger.log("largestNumber result - " + result);
        int[] nums2 = {3,30,34,5,9}; // 9534330
        Logger.log("largestNumber");
        Logger.log(nums2);
        result = ArrayDemo.largestNumber2(nums2);
        Logger.log("largestNumber result - " + result);
    }

    @Test
    public void testMaxProfitII1() {
        int[] prices1 = {7,1,5,3,6,4}; // 7
        Logger.log("maxProfitII1");
        Logger.log(prices1);
        int result = ArrayDemo.maxProfitII1(prices1);
        Logger.log("maxProfitII1 result - " + result);
        int[] prices2 = {1,2,3,4,5}; // 4
        Logger.log("maxProfitII1");
        Logger.log(prices2);
        result = ArrayDemo.maxProfitII1(prices2);
        Logger.log("maxProfitII1 result - " + result);
        int[] prices3 = {7,6,4,3,1}; // 0
        Logger.log("maxProfitII1");
        Logger.log(prices3);
        result = ArrayDemo.maxProfitII1(prices3);
        Logger.log("maxProfitII1 result - " + result);
    }

    @Test
    public void testMaxProfitII2() {
        int[] prices1 = {7,1,5,3,6,4}; // 7
        Logger.log("maxProfitII2");
        Logger.log(prices1);
        int result = ArrayDemo.maxProfitII2(prices1);
        Logger.log("maxProfitII2 result - " + result);
        int[] prices2 = {1,2,3,4,5}; // 4
        Logger.log("maxProfitII2");
        Logger.log(prices2);
        result = ArrayDemo.maxProfitII2(prices2);
        Logger.log("maxProfitII2 result - " + result);
        int[] prices3 = {7,6,4,3,1}; // 0
        Logger.log("maxProfitII2");
        Logger.log(prices3);
        result = ArrayDemo.maxProfitII2(prices3);
        Logger.log("maxProfitII2 result - " + result);
    }

    @Test
    public void testMaxProfitII3() {
        int[] prices1 = {7,1,5,3,6,4}; // 7
        Logger.log("maxProfitII3");
        Logger.log(prices1);
        int result = ArrayDemo.maxProfitII3(prices1);
        Logger.log("maxProfitII3 result - " + result);
        int[] prices2 = {1,2,3,4,5}; // 4
        Logger.log("maxProfitII3");
        Logger.log(prices2);
        result = ArrayDemo.maxProfitII3(prices2);
        Logger.log("maxProfitII3 result - " + result);
        int[] prices3 = {7,6,4,3,1}; // 0
        Logger.log("maxProfitII3");
        Logger.log(prices3);
        result = ArrayDemo.maxProfitII3(prices3);
        Logger.log("maxProfitII3 result - " + result);
    }

    @Test
    public void testMaxProfitIII1() {
        int[] prices1 = {1,2,3,0,2}; // 3
        Logger.log("maxProfitIII1");
        Logger.log(prices1);
        int result = ArrayDemo.maxProfitIII1(prices1);
        Logger.log("maxProfitIII1 result - " + result);
    }

    @Test
    public void testMaxProfitIII2() {
        int[] prices1 = {1,2,3,0,2}; // 3
        Logger.log("maxProfitIII2");
        Logger.log(prices1);
        int result = ArrayDemo.maxProfitIII2(prices1);
        Logger.log("maxProfitIII2 result - " + result);
    }

    @Test
    public void testMaxProfitWithFee1() {
        int[] prices1 = {1, 3, 2, 8, 4, 9}; // 8
        Logger.log("maxProfitWithFee1");
        Logger.log(prices1);
        int result = ArrayDemo.maxProfitWithFee1(prices1, 2);
        Logger.log("maxProfitWithFee1 result - " + result);
        int[] prices2 = {1,3,7,5,10,3}; // 6
        Logger.log("maxProfitWithFee1");
        Logger.log(prices2);
        result = ArrayDemo.maxProfitWithFee1(prices2, 3);
        Logger.log("maxProfitWithFee1 result - " + result);
    }

    @Test
    public void testMaxProfitWithFee2() {
        int[] prices1 = {1, 3, 2, 8, 4, 9}; // 8
        Logger.log("maxProfitWithFee2");
        Logger.log(prices1);
        int result = ArrayDemo.maxProfitWithFee2(prices1, 2);
        Logger.log("maxProfitWithFee2 result - " + result);
        int[] prices2 = {1,3,7,5,10,3}; // 6
        Logger.log("maxProfitWithFee2");
        Logger.log(prices2);
        result = ArrayDemo.maxProfitWithFee2(prices2, 3);
        Logger.log("maxProfitWithFee2 result - " + result);
    }

    @Test
    public void testFindUnsortedSubarray1() {
        int[] nums1 = {2,6,4,8,10,9,15}; // 5
        Logger.log("findUnsortedSubarray1");
        Logger.log(nums1);
        int result = ArrayDemo.findUnsortedSubarray1(nums1);
        Logger.log("findUnsortedSubarray1 result - " + result);
        int[] nums2 = {1,2,3,4}; // 0
        Logger.log("findUnsortedSubarray1");
        Logger.log(nums2);
        result = ArrayDemo.findUnsortedSubarray1(nums2);
        Logger.log("findUnsortedSubarray1 result - " + result);
    }

    @Test
    public void testFindUnsortedSubarray2() {
        int[] nums1 = {2,6,4,8,10,9,15}; // 5
        Logger.log("findUnsortedSubarray2");
        Logger.log(nums1);
        int result = ArrayDemo.findUnsortedSubarray2(nums1);
        Logger.log("findUnsortedSubarray2 result - " + result);
        int[] nums2 = {1,2,3,4}; // 0
        Logger.log("findUnsortedSubarray2");
        Logger.log(nums2);
        result = ArrayDemo.findUnsortedSubarray2(nums2);
        Logger.log("findUnsortedSubarray2 result - " + result);
    }

}
