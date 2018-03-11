package com.tr.stringops;

import com.tr.exceptions.InvalidInputException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class SubStringTest {
    SubString subString = new SubString();

    @Test
    public void canCheckIsSubStringBruteForce() {
        assertTrue(subString.isSubstringBruteForce("abcdcdegh", "cde"));
        assertTrue(subString.isSubstringBruteForce("abcdcdaghcde", "cde"));
        assertFalse(subString.isSubstringBruteForce(null, "abc"));
        assertFalse(subString.isSubstringBruteForce("ab", "abc"));
    }

    @Test
    public void canGetKMPPrefix() throws InvalidInputException {
        int[] expectedPrefix = new int[] {0, 0, 1, 2, 3, 4, 0, 1};
        int[] kmpPrefix = subString.kmpPrefix("abababca");

        assertNotNull(kmpPrefix);
        assertArrayEquals(expectedPrefix, kmpPrefix);
    }

    @Test
    public void canGetKMPPrefix_1() throws InvalidInputException {
        int[] expectedPrefix = new int[] {0, 0, 0, 0, 0, 1};
        int[] kmpPrefix = subString.kmpPrefix("abbbba");

        assertNotNull(kmpPrefix);
        assertArrayEquals(expectedPrefix, kmpPrefix);
    }


    @Test
    public void canDoKMPSubStringSearch() throws InvalidInputException {
        int foundIndex = subString.kmpSubstringSearch("abcdefgh", "def");

        assertEquals(3, foundIndex);
    }

    @Test
    public void canDoKMPSubStringSearch_1() throws InvalidInputException {
        int foundIndex = subString.kmpSubstringSearch("bacbababaabcbab", "ababaca");

        assertEquals(-1, foundIndex);
    }

    @Test
    public void canDoKMPSubStringSearch_2() throws InvalidInputException {
        int foundIndex = subString.kmpSubstringSearch("bacbababadabababaacbab", "ababaa");

        assertEquals(12, foundIndex);
    }

    @Test(expected = InvalidInputException.class)
    public void cannotDoKMPSubstringSearchWithInvalidText() throws InvalidInputException {
        subString.kmpSubstringSearch("a", null);
    }

    @Test(expected = InvalidInputException.class)
    public void cannotDoKMPSubstringSearchWithInvalidPattern() throws InvalidInputException {
        subString.kmpSubstringSearch(null, "a");
    }

    @Test
    public void canCheckRabinKarpSubStringSearch() throws InvalidInputException {
        assertTrue(subString.rabinKarpSubStringSearch("watermelon", "mel"));
    }


}
