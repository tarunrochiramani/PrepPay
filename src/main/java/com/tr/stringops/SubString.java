package com.tr.stringops;

import com.tr.exceptions.InvalidInputException;

public class SubString {

    public boolean isSubstringBruteForce(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }

        if (s2.length() > s1.length()) {
            return false;
        }

        for (int s1Count=0; s1Count<=(s1.length() - s2.length()); s1Count++) {
            int s2Count;
            for (s2Count=0; s2Count<s2.length(); s2Count++) {
                if (s1.charAt(s1Count + s2Count) != s2.charAt(s2Count)) {
                    break;
                }
            }
            if (s2Count == s2.length()) {
                return true;
            }
        }
        return false;
    }

    public int[] kmpPrefix(String input) throws InvalidInputException {
        if (input == null) {
            throw new InvalidInputException();
        }

        int[] prefixValues = new int[input.length()];
        int suffixIndex = 0;
        prefixValues[0] = suffixIndex;
        for (int pos = 1; pos < input.length(); pos++) {
            while (suffixIndex > 0 && (input.charAt(suffixIndex) != input.charAt(pos))) {
                suffixIndex = prefixValues[suffixIndex-1];
            }
            if (input.charAt(suffixIndex) == input.charAt(pos)) {
                suffixIndex ++;
            }
            prefixValues[pos] = suffixIndex;
        }
        return prefixValues;
    }

    public int kmpSubstringSearch(String text, String pattern) throws InvalidInputException {
        if (pattern == null || text == null) {
            throw new InvalidInputException();
        }

        if (pattern.length() > text.length()) {
            throw new InvalidInputException();
        }


        int[] prefixValues = kmpPrefix(pattern);
        int patternPos = 0;
        for (int textPos=0; textPos<text.length(); textPos++) {
            while(patternPos > 0 && text.charAt(textPos) != pattern.charAt(patternPos)) {
                patternPos = prefixValues[patternPos - 1];
            }

            if (text.charAt(textPos) == pattern.charAt(patternPos)) {
                patternPos++;
            }

            if (patternPos == pattern.length()) {
                return (textPos - pattern.length() + 1);
            }
        }

        return -1;
    }
}
