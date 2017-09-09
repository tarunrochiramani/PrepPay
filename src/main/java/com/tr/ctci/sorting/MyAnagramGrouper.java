package com.tr.ctci.sorting;

import java.util.Comparator;

public class MyAnagramGrouper implements Comparator<String> {
    public int compare(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return s1.length() - s2.length();
        }

        Integer s1bitsXORd = getBitsXORd(s1);
        Integer s2bitsXORd = getBitsXORd(s2);

        return s1bitsXORd.compareTo(s2bitsXORd);
    }

    private Integer getBitsXORd(String str) {
        Integer checker = 0;
        char[] chars = str.toLowerCase().toCharArray();
        for (char c : chars) {
            checker ^= (1 << c - 'a');
        }
        return checker;
    }
}
