package com.cheng.ndkstudy;

import org.junit.Test;

import java.util.List;

public class StringTest {

    @Test
    public void testLongestPalindrome1() {
        // babad -> bab
        Logger.log("longestPalindrome1");
        String s = "babad";
        String result = StringDemo.longestPalindrome1(s);
        Logger.log("longestPalindrome1 in : babad, out : " + result);
        // cbbd -> bb
        Logger.log("longestPalindrome1");
        String s2 = "cbbd";
        String result2 = StringDemo.longestPalindrome1(s2);
        Logger.log("longestPalindrome1 in : cbbd, out : " + result2);
    }

    @Test
    public void testLongestPalindrome2() {
        // babad -> bab
        Logger.log("longestPalindrome2");
        String s = "babad";
        String result = StringDemo.longestPalindrome2(s);
        Logger.log("longestPalindrome2 in : babad, out : " + result);
        // cbbd -> bb
        Logger.log("longestPalindrome2");
        String s2 = "cbbd";
        String result2 = StringDemo.longestPalindrome2(s2);
        Logger.log("longestPalindrome2 in : cbbd, out : " + result2);
    }

    @Test
    public void testLongestSubstring() {
        Logger.log("longestSubstring");
        String str1 = "aaabb";
        int result = StringDemo.longestSubstring(str1, 3); // 3
        Logger.log("longestSubstring aaabb, k = 3 -> result = " + result);
        Logger.log("longestSubstring");
        String str2 = "ababbc";
        int result2 = StringDemo.longestSubstring(str2, 2); // 5
        Logger.log("longestSubstring ababbc, k = 2 -> result = " + result2);
    }

    @Test
    public void testLongestPalindromeSubseq() {
        Logger.log("longestPalindromeSubseq");
        int result = StringDemo.longestPalindromeSubseq("bbbab"); // 4
        Logger.log("testLongestPalindromeSubseq bbbab, result = " + result);
        Logger.log("longestPalindromeSubseq");
        result = StringDemo.longestPalindromeSubseq("cbbd"); // 2
        Logger.log("testLongestPalindromeSubseq cbbd, result = " + result);
    }

    @Test
    public void testCharacterReplacement() {
        Logger.log("characterReplacement");
        int result = StringDemo.characterReplacement("ABAB", 2); // 4
        Logger.log("characterReplacement ABAB, 2 -> result = " + result);
        Logger.log("characterReplacement");
        int result2 = StringDemo.characterReplacement("AABABBA", 1); // 4
        Logger.log("characterReplacement AABABBA, 1 -> result = " + result2);
    }

    @Test
    public void testFindAnagrams1() {
        Logger.log("findAnagrams1");
        List<Integer> result = StringDemo.findAnagrams1("cbaebabacd", "abc");
        Logger.log("findAnagrams1 result -"); // [0,6]
        Logger.log(result);
        List<Integer> result2 = StringDemo.findAnagrams1("abab", "ab");
        Logger.log("findAnagrams1 result -"); // [0,1,2]
        Logger.log(result2);
    }

    @Test
    public void testFindAnagrams2() {
        Logger.log("findAnagrams2");
        List<Integer> result = StringDemo.findAnagrams2("cbaebabacd", "abc");
        Logger.log("findAnagrams2 result -"); // [0,6]
        Logger.log(result);
        List<Integer> result2 = StringDemo.findAnagrams2("abab", "ab");
        Logger.log("findAnagrams2 result -"); // [0,1,2]
        Logger.log(result2);
    }

    @Test
    public void testCheckInclusion1() {
        Logger.log("checkInclusion1");
        boolean result = StringDemo.checkInclusion1("ab", "eidbaooo");
        Logger.log("checkInclusion1 ab, eidbaooo -> result = " + result);
        boolean result2 = StringDemo.checkInclusion1("ab", "eidboaoo");
        Logger.log("checkInclusion1 ab, eidboaoo -> result = " + result2);
    }

    @Test
    public void testCheckInclusion2() {
        Logger.log("checkInclusion2");
        boolean result = StringDemo.checkInclusion2("ab", "eidbaooo");
        Logger.log("checkInclusion2 ab, eidbaooo -> result = " + result);
        boolean result2 = StringDemo.checkInclusion2("ab", "eidboaoo");
        Logger.log("checkInclusion2 ab, eidboaoo -> result = " + result2);
    }

    @Test
    public void testCheckInclusion3() {
        Logger.log("checkInclusion3");
        boolean result = StringDemo.checkInclusion3("ab", "eidbaooo");
        Logger.log("checkInclusion3 ab, eidbaooo -> result = " + result);
        boolean result2 = StringDemo.checkInclusion3("ab", "eidboaoo");
        Logger.log("checkInclusion3 ab, eidboaoo -> result = " + result2);
    }

    @Test
    public void testCountSubstrings1() {
        Logger.log("countSubstrings1");
        int result = StringDemo.countSubstrings1("abc"); // 3
        Logger.log("countSubstrings1 abc - result = " + result);
        result = StringDemo.countSubstrings1("aaa"); // 6
        Logger.log("countSubstrings1 aaa - result = " + result);
    }

    @Test
    public void testCountSubstrings2() {
        Logger.log("countSubstrings2");
        int result = StringDemo.countSubstrings2("abc"); // 3
        Logger.log("countSubstrings2 abc - result = " + result);
        result = StringDemo.countSubstrings2("aaa"); // 6
        Logger.log("countSubstrings2 aaa - result = " + result);
    }

}
