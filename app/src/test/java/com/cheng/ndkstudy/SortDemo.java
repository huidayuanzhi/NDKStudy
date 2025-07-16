package com.cheng.ndkstudy;

import java.util.Arrays;

public class SortDemo {

    /**
     * 冒泡排序
     * 每一轮排序大的往上(后)冒泡
     * 最佳情况：T(n) = O(n)
     * 最差情况：T(n) = O(n2)
     * 平均情况：T(n) = O(n2)
     */
    public static int[] bubbleSort(int[] nums) {
        return nums;
    }

    /**
     * 选择排序
     * 每一轮排序小的往下(前)沉
     * 最佳情况：T(n) = O(n2)
     * 最差情况：T(n) = O(n2)
     * 平均情况：T(n) = O(n2)
     */
    public static int[] selectionSort(int[] nums) {
        return nums;
    }

    /**
     * 插入排序
     * 每一轮排序将第n个数插到前面已经排好的序列中
     * 最佳情况：T(n) = O(n)
     * 最坏情况：T(n) = O(n2)
     * 平均情况：T(n) = O(n2)
     */
    public static int[] insertSort(int[] nums) {
        return nums;
    }

    /**
     * 希尔排序
     * 把记录按下标的一定增量分组，对每组使用直接插入排序算法排序
     * 最佳情况：T(n) = O(nlog2n)
     * 最坏情况：T(n) = O(nlog2n)
     * 平均情况：T(n) = O(nlog2n)
     */
    public static int[] shellSort(int[] nums) {
        return nums;
    }

    /**
     * 归并排序
     * 将两个顺序序列合并成一个顺序序列
     * 最佳情况：T(n) = O(n)
     * 最差情况：T(n) = O(nlogn)
     * 平均情况：T(n) = O(nlogn)
     */
    public static int[] mergeSort(int[] nums) {
        return nums;
    }

    /**
     * 快速排序
     * 每一轮排序将一个元素放到正确位置—— > 左侧 && < 右侧
     * 最佳情况：T(n) = O(nlogn)
     * 最差情况：T(n) = O(n2)
     * 平均情况：T(n) = O(nlogn)
     */
    public static int[] quickSort(int[] nums) {
        return nums;
    }

    /**
     * TODO 堆排序
     */

    /**
     * TODO 计数排序
     * 将输入的数据值转化为键存储在额外开辟的数组空间中
     * 最佳情况：T(n) = O(n+k)
     * 最差情况：T(n) = O(n+k)
     * 平均情况：T(n) = O(n+k)
     */
    public static int[] countSort(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;
        int min = nums[0];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
            }
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        int bias = -min;
        int[] bucket = new int[max - min + 1];
        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i] + bias] += 1;
        }
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            int count = bucket[i];
            while (count > 0) {
                nums[index++] = i - bias;
                count--;
            }
        }
        return nums;
    }

    /**
     * TODO 基数排序
     * 思路：按个、十、百位依次归类排序
     */
    public static int[] radixSort(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;
        int min = nums[0];
        int max = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] -= min;
        }
        max -= min;
        int maxLen = (max + "").length();
        int[][] bucket = new int[nums.length][10];
        int[] bucketCount = new int[10];
        for (int i = 0, n = 1; i < maxLen; i++, n *= 10) {
            for (int num : nums) {
                int digitVal = num / n % 10;
                bucket[bucketCount[digitVal]][digitVal] = num;
                bucketCount[digitVal]++;
            }
            int index = 0;
            for (int j = 0; j < bucketCount.length; j++) {
                if (bucketCount[j] > 0) {
                    for (int k = 0; k < bucketCount[j]; k++) {
                        nums[index] = bucket[k][j];
                        index++;
                    }
                }
                bucketCount[j] = 0;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] += min;
        }
        return nums;
    }
}
