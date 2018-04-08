package com.tr.leetcode;

import com.tr.exceptions.InvalidInputException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class RegexMatcherTest {
    private RegexMatcher regexMatcher = new RegexMatcher();

    @Test (expected = InvalidInputException.class)
    public void cannotMatchWithNullText() throws InvalidInputException {
        regexMatcher.matchesRegex(null, "a");
    }

    @Test (expected = InvalidInputException.class)
    public void cannotMatchWithNullPattern() throws InvalidInputException {
        regexMatcher.matchesRegex("abc", null);
    }

    @Test (expected = InvalidInputException.class)
    public void cannotMatchWithEmptyPattern() throws InvalidInputException {
        regexMatcher.matchesRegex("abc", "");
    }

    @Test (expected = InvalidInputException.class)
    public void cannotMatchWithEmptyText() throws InvalidInputException {
        regexMatcher.matchesRegex("", "a");
    }

    @Test (expected = InvalidInputException.class)
    public void cannotMatchWithInvalidPattern() throws InvalidInputException {
        regexMatcher.matchesRegex("abc", "*a*");
    }

    @Test (expected = InvalidInputException.class)
    public void cannotMatchWithInvalidPattern_1() throws InvalidInputException {
        regexMatcher.matchesRegex("abc", "a*b**c");
    }

    @Test
    public void canMatch() throws InvalidInputException {
        assertTrue(regexMatcher.matchesRegex("aa", "aa"));
        assertTrue(regexMatcher.matchesRegex("aa", "a*"));
        assertTrue(regexMatcher.matchesRegex("aa", ".*"));
        assertTrue(regexMatcher.matchesRegex("ab", ".*"));
        assertTrue(regexMatcher.matchesRegex("aab", "c*a*b"));
        assertTrue(regexMatcher.matchesRegex("acb", "a.b"));
        assertTrue(regexMatcher.matchesRegex("aaa", "a*aaa"));
        assertTrue(regexMatcher.matchesRegex("a", "ab*"));

        assertFalse(regexMatcher.matchesRegex("aa", "a"));
        assertFalse(regexMatcher.matchesRegex("aa", "aaa"));
        assertFalse(regexMatcher.matchesRegex("aaa", "aa"));
        assertFalse(regexMatcher.matchesRegex("ab", "a*"));
        assertFalse(regexMatcher.matchesRegex("aaa", "a*b"));
        assertFalse(regexMatcher.matchesRegex("aaa", "a.b"));
        assertFalse(regexMatcher.matchesRegex("a", "ab*a"));
    }

}
