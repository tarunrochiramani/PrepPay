package com.tr.leetcode;

public class PalindromeInt {

    public boolean isPalindrome(int input) {

        if (input >= 10) {
            int partiallyReversed = 0;
            while (true) {
                partiallyReversed = (partiallyReversed * 10) + input % 10;
                input /= 10;
                if (input > 0 && (input == partiallyReversed || input == partiallyReversed / 10)) {
                    return true;
                }
                if (input < partiallyReversed) {
                    break;
                }
            }
        }
        return false;
    }
}
