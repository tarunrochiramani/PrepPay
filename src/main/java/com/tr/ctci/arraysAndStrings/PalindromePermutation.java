package com.tr.ctci.arraysAndStrings;

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

        if (checker == 0 || (checker & (checker - 1)) == 0) {
            return true;
        }

        return false;
    }
}
