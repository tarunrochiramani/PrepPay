package com.tr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class WordsInParts {
    public List<String> findSubstrings(String[] words, String[] parts) {
        Arrays.sort(parts, new DescLengthComparator());

        List<String> result = new ArrayList<>();
        for (String word : words) {
            String subString = "";
            for (String part : parts) {
                if (word.contains(part)) {
                    if (subString.length() < part.length()) {
                        subString = part;
                    }
                }
            }
            result.add(word.replaceFirst(subString, "[" +subString+ "]"));
        }
        return result;
    }
}

class DescLengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if (o1.length() == o2.length()) {
            return 0;
        }
        if (o2.length() > o1.length()) {
            return 1;
        }
        return -1;
    }
}
