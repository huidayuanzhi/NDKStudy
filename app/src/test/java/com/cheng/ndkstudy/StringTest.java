package com.cheng.ndkstudy;

import org.junit.Test;

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

}
