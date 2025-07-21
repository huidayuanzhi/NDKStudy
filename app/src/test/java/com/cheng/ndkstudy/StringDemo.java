package com.cheng.ndkstudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringDemo {

    /**
     * 5. 最长回文子串
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * 示例 1：
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * 示例 2：
     * 输入：s = "cbbd"
     * 输出："bb"
     */
    // 方法一：动态规划
    public static String longestPalindrome1(String s) {
        if (s == null || s.length() < 2) return s;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        int maxLen = 1;
        int begin = 0;
        for (int L = 2; L <= len; L++) {
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    // 方法二：中心扩展算法
    public static String longestPalindrome2(String s) {
        if (s == null || s.length() < 2) return s;
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 两种边界情况，子串长度为1和2的情况
            // 子串长度1：以该字符为中心扩展，两边字符相同才是回文
            // 子串长度2：以虚拟的中心扩展，这两个字符相同时继续扩展的前提
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int length = s.length();
        char[] charArray = s.toCharArray();
        while (left >= 0 && right < length && charArray[left] == charArray[right]) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    /**
     * 395. 至少有 K 个重复字符的最长子串
     * 给你一个字符串 s 和一个整数 k，找出 s 中的最长子串，要求
     * 该子串中的每一字符出现次数都不少于 k。返回这一子串的长度。
     * 示例 1：
     * 输入：s = "aaabb", k = 3
     * 输出：3
     * 解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
     * 示例 2：
     * 输入：s = "ababbc", k = 2
     * 输出：5
     * 解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
     */
    public static int longestSubstring(String s, int k) {
        if (s == null || k < 2 || s.length() < k) return 0;
        return dfs(s, 0, s.length() - 1, k);
    }

    private static int dfs(String s, int l, int r, int k) {
        int[] cnt = new int[26];
        for (int i = l; i <= r; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        char split = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i] < k) {
                split = (char) (i + 'a');
                break;
            }
        }
        if (split == 0) {
            return r - l + 1;
        }
        int i = l;
        int ret = 0;
        while (i <= r) {
            while (i <= r && s.charAt(i) == split) {
                i++;
            }
            if (i > r) {
                break;
            }
            int start = i;
            while (i <= r && s.charAt(i) != split) {
                i++;
            }
            int length = dfs(s, start, i - 1, k);
            ret = Math.max(ret, length);
        }
        return ret;
    }

    /**
     * 516. 最长回文子序列
     * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
     * 示例 1：
     * 输入：s = "bbbab"
     * 输出：4
     * 解释：一个可能的最长回文子序列为 "bbbb"。
     * 示例 2：
     * 输入：s = "cbbd"
     * 输出：2
     * 解释：一个可能的最长回文子序列为 "bb"。
     */
    // 动态规划
    // 用 dp[i][j] 表示字符串s的下标范围 [i,j] 内的最长回文子序列的长度
    public static int longestPalindromeSubseq(String s) {
        if (s == null || s.length() <= 0) return 0;
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    /**
     * 424. 替换后的最长重复字符
     * 给你一个字符串 s 和一个整数 k。可以选择字符串中的任一字符，
     * 并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。
     * 在执行上述操作后，返回包含相同字母的最长子字符串的长度。
     * 示例 1：
     * 输入：s = "ABAB", k = 2
     * 输出：4
     * 解释：用两个'A'替换为两个'B',反之亦然。
     * 示例 2：
     * 输入：s = "AABABBA", k = 1
     * 输出：4
     * 解释：
     * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
     */
    /*
    maxCount 是当前及过去滑动窗口维护过的最大字符数，所以 maxCount+k 是出现过的最大重复字符串数
    当 right - left != maxCount + k时，右移是没有意义的，所以左移，然后继续向右探索
    窗口大小始终维持最大重复字符串数，因为比这小的也是没有意义的
     */
    // 双指针（滑动窗口）
    public static int characterReplacement(String s, int k) {
        if (s == null || s.length() < 2 || k < 1) return 0;
        int n = s.length();
        int[] nums = new int[26];
        int left = 0;
        int right = 0;
        int maxCount = 1;
        while (right < n) {
            nums[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, nums[s.charAt(right) - 'A']);
            if (right - left + 1 - maxCount > k) {
                nums[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }

    /**
     * 438. 找到字符串中所有字母异位词
     * 给定两个字符串 s 和 p，找到 s 中所有 p 的异位词的子串，返回这些子串的起始索引。
     * 示例 1:
     * 输入: s = "cbaebabacd", p = "abc"
     * 输出: [0,6]
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
     * 示例 2:
     * 输入: s = "abab", p = "ab"
     * 输出: [0,1,2]
     * 解释:
     * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
     * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
     * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
     */
    // 方法一：滑动窗口
    public static List<Integer> findAnagrams1(String s, String p) {
        if (s == null || p == null || s.length() < p.length()) return Collections.emptyList();
        int sLen = s.length();
        int pLen = p.length();
        List<Integer> res = new ArrayList<>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sCount, pCount)) {
            res.add(0);
        }
        for (int i = 0; i < sLen - pLen; i++) {
            sCount[s.charAt(i) - 'a']--;
            sCount[s.charAt(i + pLen) - 'a']++;
            if (Arrays.equals(sCount, pCount)) {
                res.add(i + 1);
            }
        }
        return res;
    }

    // 方法二：优化的滑动窗口
    public static List<Integer> findAnagrams2(String s, String p) {
        if (s == null || p == null || s.length() < p.length()) return Collections.emptyList();
        int sLen = s.length();
        int pLen = p.length();
        List<Integer> res = new ArrayList<>();
        int[] count = new int[26];
        for (int i = 0; i < pLen; i++) {
            count[s.charAt(i) - 'a']++;
            count[p.charAt(i) - 'a']--;
        }
        int differ = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                differ++;
            }
        }
        if (differ == 0) {
            res.add(0);
        }
        for (int i = 0; i < sLen - pLen; i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                differ--;
            } else if (count[s.charAt(i) - 'a'] == 0) {
                differ++;
            }
            --count[s.charAt(i) - 'a'];
            if (count[s.charAt(i + pLen) - 'a'] == -1) {
                differ--;
            } else if (count[s.charAt(i + pLen) - 'a'] == 0) {
                differ++;
            }
            ++count[s.charAt(i + pLen) - 'a'];
            if (differ == 0) {
                res.add(i + 1);
            }
        }
        return res;
    }

}
