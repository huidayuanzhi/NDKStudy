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

}
