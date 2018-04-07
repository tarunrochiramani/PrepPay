package com.tr.leetcode;

import com.tr.exceptions.InvalidInputException;

public class RegexMatcher {

    public boolean matchesRegex(String text, String pattern) throws InvalidInputException {
        if (text == null || text.isEmpty() || pattern == null || pattern.isEmpty()) {
            throw new InvalidInputException();
        }

        int[] wildcardOccurrences = analyzePatternForWildcard(pattern);
        int patternPos=0, textPos = 0;
        while (textPos < text.length()) {
            if (patternPos == pattern.length()) {
                break;
            }

            if (patternPos == (pattern.length()-1) || wildcardOccurrences[patternPos+1] == 0) {
                if (pattern.charAt(patternPos) != '.' && pattern.charAt(patternPos) != text.charAt(textPos)) {
                    return false;
                }
                textPos++;
                patternPos++;
            } else {
                if (pattern.charAt(patternPos) == '.' || pattern.charAt(patternPos) == text.charAt(textPos)) {
                    textPos++;
                } else {
                    patternPos+=2;
                }
            }
        }

        if (textPos == text.length() && (patternPos == pattern.length() || patternPos+2 == pattern.length())) {
            return true;
        }

        return false;
    }

    private int[] analyzePatternForWildcard(String pattern) throws InvalidInputException {
        int[] wildcardOccurrences = new int[pattern.length()];

        int pos = 0;
        for (char patternChar : pattern.toCharArray()) {
            if (patternChar == '*') {
                if (pos == 0 || wildcardOccurrences[pos-1] == 1) {
                    throw new InvalidInputException();
                }
                wildcardOccurrences[pos] = 1;
            } else {
                wildcardOccurrences[pos] = 0;
            }
            pos++;
        }

        return wildcardOccurrences;
    }
}
