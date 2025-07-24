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
        if (nums1 == null || nums1.length <= 0 || nums2 == null || nums2.length <= 0) return new int[0];
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
        if (nums1 == null || nums1.length <= 0 || nums2 == null || nums2.length <= 0) return new int[0];
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
        for (int i = 0, len = 2 * n - 1; i < len; i++) {
           while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
               res[stack.pop()] = nums[i % n];
           }
           stack.push(i % n);
        }
        return res;
    }

    /**
     * 20. 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s，判断字符串是否有效。
     * 示例 1：
     * 输入：s = "()[]{}"
     * 输出：true
     * 示例 2：
     * 输入：s = "([])"
     * 输出：true
     * 示例 3：
     * 输入：s = "([)]"
     * 输出：false
     */
    public static boolean isValid(String s) {
        if (s == null || s.isEmpty() || s.length() % 2 != 0) return false;
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Deque<Character> stack = new LinkedList<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != map.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    /**
     * 71. 简化路径
     * 给你一个字符串 path，表示指向某一文件或目录的 Unix 风格绝对路径，将其转化为更加简洁的规范路径。
     * 示例 1：
     * 输入：path = "/home/"
     * 输出："/home"
     * 示例 2：
     * 输入：path = "/home//foo/"
     * 输出："/home/foo"
     * 示例 3：
     * 输入：path = "/home/user/Documents/../Pictures"
     * 输出："/home/user/Pictures"
     * 示例 4：
     * 输入：path = "/../"
     * 输出："/"
     * 示例 5：
     * 输入：path = "/.../a/../b/c/../d/./"
     * 输出："/.../b/d"
     */
    public static String simplifyPath(String path) {
        if (path == null || path.isEmpty()) return path;
        String[] names = path.split("/");
        Deque<String> stack = new LinkedList<>();
        for (String name : names) {
            if ("..".equals(name)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (!name.isEmpty() && !".".equals(name)) {
                stack.offerLast(name);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append("/").append(stack.pollFirst());
        }
        return builder.toString();
    }

}
