package com.cheng.ndkstudy;

import java.util.ArrayList;
import java.util.Arrays;
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
        map.put(0, 1); // 关键！！！
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
     * 一个机器人位于一个 m x n 网格的左上角，机器人每次只能向下或者向右移动一步。机器人试图达到网格的
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
     * 一个机器人位于一个 m x n 网格的左上角，机器人每次只能向下或者向右移动一步。机器人试图达到网格的
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
     * 示例 3：
     * 输入：nums = [], target = 0
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
            ans = Math.max(ans, (int) maxF);
        }
        return ans;
    }

}
