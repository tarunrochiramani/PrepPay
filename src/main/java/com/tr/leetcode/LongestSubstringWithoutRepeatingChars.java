package com.tr.leetcode;

import java.util.HashMap;
import java.util.Map;

import com.tr.exceptions.InvalidInputException;

public class LongestSubstringWithoutRepeatingChars {

    public String getLongestSubStringWithoutRepeatingChars(String input) throws InvalidInputException {
        if (input == null || input.isEmpty()) {
            throw new InvalidInputException();
        }

        String result = "";
        Map<Character, Integer> indexes = new HashMap<>();
        int start = 0, end=0;
        while (end < input.length()) {
            char currentChar = input.charAt(end);
            if (!indexes.containsKey(currentChar)) {
                indexes.put(currentChar, end);
            } else {
                if (result.length() < (end - start)) {
                    result = input.substring(start, end);
                }
                while (start != indexes.get(currentChar)) {
                    indexes.remove(input.charAt(start));
                    start++;
                }
                start++;
            }
            end++;
        }

        if (result.length() < (end - start)) {
            result = input.substring(start, end);
        }
        return result;
    }

    public String getLongestSubstringContainingKUniqueChars(String input, int noOfUniqueChars) throws InvalidInputException {
        if (input == null || input.isEmpty() || noOfUniqueChars <= 0) {
            throw new InvalidInputException();
        }

        Map<Character, Integer> lastCharIndexMapper = new HashMap<>();
        int start=0, end=0;
        String result = null;
        while (end < input.length()) {
            char currentChar = input.charAt(end);
            lastCharIndexMapper.put(currentChar, end);
            if (lastCharIndexMapper.size() > noOfUniqueChars) {
                if (result == null || result.length() < (end - start)) {
                    result = input.substring(start, end);
                }
                char lowestOccurringChar = getlowestOccurringChar(lastCharIndexMapper);
                start = lastCharIndexMapper.get(lowestOccurringChar);
                start++;
                lastCharIndexMapper.remove(lowestOccurringChar);
            }
            end ++;
        }

        if (result == null || result.length() < (end - start)) {
            result = input.substring(start, end);
        }
        return result;
    }

    private char getlowestOccurringChar(Map<Character, Integer> lastCharIndexMapper) {
        int lowest_occurrence = Integer.MAX_VALUE;
        Character result = null;
        for (Map.Entry<Character, Integer> entry : lastCharIndexMapper.entrySet()) {
            if (entry.getValue() < lowest_occurrence) {
                result = entry.getKey();
            }
        }

        return result;
    }
}
