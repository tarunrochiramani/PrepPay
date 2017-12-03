package com.tr.stringops;

import com.tr.exceptions.InvalidInputException;

public class LeetCode {
    public String getSubstringWithoutRepeatChars(String input) throws InvalidInputException {
        if (input == null || input.isEmpty()) {
            throw new InvalidInputException();
        }

        String result = "";
        int checker = 0, start = 0;
        char[] inputChars = input.toCharArray();
        for (int end = 0; end < inputChars.length; end++) {
            if ((checker & (1 << inputChars[end] - 'a')) > 0) {
                if (result.length() < (end - start)) {
                    result = new String(inputChars, start, end - start);
                }
                while(inputChars[end] != inputChars[start]) {
                    start++;
                }
                start++;
            }
            checker |= (1 << inputChars[end] - 'a');
        }

        if (result.length() < (inputChars.length - start)) {
            result = new String(inputChars, start, inputChars.length - start);
        }

        return result;
    }
}
