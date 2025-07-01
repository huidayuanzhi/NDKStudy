package com.cheng.ndkstudy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

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

}
