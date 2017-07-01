package com.tr.ctci.arraysAndStrings;

import com.tr.ctci.arraysAndStrings.PalindromePermutation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class PalindromePermutationTest {
    PalindromePermutation palindromePermutation = new PalindromePermutation();

    @Test
    public void isPalindromePerm() {
        assertTrue(palindromePermutation.isPalindromePermutation("atatc"));
        assertTrue(palindromePermutation.isPalindromePermutation("atat"));
        assertFalse(palindromePermutation.isPalindromePermutation("abcb"));
    }
}
