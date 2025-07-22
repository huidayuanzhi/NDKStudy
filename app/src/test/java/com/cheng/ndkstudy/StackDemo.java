package com.cheng.ndkstudy;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class StackDemo {

    /**
     * 496. 下一个更大元素 I
     * nums1 中数字 x 的 下一个更大元素是指 x 在 nums2 中对应位置右侧的第一个比 x 大的元素。
     * 示例 1：
     * 输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
     * 输出：[-1,3,-1]
     * 示例 2：
     * 输入：nums1 = [2,4], nums2 = [1,2,3,4].
     * 输出：[3,-1]
     */
    // 方法一：暴力
    public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length <= 0 || nums2.length <= 0) return new int[0];
        int m = nums1.length;
        int n = nums2.length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int j = 0;
            while (j < n && nums2[j] != nums1[i]) {
                j++;
            }
            int k = j + 1;
            while (k < n && nums2[k] < nums1[i]) {
                k++;
            }
            res[i] = k < n ? nums2[k] : -1;
        }
        return res;
    }

    // 方法二：单调栈 + 哈希表
    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length <= 0 || nums2.length <= 0) return new int[0];
        int m = nums1.length;
        int n = nums2.length;
        int[] res = new int[m];
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        for (int i = n - 1; i >= 0; i--) {
            int num = nums2[i];
            while (!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }
        for (int i = 0; i < m; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }

    /**
     * 503. 下一个更大元素 II
     * 给定一个循环数组 nums，返回 nums 中每个元素的下一个更大元素。
     * 示例 1:
     * 输入: nums = [1,2,1]
     * 输出: [2,-1,2]
     * 示例 2:
     * 输入: nums = [1,2,3,4,3]
     * 输出: [2,3,4,-1,4]
     */
    // 方法一：单调栈 + 循环数组
    // 可以把这个循环数组「拉直」，即复制该序列的前 n−1 个元素拼接在原序列的后面。
    // 这样就可以将这个新序列当作普通序列。在这里只需要在处理时对下标取模即可。
    public static int[] nextGreaterElementsII(int[] nums) {
        if (nums == null || nums.length <= 0) return new int[0];
        int n = nums.length;
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < 2 * n - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                res[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return res;
    }


}
