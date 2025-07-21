package com.cheng.ndkstudy;

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

}
