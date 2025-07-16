package com.cheng.ndkstudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class ArrayDemo {

    /**
     * 查找最大值 - 二分法
     * 有一个整型数组，数组元素不重复，数组元素先升序后降序，
     * 例如：1、3、5、7、9、8、6、4、2，请写一个函数找出数组最大的元素。
     * 思路：
     * 本题可以采用二分法去做。原因：数组一端升序另一端降序。只要找到升序一端的最后一个元素即可。
     * 注意：
     * 由于数组是先升后降，所以第一个元素或最后一个元素不可能是最大元素，查找区间可设定为[1, numsSize - 2]。
     */
    public static int findMax(int[] nums) {
        return 0;
    }

    /**
     * 前 K 个高频元素 - 哈希 + 优先级队列
     */
    public static int[] topKFrequent(int[] nums, int k) {
        return null;
    }

    /**
     * 209.长度最小的子数组 - 滑动窗口
     * 给定一个含有n个正整数的数组和一个正整数target。
     * 找出该数组中满足其和≥target的长度最小的连续子数组[numsl, numsl+1, ..., numsr-1, numsr]，
     * 并返回其长度。如果不存在符合条件的子数组，返回0。
     * 输入: s = 7, nums = [2,3,1,2,4,3]
     * 输出: 2
     * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
     */
    // 方法一：暴力法
    public static int minSubArrayLen1(int[] nums, int target) {
        return 0;
    }

    // 方法二：滑动窗口
    public static int minSubArrayLen2(int[] nums, int target) {
        return 0;
    }

    /**
     * 219.存在重复元素 II - 哈希
     * 给你一个整数数组nums和一个整数k，判断数组中是否存在两个不同的索引i和j，满足nums[i] == nums[j]
     * 且abs(i - j) <= k。如果存在，返回true；否则，返回false。
     * 示例 1：
     * 输入：nums = [1,2,3,1], k = 3
     * 输出：true
     * 示例 2：
     * 输入：nums = [1,0,1,1], k = 1
     * 输出：true
     * 示例 3：
     * 输入：nums = [1,2,3,1,2,3], k = 2
     * 输出：false
     */
    public static boolean containsNearByDuplicate1(int[] nums, int k) {
        return false;
    }

    public static boolean containsNearByDuplicate2(int[] nums, int k) {
        return false;
    }

    /**
     * 283.移动零 - 双指针
     * 给定一个数组nums，编写一个函数将所有0移动到数组的末尾，同时保持非零元素的相对顺序。
     * 请注意，必须在不复制数组的情况下原地对数组进行操作。
     * 方法一：双指针
     * 思路及解法
     * 使用双指针，左指针指向当前已经处理好的序列的尾部，右指针指向待处理序列的头部。
     * 右指针不断向右移动，每次右指针指向非零数，则将左右指针对应的数交换，同时左指针右移。
     * 注意到以下性质：
     * — 左指针左边均为非零数
     * - 右指针左边直到左指针处均为零
     */
    public static void moveZeroes1(int[] nums) {

    }

    public static void moveZeroes2(int[] nums) {

    }

    /**
     * 674.最长连续递增序列 - 贪心
     * 给定一个未经排序的整数数组，找到最长且连续递增的子序列，并返回该序列的长度。
     * 思路：
     * 使用贪心的策略得到尽可能长的连续递增序列。做法是使用记录当前连续递增序列的开始下标和结束下标，
     * 遍历数组的过程中每次比较相邻元素，根据相邻元素的大小关系决定是否需要更新连续递增序列的开始下标。
     */
    public static int findLengthOfLCIS1(int[] nums) {
        return 0;
    }

    public static int findLengthOfLCIS2(int[] nums) {
        return 0;
    }

    /**
     * 128.最长连续序列 - 哈希
     * 给定一个未排序的整数数组nums，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     * 示例 1：
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     */
    public static int longestConsecutive(int[] nums) {
        return 0;
    }

    /**
     * 11.盛最多水的容器 - 双指针
     * 给你n个非负整数a1，a2，...，an，每个数代表坐标中的一个点(i, ai)。
     * 在坐标内画n条垂直线，垂直线i的两个端点分别为(i, ai)和(i, 0)。
     * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
     * 思路：双指针法
     */
    public static int maxArea(int[] height) {
        return 0;
    }

    /**
     * 26.删除有序数组中的重复项 - 快慢指针
     * 给你一个升序排列的数组nums，请你原地删除重复出现的元素，使每个元素只出现一次，返回删除后数组
     * 的新长度。元素的相对顺序应该保持一致。
     * 示例 2：
     * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
     * 输出：5, nums = [0,1,2,3,4]
     */
    public static int removeDuplicates(int[] nums) {
        return 0;
    }

    /**
     * TODO 1248.统计「优美子数组」!!!
     */

    /**
     * 560.和为K的子数组 - 前缀和 + 哈希
     * 给你一个整数数组nums和一个整数k，请你统计并返回该数组中和为k的连续子数组的个数。
     * 示例 1 :
     * 输入:nums = [1,1,1], k = 2
     * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
     * 示例 2 :
     * 输入：nums = [1,2,3], k = 3
     * 输出：2
     */
    // 方法一：枚举
    public static int subarraySum1(int[] nums, int k) {
        return 0;
    }

    // 方法二：前缀和 + 哈希表优化
    public static int subarraySum2(int[] nums, int k) {
        return 0;
    }

    /**
     * 974.和可被K整除的子数组 - 前缀和 + 哈希
     * 给定一个整数数组nums和一个整数k，返回其中元素之和可被k整除的（连续、非空）子数组的数目
     * 示例 1：
     * 输入：nums = [4,5,0,-2,-3,1], k = 5
     * 输出：7
     * 解释：
     * 有 7 个子数组满足其元素之和可被 k = 5 整除：
     * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
     */
    // 暴力法
    public static int subarraysDivByK1(int[] nums, int k) {
        return 0;
    }

    // 哈希表 + 逐一统计
    // 思路和算法
    // 通常，涉及连续子数组问题的时候，我们使用前缀和来解决。
    public static int subarraysDivByK2(int[] nums, int k) {
        return 0;
    }

    // 哈希表 + 单次统计
    // 可以在遍历时维护哈希表。在遍历结束后，我们再遍历哈希表，用排列组合的方法来统计答案。
    public static int subarraysDivByK3(int[] nums, int k) {
        return 0;
    }

    /**
     * 1.两数之和 - 哈希
     * 给定一个整数数组nums和一个整数目标值target，请你在该数组中找出和为目标值target的那两个整数，
     * 并返回它们的数组下标。
     * 示例 1：
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1]
     */
    // 暴力枚举
    public static int[] twoSum1(int[] nums, int target) {
        return null;
    }

    // 哈希表
    public static int[] twoSum2(int[] nums, int target) {
        return null;
    }

    /**
     * 167.两数之和 II - 输入有序数组 - 双指针
     * 给你一个下标从1开始的整数数组numbers，该数组已按非递减顺序排列，请你从数组中找出满足相加之和
     * 等于目标数target的两个数。如果设这两个数分别是numbers[index1]和numbers[index2]，则1 <=
     * index1 < index2 <= numbers.length。
     */
    // 双指针
    public static int[] twoSumII1(int[] nums, int target) {
        return null;
    }

    public static int[] twoSumII2(int[] nums, int target) {
        return null;
    }

    /**
     * 15.三数之和 - 排序 + 双指针
     * 给你一个包含n个整数的数组nums，判断nums中是否存在三个元素a，b，c，使得a + b + c = 0？
     * 请你找出所有和为0且不重复的三元组。
     * 排序 + 双指针
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * 解释：
     * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
     * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
     * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
     * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
     * 注意，输出的顺序和三元组的顺序并不重要。
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        return null;
    }

    /**
     * 18.四数之和 - 排序 + 双指针
     * 给你一个由n个整数组成的数组nums，和一个目标值target。请你找出并返回满足下述全部条件且不重复的
     * 四元组[nums[a], nums[b], nums[c], nums[d]]
     * 示例 1：
     * 输入：nums = [1,0,-1,0,-2,2], target = 0
     * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        return null;
    }

    /**
     * 55. 跳跃游戏 - 贪心
     * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
     * 示例 1：
     * 输入：nums = [2,3,1,1,4]
     * 输出：true
     * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     * 示例 2：
     * 输入：nums = [3,2,1,0,4]
     * 输出：false
     * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0，所以永远不可能到达最后一个下标。
     */
    public static boolean canJump(int[] nums) {
        return false;
    }

    /**
     * 45.跳跃游戏 II - 贪心
     * 给你一个非负整数数组nums，你最初位于数组的第一个位置。数组中的每个元素代表你在该位置可以跳跃的
     * 最大长度。你的目标是使用最少的跳跃次数到达数组的最后一个位置。假设总是可以到达数组的最后一个位置。
     * 示例 1:
     * 输入: nums = [2,3,1,1,4]
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。
     *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
     * 示例 2:
     * 输入: nums = [2,3,0,1,4]
     * 输出: 2
     */
    // 方法一：反向查找出发位置
    public static int jumpII1(int[] nums) {
        return 0;
    }

    // 方法二：正向查找可到达的最大位置
    public static int jumpII2(int[] nums) {
        return 0;
    }

    /**
     * 62.不同路径
     * 一个机器人位于一个 m x n 网格的左上角，机器人每次只能向下或者向右移动一步。机器人试图达到网格的
     * 右下角。问总共有多少条不同的路径？
     * 示例 1：
     * 输入：m = 3, n = 7
     * 输出：28
     * 示例 2：
     *
     * 输入：m = 3, n = 2
     * 输出：3
     * 解释：
     * 从左上角开始，总共有 3 条路径可以到达右下角。
     * 1. 向右 -> 向下 -> 向下
     * 2. 向下 -> 向下 -> 向右
     * 3. 向下 -> 向右 -> 向下
     */
    // 方法一：动态规划
    // 用 f(i,j) 表示从左上角走到 (i,j) 的路径数量，其中 i 和 j 的范围分别是 [0,m) 和 [0,n)。
    // 由于每一步只能从向下或者向右移动一步，因此要想走到 (i,j)，如果向下走一步，那么会从 (i−1,j) 走过来；
    // 如果向右走一步，那么会从 (i,j−1) 走过来。因此可以写出动态规划转移方程：
    // f(i,j) = f(i−1,j) + f(i,j−1)
    public static int uniquePaths1(int m, int n) {
        return 0;
    }

    // 方法二：动态规划 + 滚动数组
    public static int uniquePaths2(int m, int n) {
        return 0;
    }

    /**
     * 63.不同路径 II
     * 一个机器人位于一个 m x n 网格的左上角，机器人每次只能向下或者向右移动一步。机器人试图达到网格的
     * 右下角。现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     * 网格中的障碍物和空位置分别用 1 和 0 来表示。
     * 示例 1：
     * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
     * 输出：2
     * 解释：3x3 网格的正中间有一个障碍物。
     * 从左上角到右下角一共有 2 条不同的路径：
     * 1. 向右 -> 向右 -> 向下 -> 向下
     * 2. 向下 -> 向下 -> 向右 -> 向右
     * 示例 2：
     * 输入：obstacleGrid = [[0,1],[0,0]]
     * 输出：1
     */
    // 动态规划
    public static int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        return 0;
    }

    // 动态规划 + 滚动数组
    public static int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        return 0;
    }

    /**
     * 452. 用最少数量的箭引爆气球
     * 气球记录在整数数组 points，其中 points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend 之间的气球。
     * 给你一个数组 points，返回引爆所有气球所必须射出的 最小 弓箭数。
     * 示例 1：
     * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
     * 输出：2
     * 解释：气球可以用2支箭来爆破:
     * -在x = 6处射出箭，击破气球[2,8]和[1,6]。
     * -在x = 11处发射箭，击破气球[10,16]和[7,12]。
     * 示例 2：
     * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
     * 输出：4
     * 解释：每个气球需要射出一支箭，总共需要4支箭。
     * 示例 3：
     * 输入：points = [[1,2],[2,3],[3,4],[4,5]]
     * 输出：2
     * 解释：气球可以用2支箭来爆破:
     * - 在x = 2处发射箭，击破气球[1,2]和[2,3]。
     * - 在x = 4处射出箭，击破气球[3,4]和[4,5]。
     */
    public static int findMinArrowShots(int[][] points) {
        return 0;
    }

    /**
     * 435.无重叠区间
     * 给定一个区间的集合intervals，其中intervals[i]=[starti, endi]。返回需要移除区间的最小数量，
     * 使剩余区间互不重叠。
     * 示例 1:
     * 输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
     * 输出: 1
     * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
     * 示例 2:
     * 输入: intervals = [[1,2], [1,2], [1,2]]
     * 输出: 2
     * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
     * 示例 3:
     * 输入: intervals = [[1,2], [2,3]]
     * 输出: 0
     * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
     */
    // 方法一：动态规划
    // 选出最多数量的区间，使得它们互不重叠，令 f(i) 表示「以区间 i 为最后一个区间，可以选出的区间数量的最大值」
    public static int eraseOverlapIntervals1(int[][] intervals) {
        return 0;
    }

    // 方法二：贪心
    // 首个区间就是所有可以选择的区间中右端点最小的那个区间
    public static int eraseOverlapIntervals2(int[][] intervals) {
        return 0;
    }

    /**
     * 56.合并区间
     * 以数组intervals表示若干个区间的集合，其中单个区间为intervals[i]=[starti, endi]。请你合并
     * 所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
     * 示例 1：
     * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * 示例 2：
     * 输入：intervals = [[1,4],[4,5]]
     * 输出：[[1,5]]
     * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
     */
    public static int[][] merge(int[][] intervals) {
        return null;
    }

    /**
     * 57.插入区间
     * 给你一个无重叠的，按照区间起始端点排序的区间列表。
     * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
     * 示例 1：
     * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
     * 输出：[[1,5],[6,9]]
     * 示例 2：
     * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
     * 输出：[[1,2],[3,10],[12,16]]
     * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
     */
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        return null;
    }

    /**
     * 646.最长数对链
     * 给出 n 个数对。在每一个数对中，第一个数字总是比第二个数字小。
     * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d)才可以跟在(a, b)后面。我们用这种
     * 形式来构造一个数对链。
     * 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其
     * 中的一些数对来构造。
     * 示例 1：
     * 输入：pairs = [[1,2], [2,3], [3,4]]
     * 输出：2
     * 解释：最长的数对链是 [1,2] -> [3,4] 。
     * 示例 2：
     * 输入：pairs = [[1,2],[7,8],[4,5]]
     * 输出：3
     * 解释：最长的数对链是 [1,2] -> [4,5] -> [7,8] 。
     */
    // 方法一：动态规划
    public static int findLongestChain1(int[][] pairs) {
        return 0;
    }

    // 方法三：贪心
    public static int findLongestChain3(int[][] pairs) {
        return 0;
    }

    /**
     * 64.最小路径和
     * 给定一个包含非负整数的mxn网格grid，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     * 说明：每次只能向下或者向右移动一步。
     * 示例 1：
     * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
     * 输出：7
     * 解释：因为路径 1→3→1→1→1 的总和最小。
     * 示例 2：
     * 输入：grid = [[1,2,3],[4,5,6]]
     * 输出：12
     */
    public static int minPathSum(int[][] grid) {
        return 0;
    }

    /**
     * 70.爬楼梯
     * 假设你正在爬楼梯，需要n阶你才能到达楼顶。每次可以爬1或2个台阶，
     * 有多少种不同的方法可以爬到楼顶呢？
     * 示例 1：
     * 输入：n = 2
     * 输出：2
     * 解释：有两种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶
     * 2. 2 阶
     * 示例 2：
     * 输入：n = 3
     * 输出：3
     * 解释：有三种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶 + 1 阶
     * 2. 1 阶 + 2 阶
     * 3. 2 阶 + 1 阶
     */
    public static int climbStairs1(int n) {
        return 0;
    }

    public static int climbStairs2(int n) {
        return 0;
    }

    /**
     * 91. 解码方法 - 动态规划
     * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
     * "1" -> 'A'
     * "2" -> 'B'
     * 然而，在解码已编码的消息时，你意识到有许多不同的方式来解码，
     * 因为有些编码被包含在其它编码当中（"2" 和 "5" 与 "25"）。
     * 示例 1：
     * 输入：s = "12"
     * 输出：2
     * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
     * 示例 2：
     * 输入：s = "226"
     * 输出：3
     * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
     * 示例 3：
     * 输入：s = "06"
     * 输出：0
     * 解释："06" 无法映射到 "F" ，因为存在前导零（"6" 和 "06" 并不等价）。
     */
    public static int numDecoding1(String s) {
        return 0;
    }

    public static int numDecoding2(String s) {
        return 0;
    }

    /**
     * TODO 96.不同的二叉搜索树
     * TODO 95.不同的二叉搜索树 II
     */

    /**
     * 875.爱吃香蕉的珂珂 - 二分查找
     * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）
     * 示例 1：
     * 输入：piles = [3,6,7,11], h = 8
     * 输出：4
     * 示例 2：
     * 输入：piles = [30,11,23,4,20], h = 5
     * 输出：30
     * 示例 3：
     * 输入：piles = [30,11,23,4,20], h = 6
     * 输出：23
     */
    public static int minEatingSpeed(int[] piles, int h) {
        return 0;
    }

    /**
     * 1011. 在 D 天内送达包裹的能力 - 二分查找转化为判定问题
     * 按给出重量（weights）的顺序往传送带上装载包裹，装载的重量不会超过船的最大运载重量。
     * 返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力。
     * 示例 1：
     * 输入：weights = [1,2,3,4,5,6,7,8,9,10], days = 5
     * 输出：15
     * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
     * 示例 2：
     * 输入：weights = [3,2,2,4,1,4], days = 3
     * 输出：6
     * 示例 3：
     * 输入：weights = [1,2,3,1,1], days = 4
     * 输出：3
     */
    public static int shipWithinDays(int[] weights, int days) {
        return 0;
    }

    /**
     * 69.x的平方根 - 二分查找
     * 返回类型是整数，结果只保留整数部分，小数部分将被舍去
     * 示例 1：
     * 输入：x = 4
     * 输出：2
     * 示例 2：
     * 输入：x = 8
     * 输出：2
     */
    public static int mySqrt(int x) {
        return 0;
    }

    /**
     * 34. 在排序数组中查找元素的第一个和最后一个位置 - 二分查找
     * 示例 1：
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     * 示例 2：
     * 输入：nums = [5,7,7,8,8,10], target = 6
     * 输出：[-1,-1]
     */
    public static int[] searchRange(int[] nums, int target) {
        return null;
    }

    /**
     * 300. 最长递增子序列 - 动态规划
     * 给你一个整数数组 nums，找到其中最长严格递增子序列的长度。
     * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素
     * 而不改变其余元素的顺序。
     * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
     * 示例 1：
     * 输入：nums = [10,9,2,5,3,7,101,18]
     * 输出：4
     * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
     * 示例 2：
     * 输入：nums = [0,1,0,3,2,3]
     * 输出：4
     * 示例 3：
     * 输入：nums = [7,7,7,7,7,7,7]
     * 输出：1
     */
    // 定义 dp[i] 为考虑前 i 个元素，以第 i 个数字结尾的最长上升子序列的长度，注意 nums[i] 必须被选取。
    public static int lengthOfLIS(int[] nums) {
        return 0;
    }

    /**
     * TODO 322. 零钱兑换
     * 给你一个整数数组 coins，表示不同面额的硬币；以及一个整数 amount，表示总金额。
     * 计算并返回可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1 。
     * 你可以认为每种硬币的数量是无限的。
     * 示例 1：
     * 输入：coins = [1, 2, 5], amount = 11
     * 输出：3
     * 解释：11 = 5 + 5 + 1
     * 示例 2：
     * 输入：coins = [2], amount = 3
     * 输出：-1
     * 示例 3：
     * 输入：coins = [1], amount = 0
     * 输出：0
     */

    /**
     * 221. 最大正方形
     * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
     * 示例 1：
     * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
     * 输出：4
     * 示例 2：
     * 输入：matrix = [["0","1"],["1","0"]]
     * 输出：1
     * 示例 3：
     * 输入：matrix = [["0"]]
     * 输出：0
     */
    // 方法一：暴力法
    public static int maximalSquare1(char[][] matrix) {
        return 0;
    }

    // 方法二：动态规划
    // 用 dp(i,j) 表示以 (i,j) 为右下角，且只包含 1 的正方形的边长最大值
    public static int maximalSquare2(char[][] matrix) {
        return 0;
    }

    /**
     * 695. 岛屿的最大面积
     * 示例 1：
     * 输入：grid =
     *  [[0,0,1,0,0,0,0,1,0,0,0,0,0],
     *   [0,0,0,0,0,0,0,1,1,1,0,0,0],
     *   [0,1,1,0,1,0,0,0,0,0,0,0,0],
     *   [0,1,0,0,1,1,0,0,1,0,1,0,0],
     *   [0,1,0,0,1,1,0,0,1,1,1,0,0],
     *   [0,0,0,0,0,0,0,0,0,0,1,0,0],
     *   [0,0,0,0,0,0,0,1,1,1,0,0,0],
     *   [0,0,0,0,0,0,0,1,1,0,0,0,0]]
     * 输出：6
     * 解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
     */
    // 方法一：深度优先搜索
    public static int maxAreaOfIsland1(int[][] grid) {
        return 0;
    }

    // 方法二：深度优先搜索 + 栈
    public static int maxAreaOfIsland2(int[][] grid) {
        return 0;
    }

    // 方法三：广度优先搜索
    public static int maxAreaOfIsland3(int[][] grid) {
        return 0;
    }

    /**
     * 152. 乘积最大子数组
     * 找出数组中乘积最大的非空连续 子数组
     * 示例 1:
     * 输入: nums = [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     * 示例 2:
     * 输入: nums = [-2,0,-1]
     * 输出: 0
     * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
     */
    public static int maxProduct1(int[] nums) {
        return 0;
    }

    public static int maxProduct2(int[] nums) {
        return 0;
    }

    /**
     * 46.全排列
     * 给定一个不含重复数字的数组nums，返回其所有可能的全排列。
     * 可以按任意顺序返回答案。
     * 示例 1：
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * 示例 2：
     * 输入：nums = [0,1]
     * 输出：[[0,1],[1,0]]
     */
    public static List<List<Integer>> premute(int[] nums) {
        return null;
    }

    /**
     * 47. 全排列 II
     * 给定一个可包含重复数字的序列 nums，按任意顺序返回所有不重复的全排列。
     * 示例 1：
     * 输入：nums = [1,1,2]
     * 输出：
     * [[1,1,2],
     *  [1,2,1],
     *  [2,1,1]]
     * 示例 2：
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        return null;
    }

    /**
     * 78. 子集
     * 给你一个整数数组 nums，数组中的元素互不相同。返回该数组所有可能的子集（幂集）。
     * 解集不能包含重复的子集。可以按任意顺序返回解集。
     * 示例 1：
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * 示例 2：
     * 输入：nums = [0]
     * 输出：[[],[0]]
     * https://zhuanlan.zhihu.com/p/128025509
     */
    // 方法一：递归
    // 开始假设输出子集为空，每一步都向已生成的子集添加新的整数，并生成新的子集
    public static List<List<Integer>> subsets1(int[] nums) {
        return null;
    }

    // 方法二：回溯
    // 幂集是所有长度从 0 到 n 所有子集的组合
    // 根据定义，该问题可以看作是从序列中生成幂集
    // 遍历子集长度，通过回溯生成所有给定长度的子集
    public static List<List<Integer>> subsets2(int[] nums) {
        return null;
    }

    /**
     * 22. 括号生成
     * 数字 n 代表生成括号的对数，设计一个函数，用于能够生成所有可能的并且有效的括号组合。
     * 示例 1：
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     * 示例 2：
     * 输入：n = 1
     * 输出：["()"]
     */
    // 剩余左括号总数要小于等于右括号，递归把所有符合要求的加上去就行了
    public static List<String> generateParenthesis(int n) {
        return null;
    }

    /**
     * TODO 93. 复原 IP 地址
     * 有效 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），
     * 整数之间用 '.' 分隔。
     * 给定一个只包含数字的字符串 s，用以表示一个 IP 地址，返回所有可能的有效 IP 地址
     * 示例 1：
     * 输入：s = "25525511135"
     * 输出：["255.255.11.135","255.255.111.35"]
     * 示例 2：
     * 输入：s = "0000"
     * 输出：["0.0.0.0"]
     * 示例 3：
     * 输入：s = "101023"
     * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
     */

    /**
     * 53. 最大子数组和
     * 给你一个整数数组 nums，找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 示例 1：
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     * 示例 2：
     * 输入：nums = [1]
     * 输出：1
     * 示例 3：
     * 输入：nums = [5,4,-1,7,8]
     * 输出：23
     */
    public static int maxSubArray(int[] nums) {
        return 0;
    }

    /**
     * 118.杨辉三角
     * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
     * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
     * 示例 1:
     * 输入: numRows = 5
     * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
     */
    public static List<List<Integer>> generatePascalsTriangle(int numRows) {
        return null;
    }

    /**
     * 119. 杨辉三角 II
     * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
     * 示例 1:
     * 输入: rowIndex = 3
     * 输出: [1,3,3,1]
     * 示例 2:
     * 输入: rowIndex = 1
     * 输出: [1,1]
     */
    // 方法一：滚动数组
    public static List<Integer> getPascalsTriangleRow1(int rowIndex) {
        return null;
    }

    // 方法二：倒着计算
    public static List<Integer> getPascalsTriangleRow2(int rowIndex) {
        return null;
    }

    /**
     * 120. 三角形最小路径和
     * 给定一个三角形 triangle，找出自顶向下的最小路径和。
     * 每一步只能移动到下一行中相邻的结点上。
     * 示例 1：
     * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
     * 输出：11
     * 解释：如下面简图所示：
     *    2
     *   3 4
     *  6 5 7
     * 4 1 8 3
     * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
     */
    // 动态规划
    public static int minimumTotal1(List<List<Integer>> triangle) {
        return 0;
    }

    // 滚动数组 + 倒着计算
    public static int minimumTotal2(List<List<Integer>> triangle) {
        return 0;
    }

    /**
     * TODO 456.132 模式
     * 给你一个整数数组 nums，数组中共有n个整数。132模式的子序列由三个整数nums[i]、nums[j]和nums[k]
     * 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j]。
     * 如果 nums 中存在132模式的子序列，返回true；否则，返回false。
     * 示例 1：
     * 输入：nums = [1,2,3,4]
     * 输出：false
     * 解释：序列中不存在 132 模式的子序列。
     * 示例 2：
     * 输入：nums = [3,1,4,2]
     * 输出：true
     * 解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
     * 示例 3：
     * 输入：nums = [-1,3,2,0]
     * 输出：true
     * 解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
     */

    /**
     * 643. 子数组最大平均数 I
     * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k。
     * 请你找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
     * 示例 1：
     * 输入：nums = [1,12,-5,-6,50,3], k = 4
     * 输出：12.75
     * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
     * 示例 2：
     * 输入：nums = [5], k = 1
     * 输出：5.00000
     */
    public static double findMaxAverage(int[] nums, int k) {
        return 0;
    }

    /**
     * 121. 买卖股票的最佳时机
     * 给定一个数组 prices，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     * 你只能选择某一天买入这只股票，并选择在未来的某一个不同的日子卖出该股票。
     * 设计一个算法来计算你所能获取的最大利润。
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0。
     * 示例 1：
     * 输入：[7,1,5,3,6,4]
     * 输出：5
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     * 示例 2：
     * 输入：prices = [7,6,4,3,1]
     * 输出：0
     * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
     */
    // 方法一：暴力法
    public static int maxProfit1(int[] prices) {
        return 0;
    }

    // 方法二：一次遍历
    public static int maxProfit2(int[] prices) {
        return 0;
    }

    public static int maxProfit3(int[] prices) {
        return 0;
    }

    /**
     * 134. 加油站 - 贪心
     * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
     * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站
     * 需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
     * 给定两个整数数组 gas 和 cost，如果你可以按顺序绕环路行驶一周，
     * 则返回出发时加油站的编号，否则返回 -1。如果存在解，则保证它是唯一的。
     * 示例 1:
     * 输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
     * 输出: 3
     * 解释:
     * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
     * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
     * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
     * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
     * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
     * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
     * 因此，3 可为起始索引。
     */
    // 一次遍历
    // 首先检查第 0 个加油站，并试图判断能否环绕一周；
    // 如果不能，就从第一个无法到达的加油站开始继续检查
    public static int canCompleteCircuit1(int[] gas, int[] cost) {
        return -1;
    }

    // 可以想象出发前向别人借了足够的油量，走完一圈只要能还上就行了
    public static int canCompleteCircuit2(int[] gas, int[] cost) {
        return 0;
    }

    /**
     * 179.最大数
     * 给定一组非负整数nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
     * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
     * 示例 1：
     * 输入：nums = [10,2]
     * 输出："210"
     * 示例 2：
     * 输入：nums = [3,30,34,5,9]
     * 输出："9534330"
     */
    public static String largestNumber1(int[] nums) {
        return "";
    }

    public static String largestNumber2(int[] nums) {
        return "";
    }

    /**
     * 122.买卖股票的最佳时机 II
     * 给你一个整数数组prices，其中prices[i]表示某支股票第i天的价格。
     * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候最多只能持有一股股票。你也可以先购买，然
     * 后在同一天出售。
     * 返回你能获得的最大利润。
     * 示例 1：
     * 输入：prices = [7,1,5,3,6,4]
     * 输出：7
     * 示例 2：
     * 输入：prices = [1,2,3,4,5]
     * 输出：4
     * 示例 3：
     * 输入：prices = [7,6,4,3,1]
     * 输出：0
     */
    // 方法一：动态规划
    public static int maxProfitII1(int[] prices) {
        return 0;
    }
    // 方法一：动态规划 + 空间优化
    public static int maxProfitII2(int[] prices) {
        return 0;
    }
    // 方法二：贪心
    public static int maxProfitII3(int[] prices) {
        return 0;
    }

    /**
     * 309. 买卖股票的最佳时机含冷冻期 - 动态规划
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * 示例 1:
     * 输入: prices = [1,2,3,0,2]
     * 输出: 3
     * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
     */
    // 动态规划
    public static int maxProfitIII1(int[] prices) {
        return 0;
    }

    public static int maxProfitIII2(int[] prices) {
        return 0;
    }

    /**
     * 714. 买卖股票的最佳时机含手续费
     * 示例 1：
     * 输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
     * 输出：8
     * 解释：能够达到的最大利润:
     * 在此处买入 prices[0] = 1
     * 在此处卖出 prices[3] = 8
     * 在此处买入 prices[4] = 4
     * 在此处卖出 prices[5] = 9
     * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8
     * 示例 2：
     * 输入：prices = [1,3,7,5,10,3], fee = 3
     * 输出：6
     */
    // 动态规划
    public static int maxProfitWithFee1(int[] prices, int fee) {
        return 0;
    }

    public static int maxProfitWithFee2(int[] prices, int fee) {
        return 0;
    }

    /**
     * 581.最短无序连续子数组
     * 给你一个整数数组nums，你需要找出一个连续子数组，如果对这个子数组进行升序排序，那么整个数组都会变
     * 为升序排序。请你找出符合题意的最短子数组，并输出它的长度。
     * 示例 1：
     * 输入：nums = [2,6,4,8,10,9,15]
     * 输出：5
     * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
     * 示例 2：
     * 输入：nums = [1,2,3,4]
     * 输出：0
     */
    // 方法一：排序
    public static int findUnsortedSubarray1(int[] nums) {
        return 0;
    }

    private static boolean isSorted(int[] nums) {

        return true;
    }

    // 方法二：一次遍历
    /*
    1.从左到右看，数应该越来越大，如果某个数，比前面最大值大，那它没问题，如果小于前面的最大值，那么这个数就有问题
    2.从左到右不断更新最大值，遇到有问题的数，就记录下来作为right，并且right可以更新
    3.right更新到最后面不动了，说明right右边的数都比，right左边的max的数大，但是right自己比max小，right右边是排好序的，right左边需要重新排序，right是需要重新排序的区间的右边界
    4.left同理，left就是从右往左看，数要越来越小才行，如果某个数，比右边最小值还要小，那它没问题，如果它比右边的最小值要大，说明它有问题
     */
    public static int findUnsortedSubarray2(int[] nums) {
        return 0;
    }

}
