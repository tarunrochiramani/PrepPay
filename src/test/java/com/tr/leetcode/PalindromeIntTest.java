package com.tr.leetcode;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class PalindromeIntTest {
    private PalindromeInt palindromeInt = new PalindromeInt();

    @Test
    public void canCheckIfPalindrome() {
        assertFalse(palindromeInt.isPalindrome(1));
        assertFalse(palindromeInt.isPalindrome(10));
        assertTrue(palindromeInt.isPalindrome(1221));
        assertTrue(palindromeInt.isPalindrome(121));
        assertTrue(palindromeInt.isPalindrome(101));

    }
}
