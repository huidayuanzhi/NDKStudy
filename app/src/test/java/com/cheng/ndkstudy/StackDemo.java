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
        return null;
    }

    // 方法二：单调栈 + 哈希表
    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        return null;
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
        return null;
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
        return false;
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
        return null;
    }

}
