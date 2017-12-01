package com.tr.geeks4geeks;

import com.tr.exceptions.InvalidInputException;

public class ReverseWithoutSpecial {

    public String reverseWithoutSpecial(String input) throws InvalidInputException {
        if (input == null || input.isEmpty()) {
            throw new InvalidInputException();
        }

        char[] chars = input.toCharArray();
        int start =0, end=chars.length-1;
        while (start < end) {
            if (isAlphabet(chars[start]) && isAlphabet(chars[end])) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            } else if (!isAlphabet(chars[start])) {
                start++;
            } else {
                end --;
            }
        }

        return new String(chars);
    }

    private boolean isAlphabet(char aChar) {
        if ((aChar >= 'A' && aChar <= 'Z') || (aChar >= 'a' && aChar <= 'z') )
            return true;

        return false;
    }
}
