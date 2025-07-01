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
        if (nums == null || nums.length <= 1) return nums;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
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
        if (nums == null || nums.length <= 1) return nums;
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
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
        if (nums == null || nums.length <= 1) return nums;
        for (int i = 0; i < nums.length - 1; i++) {
            int curr = nums[i + 1];
            int index = i;
            while (index >= 0 && curr < nums[index]) {
                nums[index + 1] = nums[index];
                index--;
            }
            nums[index + 1] = curr;
        }
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
        if (nums == null || nums.length <= 1) return nums;
        int len = nums.length;
        int gap = len >> 1;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                int temp = nums[i];
                int index = i - gap;
                while (index >= 0 && temp < nums[index]) {
                    nums[index + gap] = nums[index];
                    index -= gap;
                }
                nums[index + gap] = temp;
            }
            gap /= 2;
        }
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
        if (nums == null || nums.length <= 1) return nums;
        int mid = nums.length >> 1;
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, nums.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length) {
                result[index] = right[j++];
            } else if (j >= right.length) {
                result[index] = left[i++];
            } else if (left[i] < right[j]) {
                result[index] = left[i++];
            } else {
                result[index] = right[j++];
            }
        }
        return result;
    }

    /**
     * 快速排序
     * 每一轮排序将一个元素放到正确位置—— > 左侧 && < 右侧
     * 最佳情况：T(n) = O(nlogn)
     * 最差情况：T(n) = O(n2)
     * 平均情况：T(n) = O(nlogn)
     */
    public static int[] quickSort(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int privotpos = partition(nums, left, right);
        quickSort(nums, left, privotpos - 1);
        quickSort(nums, privotpos + 1, right);
    }

    private static int partition(int[] nums, int left, int right) {
        int privot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= privot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= privot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = privot;
        return left;
    }

    /**
     * TODO 堆排序
     */

    /**
     * 计数排序
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
     * 基数排序
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
