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

    /**
     * 283.移动零
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
        if (nums == null || nums.length <= 1) return;
        int n = nums.length;
        int left = 0;
        int right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums,left, right);
                left++;
            }
            right++;
        }
    }
    
    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    
    public static void moveZeroes2(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        for (int i = 0, j = 0; i < nums.length; i++) {
            // 当前元素!=0，就把其交换到左边，等于0的交换到右边
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }

    /**
     * 674.最长连续递增序列
     * 给定一个未经排序的整数数组，找到最长且连续递增的子序列，并返回该序列的长度。
     * 思路：
     * 使用贪心的策略得到尽可能长的连续递增序列。做法是使用记录当前连续递增序列的开始下标和结束下标，
     * 遍历数组的过程中每次比较相邻元素，根据相邻元素的大小关系决定是否需要更新连续递增序列的开始下标。
     */
    public static int findLengthOfLCIS1(int[] nums) {
        if (nums == null || nums.length <= 0) return 0;
        if (nums.length == 1) return 1;
        int ans = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] < nums[i - 1]) {
                start = i;
            }
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }

    public static int findLengthOfLCIS2(int[] nums) {
        if (nums == null || nums.length <= 0) return 0;
        if (nums.length == 1) return 1;
        int result = 1;
        int tempResult = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                tempResult++;
            } else {
                tempResult = 1;
            }
            result = Math.max(result, tempResult);
        }
        return result;
    }

    /**
     * 128.最长连续序列
     * 给定一个未排序的整数数组nums，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     * 示例 1：
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     */
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length <= 0) return 0;
        if (nums.length == 1) return 1;
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longestStreak = 0;
        for (int num : numSet) {
            // 当前数num如果存在前驱数，就应该以该前驱数的前驱数为起点，所以直接跳过
            if (!numSet.contains(num - 1)) {
                int currNum = num;
                int currStreak = 1;
                // 当前数num有后继则继续往后找
                while (numSet.contains(currNum + 1)) {
                    currNum += 1;
                    currStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currStreak);
            }
        }
        return longestStreak;
    }

    /**
     * 11.盛最多水的容器
     * 给你n个非负整数a1，a2，...，an，每个数代表坐标中的一个点(i, ai)。
     * 在坐标内画n条垂直线，垂直线i的两个端点分别为(i, ai)和(i, 0)。
     * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
     * 思路：双指针法
     */
    public static int maxArea(int[] height) {
        if (height == null || height.length < 2) return 0;
        int maxArea = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            maxArea = Math.max(maxArea, area);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }

    /**
     * 26.删除有序数组中的重复项【快慢指针】
     * 给你一个升序排列的数组nums，请你原地删除重复出现的元素，使每个元素只出现一次，返回删除后数组
     * 的新长度。元素的相对顺序应该保持一致。
     * 示例 2：
     * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
     * 输出：5, nums = [0,1,2,3,4]
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 0) return 0;
        if (nums.length == 1) return 1;
        int slow = 1;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    /**
     * TODO 1248.统计「优美子数组」!!!
     */

    /**
     * 560.和为K的子数组
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
        if (nums == null || nums.length <= 0) return 0;
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end >= 0; end--) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    // 方法二：前缀和 + 哈希表优化
    public static int subarraySum2(int[] nums, int k) {
        if (nums == null || nums.length <= 0) return 0;
        int pre = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    /**
     * 974.和可被K整除的子数组
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
        if (nums == null || nums.length <= 0) return 0;
        int ans = 0;
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int res = sum[j] - sum[i];
                if (res % k == 0) ans++;
            }
        }
        return ans;
    }

    // 哈希表 + 逐一统计
    // 思路和算法
    // 通常，涉及连续子数组问题的时候，我们使用前缀和来解决。
    public static int subarraysDivByK2(int[] nums, int k) {
        if (nums == null || nums.length <= 0) return 0;
        int sum = 0;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = (sum % k + k) % k;
            int same = map.getOrDefault(mod, 0);
            ans += same;
            map.put(mod, same + 1);
        }
        return ans;
    }

    // 哈希表 + 单次统计
    // 可以在遍历时维护哈希表。在遍历结束后，我们再遍历哈希表，用排列组合的方法来统计答案。
    public static int subarraysDivByK3(int[] nums, int k) {
        if (nums == null || nums.length <= 0) return 0;
        int ans = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = (sum % k + k) % k;
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans += entry.getValue() * (entry.getValue() - 1) / 2;
        }
        return ans;
    }

    /**
     * 1.两数之和
     * 给定一个整数数组nums和一个整数目标值target，请你在该数组中找出和为目标值target的那两个整数，
     * 并返回它们的数组下标。
     * 示例 1：
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1]
     */
    // 暴力枚举
    public static int[] twoSum1(int[] nums, int target) {
        if (nums == null || nums.length <= 0) return new int[0];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    // 哈希表
    public static int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length <= 0) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (map.containsKey(other)) {
                return new int[] {map.get(other), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

}
