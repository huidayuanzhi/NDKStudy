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
     * 前 K 个高频元素 - 哈希 + 优先级队列
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
        if (nums == null || nums.length <= 0) return false;
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
        if (nums == null || nums.length <= 1) return;
        int n = nums.length;
        int left = 0;
        int right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
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
     * 674.最长连续递增序列 - 贪心
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
     * 128.最长连续序列 - 哈希
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
     * 11.盛最多水的容器 - 双指针
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
     * 26.删除有序数组中的重复项 - 快慢指针
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
                count += map.get(pre - k); // 说明：pre - (pre - k) = k
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
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
        if (nums == null || nums.length <= 0 || k == 0) return 0;
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int temp = sum[j] - sum[i];
                if (temp % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    // 哈希表 + 逐一统计
    // 思路和算法
    // 通常，涉及连续子数组问题的时候，我们使用前缀和来解决。
    public static int subarraysDivByK2(int[] nums, int k) {
        if (nums == null || nums.length <= 0 || k == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int pre = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            int modulus = (pre % k + k) % k;
            int some = map.getOrDefault(modulus, 0);
            count += some;
            map.put(modulus, some + 1);
        }
        return count;
    }

    // 哈希表 + 单次统计
    // 可以在遍历时维护哈希表。在遍历结束后，我们再遍历哈希表，用排列组合的方法来统计答案。
    public static int subarraysDivByK3(int[] nums, int k) {
        if (nums == null || nums.length <= 0) return 0;
        int ans = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // 关键！！！
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

    /**
     * 167.两数之和 II - 输入有序数组 - 双指针
     * 给你一个下标从1开始的整数数组numbers，该数组已按非递减顺序排列，请你从数组中找出满足相加之和
     * 等于目标数target的两个数。如果设这两个数分别是numbers[index1]和numbers[index2]，则1 <=
     * index1 < index2 <= numbers.length。
     */
    // 双指针
    public static int[] twoSumII1(int[] nums, int target) {
        if (nums == null || nums.length <= 0) return new int[]{-1, -1};
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                return new int[]{left + 1, right + 1};
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    public static int[] twoSumII2(int[] nums, int target) {
        if (nums == null || nums.length <= 0) return new int[]{-1, -1};
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (nums[mid] == target - nums[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (nums[mid] < target - nums[i]) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return new int[]{-1, -1};
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
        if (nums == null || nums.length < 3) return null;
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = n - 1;
            int target = -nums[first];
            for (int second = first + 1; second < n; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                if (second == third) {
                    break;
                }
                if (nums[first] + nums[second] + nums[third] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    result.add(list);
                }
            }
        }
        return result;
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
        if (nums == null || nums.length < 4) return null;
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3]) > target) {
                break;
            }
            if (((long) nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1]) < target) {
                continue;
            }
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2]) > target) {
                    break;
                }
                if (((long) nums[i] + nums[j] + nums[n - 1] + nums[n - 2]) < target) {
                    continue;
                }
                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
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
        if (nums == null || nums.length <= 1) return true;
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; i++) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, nums[i] + i);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
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
        if (nums == null || nums.length <= 0) return 0;
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (nums[i] + i >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

    // 方法二：正向查找可到达的最大位置
    public static int jumpII2(int[] nums) {
        if (nums == null || nums.length <= 0) return 0;
        int n = nums.length;
        int steps = 0;
        int maxPosition = 0;
        int end = 0;
        for (int i = 0; i < n - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
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
        if (m <= 0 || n <= 0) return 0;
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            f[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }

    // 方法二：动态规划 + 滚动数组
    public static int uniquePaths2(int m, int n) {
        if (m <= 0 || n <= 0) return 0;
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[j] += f[j - 1];
            }
        }
        return f[n - 1];
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
        if (obstacleGrid == null || obstacleGrid.length <= 0 || obstacleGrid[0].length <= 0) return  0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    // 动态规划 + 滚动数组
    public static int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length <= 0 || obstacleGrid[0].length <= 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] f = new int[n];
        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j >= 1 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }
        return f[n - 1];
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
        if (points == null || points.length <= 0 || points[0].length <= 0) return 0;
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int count = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                end = points[i][1];
                count++;
            }
        }
        return count;
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
        if (intervals == null || intervals.length <= 0) return 0;
        // 先将所有的 n 个区间按照左端点从小到大进行排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int n = intervals.length;
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // j 右侧 <= i 的左侧，说明第 j 个区间与第 i 个区间不相交
                if (intervals[j][1] <= intervals[i][0]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        return n - Arrays.stream(f).max().getAsInt();
    }

    // 方法二：贪心
    // 首个区间就是所有可以选择的区间中右端点最小的那个区间
    public static int eraseOverlapIntervals2(int[][] intervals) {
        if (intervals == null || intervals.length <= 0) return 0;
        // 先将所有的 n 个区间按照右端点从小到大进行排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int n = intervals.length;
        // 记录不相交区间数量
        int ans = 1;
        // 记录右端点
        int right = intervals[0][1];
        for (int i = 1; i < n; i++) {
            // i 区间的左侧 >= 右端点，说明 i 区间与当前右端点不相交
            if (intervals[i][0] >= right) {
                ans++;
                right = intervals[i][1];
            }
        }
        return n - ans;
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
        if (intervals == null || intervals.length <= 0) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int size = merged.size();
            int L = intervals[i][0];
            int R = intervals[i][1];
            if (size == 0 || merged.get(size - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(size - 1)[1] = Math.max(merged.get(size - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
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
        if (newInterval == null || newInterval.length != 2) return intervals;
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                // 在插入区间的右侧且无交集
                if (!placed) {
                    ansList.add(new int[]{left, right});
                    placed = true;
                }
                ansList.add(interval);
            } else if (interval[1] < left) {
                // 在插入区间的左侧且无交集
                ansList.add(interval);
            } else {
                // 与插入区间有交集，计算它们的并集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            ansList.add(new int[]{left, right});
        }
        return ansList.toArray(new int[ansList.size()][]);
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
        if (pairs == null || pairs.length <= 0) return 0;
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[0]));
        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }

    // 方法三：贪心
    public static int findLongestChain3(int[][] pairs) {
        if (pairs == null || pairs.length <= 0) return 0;
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));
        int right = pairs[0][1];
        int ans = 1;
        for (int[] pair : pairs) {
            if (pair[0] > right) {
                ans++;
                right = pair[1];
            }
        }
        return ans;
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
        if (grid == null || grid.length <= 0 || grid[0].length <= 0) return 0;
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < columns; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][columns - 1];
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
        if (n <= 1) return n;
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    public static int climbStairs2(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
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
        if (s == null || s.length() <= 0) return 0;
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0')) <= 26) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }

    public static int numDecoding2(String s) {
        if (s == null || s.length() <= 0) return 0;
        // a = f[i - 2], b = f[i - 1], c = f[i]
        int a = 0;
        int b = 1;
        int c = 0;
        int n = s.length();
        for (int i = 1; i <= n; i++) {
            c = 0;
            if (s.charAt(i - 1) != '0') {
                c += b;
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0')) <= 26) {
                c += a;
            }
            a = b;
            b = c;
        }
        return c;
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
        if (piles == null || piles.length <= 0 || h < 1) return 0;
        int n = piles.length;
        int low = 1;
        int high = 0;
        for (int i = 0; i < n; i++) {
            high = Math.max(high, piles[i]);
        }
        int k = high;
        while (low < high) {
            int speed = (high - low) / 2 + low;
            long time = getTime(piles, speed);
            if (time <= h) {
                k = speed;
                high = speed;
            } else {
                low = speed + 1;
            }
        }
        return k;
    }

    private static long getTime(int[] piles, int speed) {
        long time = 0;
        for (int i = 0; i < piles.length; i++) {
            time += (piles[i] + speed - 1) / speed;
        }
        return time;
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
        if (weights == null || weights.length <= 0 || days < 1) return 0;
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = (right - left) / 2 + left;
            int need = 1;
            int curr = 0;
            for (int weight : weights) {
                if (curr + weight > mid) {
                    need++;
                    curr = 0;
                }
                curr += weight;
            }
            if (need <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
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
        if (x <= 0) return -1;
        int ans = -1;
        int left = 1;
        int right = x;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
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
        if (nums == null || nums.length <= 0) return new int[]{-1, -1};
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    private static int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
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
        if (nums == null || nums.length <= 0) return 0;
        int n = nums.length;
        int ans = 1;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
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
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) return 0;
        int maxSide = 0;
        int rows = matrix.length;
        int columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    maxSide = Math.max(maxSide, 1);
                    int currentMaxSide = Math.min(rows - i, columns - j);
                    for (int k = 1; k < currentMaxSide; k++) {
                        if (matrix[i + k][j + k] == '0') {
                            break;
                        }
                        boolean flag = true;
                        for (int m = 0; m < k; m++) {
                            if (matrix[i + k][j + m] == '0' || matrix[i + m][j + k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            maxSide = Math.max(maxSide, k + 1);
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return maxSide * maxSide;
    }

    // 方法二：动态规划
    // 用 dp(i,j) 表示以 (i,j) 为右下角，且只包含 1 的正方形的边长最大值
    public static int maximalSquare2(char[][] matrix) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) return 0;
        int maxSide = 0;
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
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
        if (grid == null || grid.length <= 0 || grid[0].length <= 0) return 0;
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        return ans;
    }

    private static int dfs(int[][] grid, int cur_i, int cur_j) {
        int rows = grid.length;
        int columns = grid[0].length;
        if (cur_i < 0 || cur_j < 0 || cur_i >= rows || cur_j >= columns || grid[cur_i][cur_j] == 0) {
            return 0;
        }
        int ans = 1;
        grid[cur_i][cur_j] = 0;
        int[] di = {0, 0, 1, -1};
        int[] dj = {1, -1, 0, 0};
        for (int i = 0; i < di.length; i++) {
            int next_i = cur_i + di[i];
            int next_j = cur_j + dj[i];
            ans += dfs(grid, next_i, next_j);
        }
        return ans;
    }

    // 方法二：深度优先搜索 + 栈
    public static int maxAreaOfIsland2(int[][] grid) {
        if (grid == null || grid.length <= 0 || grid[0].length <= 0) return 0;
        int ans = 0;
        int rows = grid.length;
        int columns = grid[0].length;
        int[] di = {0, 0, 1, -1};
        int[] dj = {1, -1, 0, 0};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int cur = 0;
                Deque<Integer> stacki = new LinkedList<>();
                Deque<Integer> stackj = new LinkedList<>();
                stacki.push(i);
                stackj.push(j);
                while (!stacki.isEmpty()) {
                    int cur_i = stacki.pop();
                    int cur_j = stackj.pop();
                    if (cur_i < 0 || cur_j < 0 || cur_i >= rows || cur_j >= columns || grid[cur_i][cur_j] == 0) {
                        continue;
                    }
                    cur++;
                    grid[cur_i][cur_j] = 0;
                    for (int index = 0; index < di.length; index++) {
                        int next_i = cur_i + di[index];
                        int next_j = cur_j + dj[index];
                        stacki.push(next_i);
                        stackj.push(next_j);
                    }
                }
                ans = Math.max(ans, cur);
            }
        }
        return ans;
    }

    // 方法三：广度优先搜索
    public static int maxAreaOfIsland3(int[][] grid) {
        if (grid == null || grid.length <= 0 || grid[0].length <= 0) return 0;
        int ans = 0;
        int rows = grid.length;
        int columns = grid[0].length;
        int[] di = {0, 0, 1, -1};
        int[] dj = {1, -1, 0, 0};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int cur = 0;
                Queue<Integer> queuei = new LinkedList<>();
                Queue<Integer> queuej = new LinkedList<>();
                queuei.offer(i);
                queuej.offer(j);
                while (!queuei.isEmpty()) {
                    int cur_i = queuei.poll();
                    int cur_j = queuej.poll();
                    if (cur_i < 0 || cur_j < 0 || cur_i >= rows || cur_j >= columns || grid[cur_i][cur_j] == 0) {
                        continue;
                    }
                    cur++;
                    grid[cur_i][cur_j] = 0;
                    for (int index = 0; index < di.length; index++) {
                        int next_i = cur_i + di[index];
                        int next_j = cur_j + dj[index];
                        queuei.offer(next_i);
                        queuej.offer(next_j);
                    }
                }
                ans = Math.max(ans, cur);
            }
        }
        return ans;
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
        if (nums == null || nums.length <= 0) return 0;
        int n = nums.length;
        long[] maxF = new long[n];
        long[] minF = new long[n];
        maxF[0] = nums[0];
        minF[0] = nums[0];
        int ans = nums[0];
        for (int i = 1; i < n; i++) {
            maxF[i] = nums[i];
            minF[i] = nums[i];
            maxF[i] = Math.max(Math.max(nums[i], maxF[i - 1] * nums[i]), minF[i - 1] * nums[i]);
            minF[i] = Math.min(Math.min(nums[i], maxF[i - 1] * nums[i]), minF[i - 1] * nums[i]);
            if (minF[i] < -1 << 32) {
                minF[i] = nums[i];
            }
            ans = Math.max(ans, (int) maxF[i]);
        }
        return ans;
    }

    public static int maxProduct2(int[] nums) {
        if (nums == null || nums.length <= 0) return 0;
        long maxF = nums[0];
        long minF = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            long mx = maxF;
            long mn = minF;
            maxF = Math.max(Math.max(nums[i], mx * nums[i]), mn * nums[i]);
            minF = Math.min(Math.min(nums[i], mx * nums[i]), mn * nums[i]);
            if (minF < -1 << 32) {
                minF = nums[i];
            }
            ans = Math.max(ans, (int) maxF);
        }
        return ans;
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
        if (nums == null || nums.length <= 0) return Collections.emptyList();
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            output.add(nums[i]);
        }
        backtrace(n, res, output, 0);
        return res;
    }

    private static void backtrace(int n, List<List<Integer>> res, List<Integer> output, int first) {
        if (first == n) {
            res.add(new ArrayList<>(output));
            return;
        }
        for (int i = first; i < n; i++) {
            Collections.swap(output, i, first);
            backtrace(n, res, output, first + 1);
            Collections.swap(output, i, first);
        }
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
        if (nums == null || nums.length <= 0) return Collections.emptyList();
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            output.add(nums[i]);
        }
        backtraceUnique(n, output, res, 0);
        return res;
    }

    private static void backtraceUnique(int n, List<Integer> output, List<List<Integer>> res, int first) {
        if (first == n - 1) {
            res.add(new ArrayList<>(output));
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = first; i < n; i++) {
            if (set.contains(output.get(i))) {
                continue;
            }
            set.add(output.get(i));
            Collections.swap(output, i, first);
            backtraceUnique(n, output, res, first + 1);
            Collections.swap(output, i, first);
        }
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
        if (nums == null || nums.length <= 0) return Collections.emptyList();
        List<List<Integer>> output = new ArrayList<>();
        output.add(Collections.emptyList());
        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> curr : output) {
                List<Integer> newCurr = new ArrayList<>(curr);
                newCurr.add(num);
                newSubsets.add(newCurr);
            }
            output.addAll(newSubsets);
        }
        return output;
    }

    // 方法二：回溯
    // 幂集是所有长度从 0 到 n 所有子集的组合
    // 根据定义，该问题可以看作是从序列中生成幂集
    // 遍历子集长度，通过回溯生成所有给定长度的子集
    public static List<List<Integer>> subsets2(int[] nums) {
        if (nums == null || nums.length <= 0) return Collections.emptyList();
        int n = nums.length;
        List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            backtrack(i, 0, nums, new ArrayList<>(), output);
        }
        return output;
    }

    private static void backtrack(int k, int first, int[] nums, List<Integer> curr, List<List<Integer>> output) {
        if (curr.size() == k) {
            output.add(new ArrayList<>(curr));
        }
        int n = nums.length;
        for (int i = first; i < n; i++) {
            curr.add(nums[i]);
            backtrack(k, i + 1, nums, curr, output);
            curr.remove(curr.size() - 1);
        }
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
        if (n <= 0) return Collections.emptyList();
        List<String> res = new ArrayList<>();
        getParenthesis("", n, n, res);
        return res;
    }

    private static void getParenthesis(String str, int left, int right, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }
        if (left == right) {
            // 剩余左右括号数相等，下一个只能用左括号
            getParenthesis(str + "(", left - 1, right, res);
        } else if (left < right) {
            // 剩余左括号小于右括号，下一个可以用左括号也可以用右括号
            if (left > 0) {
                getParenthesis(str + "(", left - 1, right, res);
            }
            getParenthesis(str + ")", left, right - 1, res);
        }
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
        if (nums == null || nums.length <= 0) return 0;
        int pre = 0;
        int maxAns = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
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
        if (numRows <= 0) return Collections.emptyList();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(row);
        }
        return res;
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
        if (rowIndex <= 0) return Collections.emptyList();
        List<Integer> pre = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(pre.get(j) + pre.get(j - 1));
                }
            }
            pre = cur;
        }
        return pre;
    }

    // 方法二：倒着计算
    public static List<Integer> getPascalsTriangleRow2(int rowIndex) {
        if (rowIndex <= 0) return Collections.emptyList();
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            res.add(0);
            for (int j = i; j > 0; j--) {
                res.set(j, res.get(j) + res.get(j - 1));
            }
        }
        return res;
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
        if (triangle == null || triangle.size() <= 0) return 0;
        int n = triangle.size();
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                f[i][j] = Math.min(f[i - 1][j], f[i - 1][j - 1]) + triangle.get(i).get(j);
            }
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = f[n - 1][0];
        for (int i = 1; i < n; i++) {
            minTotal = Math.min(minTotal, f[n - 1][i]);
        }
        return minTotal;
    }

    // 滚动数组 + 倒着计算
    public static int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() <= 0) return 0;
        int n = triangle.size();
        int[] f = new int[n];
        f[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            f[i] = f[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; j--) {
                f[j] = Math.min(f[j], f[j - 1]) + triangle.get(i).get(j);
            }
            f[0] += triangle.get(i).get(0);
        }
        return Arrays.stream(f).min().getAsInt();
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
        if (nums == null || k <= 0 || nums.length < k) return 0;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }
        return (maxSum * 1.0) / k;
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
        if (prices == null || prices.length < 2) return 0;
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                maxprofit = Math.max(maxprofit, profit);
            }
        }
        return maxprofit;
    }

    // 方法二：一次遍历
    public static int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (minprice > prices[i]) {
                minprice = prices[i];
            } else if (maxprofit < prices[i] - minprice) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

    public static int maxProfit3(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            minprice = Math.min(minprice, prices[i]);
            maxprofit = Math.max(maxprofit, prices[i] - minprice);
        }
        return maxprofit;
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
        if (gas == null || cost == null || gas.length <= 0 || gas.length != cost.length) return -1;
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int sumOfGas = 0;
            int sumOfCost = 0;
            int cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if (sumOfCost > sumOfGas) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }

    // 可以想象出发前向别人借了足够的油量，走完一圈只要能还上就行了
    public static int canCompleteCircuit2(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length <= 0 || gas.length != cost.length) return -1;
        // 最低可能的油量，可能为负，表示出发前借的油
        int minBalance = 0;
        int balance = 0;
        // 达到最低油量的加油站索引，在此加油站出发
        // 油量不会低于最低值，所以此加油站即为题目所求
        int minIndex = 0;
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            // 计算后的balance为到达下一加油站i + 1的油量，如果创了新低则记录之
            balance = balance + gas[i] - cost[i];
            if (balance < minBalance) {
                minBalance = balance;
                minIndex = i + 1;
            }
        }
        // 最后油量 >= 0 说明能走一圈
        return balance >= 0 ? minIndex : -1;
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
        if (nums == null || nums.length <= 0) return "";
        int maxDigit = (Arrays.stream(nums).max().getAsInt() + "").length();
        Integer[] numsArr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsArr[i] = nums[i];
        }
        Arrays.sort(numsArr, (x, y) -> {
            int xOffset = (int) Math.pow(10, maxDigit - (x + "").length());
            int yOffset = (int) Math.pow(10, maxDigit - (y + "").length());
            return y * yOffset - x * xOffset;
        });
        if (numsArr[0] == 0) {
            return "0";
        }
        StringBuilder ret = new StringBuilder();
        for (int num : numsArr) {
            ret.append(num);
        }
        return ret.toString();
    }

    public static String largestNumber2(int[] nums) {
        if (nums == null || nums.length <= 0) return "";
        int n = nums.length;
        String[] strArr = new String[n];
        for (int i = 0; i < n; i++) {
            strArr[i] = nums[i] + "";
        }
        Arrays.sort(strArr, (s1, s2) -> {
            String order1 = s1 + s2;
            String order2 = s2 + s1;
            return order2.compareTo(order1);
        });
        if (strArr[0].equals("0")) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        for (String str : strArr) {
            res.append(str);
        }
        return res.toString();
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
        if (prices == null || prices.length <= 0) return 0;
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
    // 方法一：动态规划 + 空间优化
    public static int maxProfitII2(int[] prices) {
        if (prices == null || prices.length <= 0) return 0;
        int n = prices.length;
        int dp0 = 0;
        int dp1 = -prices[0];
        for (int i = 1; i < n; i++) {
            int newDp0 = Math.max(dp0, dp1 + prices[i]);
            int newDp1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = newDp0;
            dp1 = newDp1;
        }
        return dp0;
    }
    // 方法二：贪心
    public static int maxProfitII3(int[] prices) {
        if (prices == null || prices.length <= 0) return 0;
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
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
        if (prices == null || prices.length < 2) return 0;
        int n = prices.length;
        int[][] dp = new int[n][3];
        // dp[i][0]: 手上持有股票的最大收益
        // dp[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // dp[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }

    public static int maxProfitIII2(int[] prices) {
        if (prices == null || prices.length <= 0) return 0;
        int n = prices.length;
        int dp0 = -prices[0]; // 持有股票
        int dp1 = 0;          // 不持有，冻结期
        int dp2 = 0;          // 不持有，非冻结期
        for (int i = 1; i < n; i++) {
            int newDp0 = Math.max(dp0, dp2 - prices[i]);
            int newDp1 = dp0 + prices[i];
            int newDp2 = Math.max(dp1, dp2);
            dp0 = newDp0;
            dp1 = newDp1;
            dp2 = newDp2;
        }
        return Math.max(dp1, dp2);
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
        if (prices == null || prices.length <= 0) return 0;
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    public static int maxProfitWithFee2(int[] prices, int fee) {
        if (prices == null || prices.length <= 0) return 0;
        int n = prices.length;
        int sell = 0;
        int buy = -prices[0];
        for (int i = 1; i < n; i++) {
            sell = Math.max(sell, buy + prices[i] - fee);
            buy = Math.max(buy, sell - prices[i]);
        }
        return sell;
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
        if (nums == null || nums.length <= 0) return 0;
        if (isSorted(nums)) return 0;
        int n = nums.length;
        int[] numsSorted = new int[n];
        System.arraycopy(nums, 0, numsSorted, 0, n);
        Arrays.sort(numsSorted);
        int left = 0;
        while (left < n && nums[left] == numsSorted[left]) left++;
        int right = n - 1;
        while (right >= 0 && nums[right] == numsSorted[right]) right--;
        return right - left + 1;
    }

    private static boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
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
        if (nums == null || nums.length <= 0) return 0;
        if (isSorted(nums)) return 0;
        int n = nums.length;
        int left = -1;
        int right = -1;
        int minn = Integer.MAX_VALUE;
        int maxn = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (maxn > nums[i]) {
                right = i;
            } else {
                maxn = nums[i];
            }
            int l = n - i - 1;
            if (minn < nums[l]) {
                left = l;
            } else {
                minn = nums[l];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }

}
