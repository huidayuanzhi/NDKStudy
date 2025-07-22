package com.cheng.ndkstudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        return null;
    }

    // 方法二：中心扩展算法
    public static String longestPalindrome2(String s) {
        return "";
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
        return 0;
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
        return 0;
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
        return 0;
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
        return null;
    }

    // 方法二：优化的滑动窗口
    public static List<Integer> findAnagrams2(String s, String p) {
        return null;
    }

    /**
     * 567.字符串的排列
     * 给你两个字符串s1和s2，写一个函数来判断s2是否包含s1的排列。换句话说，s1的排列之一是s2的子串。
     * 示例 1：
     * 输入：s1 = "ab" s2 = "eidbaooo"
     * 输出：true
     * 解释：s2 包含 s1 的排列之一 ("ba").
     * 示例 2：
     * 输入：s1= "ab" s2 = "eidboaoo"
     * 输出：false
     */
    // 方法一：滑动窗口
    public static boolean checkInclusion1(String s1, String s2) {
        return false;
    }

    // 优化
    public static boolean checkInclusion2(String s1, String s2) {
        return false;
    }

    // 方法二：双指针
    public static boolean checkInclusion3(String s1, String s2) {
        return false;
    }

    /**
     * 647. 回文子串
     * 示例 1：
     * 输入：s = "abc"
     * 输出：3
     * 解释：三个回文子串: "a", "b", "c"
     * 示例 2：
     * 输入：s = "aaa"
     * 输出：6
     * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
     */
    // 方法一：中心拓展
    public static int countSubstrings1(String s) {
        return 0;
    }

    // 方法二：动态规划
    public static int countSubstrings2(String s) {
        return 0;
    }

    /**
     * 14. 最长公共前缀
     * 示例 1：
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     * 示例 2：
     * 输入：strs = ["dog","racecar","car"]
     * 输出：""
     */
    // 方法一：横向扫描
    public static String longestCommonPrefix1(String[] strs) {
        return "";
    }

    // 方法二：纵向扫描
    public static String longestCommonPrefix2(String[] strs) {
        return "";
    }

    /**
     * 3. 无重复字符的最长子串
     * 示例 1:
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     */
    public static int lengthOfLongestSubstring1(String s) {
        return 0;
    }

    public static int lengthOfLongestSubstring2(String s) {
        return 0;
    }

    /**
     * 97. 交错字符串
     * 示例 1：
     * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
     * 输出：true
     * 示例 2：
     * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
     * 输出：false
     */
    // 方法一：动态规划
    public static boolean isInterleave1(String s1, String s2, String s3) {
        return false;
    }

    // 动态规划 + 滚动数组
    public static boolean isInterleave2(String s1, String s2, String s3) {
        return false;
    }

    /**
     * TODO 131. 分割回文串
     * 给你一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。返回 s 所有可能的分割方案。
     * 示例 1：
     * 输入：s = "aab"
     * 输出：[["a","a","b"],["aa","b"]]
     * 示例 2：
     * 输入：s = "a"
     * 输出：[["a"]]
     */

    /**
     * 139. 单词拆分
     * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。
     * 如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
     * 示例 1：
     * 输入: s = "leetcode", wordDict = ["leet", "code"]
     * 输出: true
     * 示例 2：
     * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
     * 输出: true
     * 示例 3：
     * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     * 输出: false
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        return false;
    }

    /**
     * 187. 重复的DNA序列
     * 给定一个表示DNA序列的字符串 s，返回所有在 DNA 分子中出现不止一次的长度为 10 的序列(子字符串)。
     * 示例 1：
     * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
     * 输出：["AAAAACCCCC","CCCCCAAAAA"]
     * 示例 2：
     * 输入：s = "AAAAAAAAAAAAA"
     * 输出：["AAAAAAAAAA"]
     */
    // 哈希法
    public static List<String> findRepeatedDnaSequences(String s) {
        return null;
    }

    /**
     * 392. 判断子序列
     * 示例 1：
     * 输入：s = "abc", t = "ahbgdc"
     * 输出：true
     * 示例 2：
     * 输入：s = "axc", t = "ahbgdc"
     * 输出：false
     */
    // 方法一：双指针
    public static boolean isSubsequence(String s, String t) {
        return false;
    }

    /**
     * 1143. 最长公共子序列
     * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
     * 示例 1：
     * 输入：text1 = "abcde", text2 = "ace"
     * 输出：3
     * 示例 2：
     * 输入：text1 = "abc", text2 = "abc"
     * 输出：3
     * 示例 3：
     * 输入：text1 = "abc", text2 = "def"
     * 输出：0
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        return 0;
    }

    /**
     * 583.两个字符串的删除操作
     * 给定两个单词word1和word2，返回使得word1和word2相同所需的最小步数。
     * 每步可以删除任意一个字符串中的一个字符。
     * 示例 1：
     * 输入: word1 = "sea", word2 = "eat"
     * 输出: 2
     * 解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
     * 示例  2:
     * 输入：word1 = "leetcode", word2 = "etco"
     * 输出：4
     */
    // 方法一：最长公共子序列
    public static int minDistance1(String word1, String word2) {
        return 0;
    }

    // 方法二：动态规划
    // dp[i][j] 表示使 word1[0:i] 和 word2[0:j] 相同的最少删除操作次数
    // 动态规划的边界情况如下：
    // 当 i=0 时，word1[0:i] 为空，空字符串和任何字符串要变成相同，
    // 只有将另一个字符串的字符全部删除，因此对任意 0≤j≤n，有 dp[0][j]=j；
    // 当 j=0 时，word2[0:j] 为空，同理可得，对任意 0≤i≤m，有 dp[i][0]=i。
    public static int minDistance2(String word1, String word2) {
        return 0;
    }

    /**
     * 402. 移掉 K 位数字
     * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
     * 示例 1 ：
     * 输入：num = "1432219", k = 3
     * 输出："1219"
     * 解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
     * 示例 2 ：
     * 输入：num = "10200", k = 1
     * 输出："200"
     * 解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
     * 示例 3 ：
     * 输入：num = "10", k = 2
     * 输出："0"
     */
    // 方法一：贪心 + 单调栈
    public static String removeKdigits(String num, int k) {
        return null;
    }

}
