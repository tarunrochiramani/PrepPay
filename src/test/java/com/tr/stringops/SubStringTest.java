package com.tr.stringops;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertFalse;
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

}
