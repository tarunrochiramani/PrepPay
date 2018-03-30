package com.tr.leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class LongestSubstringWithoutRepeatingCharsTest {
    private LongestSubstringWithoutRepeatingChars longestSubstringWithoutRepeatingChars = new LongestSubstringWithoutRepeatingChars();

    @Test
    public void canGetLongestSubstringWithUniqueInput() throws Exception {
        String result = longestSubstringWithoutRepeatingChars.getLongestSubStringWithoutRepeatingChars("abcdef");
        assertEquals("abcdef", result);
    }

    @Test
    public void canGetLongestSubstringWithoutUniqueInput() throws Exception {
        String result = longestSubstringWithoutRepeatingChars.getLongestSubStringWithoutRepeatingChars("abcdaf");
        assertEquals("bcdaf", result);
    }

    @Test
    public void canGetLongestSubstringWithoutUniqueInput_1() throws Exception {
        String result = longestSubstringWithoutRepeatingChars.getLongestSubStringWithoutRepeatingChars("abcdcefghdighjk");
        assertEquals("cefghdi", result);
    }

    @Test
    public void canGetLongestSubstringContainingKUniqueChars() throws Exception {
        String result = longestSubstringWithoutRepeatingChars.getLongestSubstringContainingKUniqueChars("abbabbc", 2);
        assertEquals("abbabb", result);
    }


    @Test
    public void canGetLongestSubstringContainingKUniqueChars_1() throws Exception {
        String result = longestSubstringWithoutRepeatingChars.getLongestSubstringContainingKUniqueChars("abbabccaaa", 1);
        assertEquals("aaa", result);
    }


    @Test
    public void canGetLongestSubstringContainingKUniqueChars_2() throws Exception {
        String result = longestSubstringWithoutRepeatingChars.getLongestSubstringContainingKUniqueChars("abbabccaaa", 4);
        assertEquals("abbabccaaa", result);
    }

    @Test
    public void canGetLongestSubstringContainingKUniqueChars_3() throws Exception {
        String result = longestSubstringWithoutRepeatingChars.getLongestSubstringContainingKUniqueChars("abbddabccaaaad", 3);
        assertEquals("abccaaaa", result);
    }
 }
