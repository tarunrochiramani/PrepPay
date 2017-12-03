package com.tr.stringops;

import com.tr.exceptions.InvalidInputException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class LeetCodeTest {
    private LeetCode leetCode = new LeetCode();

    @Test
    public void canGetSubstringWithoutRepeatingChars() throws InvalidInputException {
        assertEquals("bcdaf", leetCode.getSubstringWithoutRepeatChars("abcdaf"));
        assertEquals("b", leetCode.getSubstringWithoutRepeatChars("bbbbb"));
        assertEquals("abcdef", leetCode.getSubstringWithoutRepeatChars("abcdef"));
        assertEquals("abecf", leetCode.getSubstringWithoutRepeatChars("ababecf"));
    }
}
