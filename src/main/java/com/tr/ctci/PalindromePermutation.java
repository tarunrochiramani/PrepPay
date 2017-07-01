package com.tr.ctci;

public class PalindromePermutation {
    public boolean isPalindromePermutation(String input) {
        if (input == null) {
            return false;
        }

        int checker = 0;
        for (int pos=0; pos<input.length(); pos++) {
            char c = input.charAt(pos);
            checker ^= (1 << c - 'a');
        }

        if (checker == 0) {
            return true;
        }

        if ((checker & -checker) == checker) {
            return true;
        }
        return false;
    }
}
