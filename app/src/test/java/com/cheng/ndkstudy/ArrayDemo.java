package com.cheng.ndkstudy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class ArrayDemo {

    /**
     * 查找最大值
     * 有一个整型数组，数组元素不重复，数组元素先升序后降序，
     * 例如：1、3、5、7、9、8、6、4、2，请写一个函数找出数组最大的元素。
     * 思路：
     * 本题可以采用二分法去做。原因：数组一端升序另一端降序。只要找到升序一端的最后一个元素即可。
     * 注意：
     * 由于数组是先升后降，所以第一个元素或最后一个元素不可能是最大元素，查找区间可设定为[1, numsSize - 2]。
     */
    public static int findMax(int[] nums) {
        if (nums == null || nums.length <= 0) return -1;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int left = 1;
        int right = nums.length - 2;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left];
    }

    /**
     * 前 K 个高频元素
     */
    public static int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k < 1) return nums;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        // int[] 的第一个元素代表数组中的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll()[0];
        }
        return result;
    }

    /**
     * 209.长度最小的子数组
     * 给定一个含有n个正整数的数组和一个正整数target。
     * 找出该数组中满足其和≥target的长度最小的连续子数组[numsl, numsl+1, ..., numsr-1, numsr]，
     * 并返回其长度。如果不存在符合条件的子数组，返回0。
     * 输入: s = 7, nums = [2,3,1,2,4,3]
     * 输出: 2
     * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
     */
    // 方法一：暴力法
    public static int minSubArrayLen1(int[] nums, int target) {
        if (nums == null || nums.length <= 0) return 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    // 方法二：滑动窗口
    public static int minSubArrayLen2(int[] nums, int target) {
        if (nums == null || nums.length <= 0) return 0;
        int ans = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int n = nums.length;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    /**
     * 219.存在重复元素 II
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
        if (nums == null || nums.length <= 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num) && i - map.get(num) <= k) {
                return true;
            }
            map.put(num, i);
        }
        return false;
    }

    public static boolean containsNearByDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

}
