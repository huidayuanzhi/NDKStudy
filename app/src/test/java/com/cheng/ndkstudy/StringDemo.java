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
     * 5. 最长回文子串 - 动态规划/中心扩展法
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
     * 395. 至少有 K 个重复字符的最长子串 - 用少于 k 的字符分割
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
     * 516. 最长回文子序列 - 动态规划
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
     * 424. 替换后的最长重复字符 - 双指针（滑动窗口）
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
     * 438. 找到字符串中所有字母异位词 - 滑动窗口
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

    /**
     * 567.字符串的排列 - 滑动窗口/双指针
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
        if (s1 == null || s2 == null || s2.length() < s1.length()) return false;
        int n = s1.length();
        int m = s2.length();
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; i++) {
            cnt1[s1.charAt(i) - 'a']++;
            cnt2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }
        // 注意 i 是从 n 开始的，也就是说第 i 个字符是没有被计数的，所以是进入计数(++)
        for (int i = n; i < m; i++) {
            ++cnt2[s2.charAt(i) - 'a'];
            --cnt2[s2.charAt(i - n) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }

    // 优化
    public static boolean checkInclusion2(String s1, String s2) {
        if (s1 == null || s2 == null || s2.length() < s1.length()) return false;
        int n = s1.length();
        int m = s2.length();
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            --cnt[s1.charAt(i) - 'a'];
            ++cnt[s2.charAt(i) - 'a'];
        }
        int diff = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) {
                diff++;
            }
        }
        if (diff == 0) {
            return true;
        }
        for (int i = n; i < m; i++) {
            int x = s2.charAt(i) - 'a';
            int y = s2.charAt(i - n) - 'a';
            if (x == y) {
                continue;
            }
            if (cnt[x] == 0) {
                diff++;
            }
            cnt[x]++;
            if (cnt[x] == 0) {
                diff--;
            }
            if (cnt[y] == 0) {
                diff++;
            }
            cnt[y]--;
            if (cnt[y] == 0) {
                diff--;
            }
            if (diff == 0) {
                return true;
            }
        }
        return false;
    }

    // 方法二：双指针
    public static boolean checkInclusion3(String s1, String s2) {
        if (s1 == null || s2 == null || s2.length() < s1.length()) return false;
        int n = s1.length();
        int m = s2.length();
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            cnt[s1.charAt(i) - 'a']--;
        }
        int left = 0;
        for (int right = 0; right < m; right++) {
            int x = s2.charAt(right) - 'a';
            ++cnt[x];
            while (cnt[x] > 0) {
                --cnt[s2.charAt(left) - 'a'];
                left++;
            }
            if (right - left + 1 == n) {
                return true;
            }
        }
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
        if (s == null || s.length() <= 0) return 0;
        int n = s.length();
        int ans = 0;
        for (int i = 0, len = 2 * n - 1; i < len; i++) {
            int l = i / 2;
            int r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                ans++;
            }
        }
        return ans;
    }

    // 方法二：动态规划
    public static int countSubstrings2(String s) {
        if (s == null || s.length() <= 0) return 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int ans = 0;
        char[] charArr = s.toCharArray();
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (charArr[i] == charArr[j] && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    ans++;
                }
            }
        }
        return ans;
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
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = longestCommonPrefix1(prefix, strs[i]);
            if (prefix.isEmpty()) {
                break;
            }
        }
        return prefix;
    }

    private static String longestCommonPrefix1(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    // 方法二：纵向扫描
    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return "";
    }

    /**
     * 3. 无重复字符的最长子串 - 哈希
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
        if (s == null || s.isEmpty()) return 0;
        Set<Character> set = new HashSet<>();
        int r = -1;
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                set.remove(s.charAt(i - 1));
            }
            while (r + 1 < n && !set.contains(s.charAt(r + 1))) {
                set.add(s.charAt(r + 1));
                r++;
            }
            ans = Math.max(ans, r - i + 1);
        }
        return ans;
    }

    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || s.isEmpty()) return 0;
        Set<Character> set = new HashSet<>();
        int length = s.length();
        int ans = 1;
        for (int left = 0, right = 0; right < length; right++) {
            char currChar = s.charAt(right);
            while (set.contains(currChar)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(currChar);
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    /**
     * 97. 交错字符串 - 动态规划
     * 示例 1：
     * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
     * 输出：true
     * 示例 2：
     * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
     * 输出：false
     */
    // 方法一：动态规划
    public static boolean isInterleave1(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) return false;
        int n = s1.length();
        int m = s2.length();
        int t = s3.length();
        if (n + m != t) {
            return false;
        }
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                int p = i + j - 1;
                if (i > 0) {
                    f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }
        return f[n][m];
    }

    // 动态规划 + 滚动数组
    public static boolean isInterleave2(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) return false;
        int n = s1.length();
        int m = s2.length();
        int t = s3.length();
        if (n + m != t) {
            return false;
        }
        boolean[] f = new boolean[m + 1];
        f[0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                int p = i + j - 1;
                if (i > 0) {
                    f[j] = f[j] && s1.charAt(i - 1) == s3.charAt(p);
                }
                if (j > 0) {
                    f[j] = f[j] || s2.charAt(j - 1) == s3.charAt(p);
                }
            }
        }
        return f[m];
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
     * 139. 单词拆分 - 动态规划 + 哈希
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
        if (s == null || s.isEmpty() || wordDict == null || wordDict.isEmpty()) return false;
        Set<String> wordDictSet = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    /**
     * 187. 重复的DNA序列 - 哈希
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
        final int L = 10;
        if (s == null || s.length() < L) return Collections.emptyList();
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i <= n - L; i++) {
            String sub = s.substring(i, i + L);
            map.put(sub, map.getOrDefault(sub, 0) + 1);
            if (map.get(sub) == 2) {
                res.add(sub);
            }
        }
        return res;
    }

    /**
     * 392. 判断子序列 - 双指针
     * 示例 1：
     * 输入：s = "abc", t = "ahbgdc"
     * 输出：true
     * 示例 2：
     * 输入：s = "axc", t = "ahbgdc"
     * 输出：false
     */
    // 方法一：双指针
    public static boolean isSubsequence(String s, String t) {
        if (s == null || t == null || s.length() > t.length()) return false;
        int n = s.length();
        int m = t.length();
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }

    /**
     * 1143. 最长公共子序列 - 动态规划
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
        if (text1 == null || text2 == null || text1.isEmpty() || text2.isEmpty()) return 0;
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    /**
     * 583.两个字符串的删除操作 - 动态规划
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
        if (word1 == null || word2 == null || word1.isEmpty() || word2.isEmpty()) return 0;
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = word1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = word2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int lcs = dp[m][n];
        return m - lcs + n - lcs;
    }

    // 方法二：动态规划
    // dp[i][j] 表示使 word1[0:i] 和 word2[0:j] 相同的最少删除操作次数
    // 动态规划的边界情况如下：
    // 当 i=0 时，word1[0:i] 为空，空字符串和任何字符串要变成相同，
    // 只有将另一个字符串的字符全部删除，因此对任意 0≤j≤n，有 dp[0][j]=j；
    // 当 j=0 时，word2[0:j] 为空，同理可得，对任意 0≤i≤m，有 dp[i][0]=i。
    public static int minDistance2(String word1, String word2) {
        if (word1 == null || word2 == null || word1.isEmpty() || word2.isEmpty()) return 0;
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            char c1 = word1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = word2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }

    /**
     * 402. 移掉 K 位数字 - 贪心 + 单调栈
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
        if (num == null || k < 1 || num.length() <= k) return "0";
        int length = num.length();
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }
        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }
        while (deque.peekFirst() == '0') {
            deque.pollFirst();
        }
        StringBuilder builder = new StringBuilder();
        while (!deque.isEmpty()) {
            builder.append(deque.pollFirst());
        }
        return builder.isEmpty() ? "0" : builder.toString();
    }

}
