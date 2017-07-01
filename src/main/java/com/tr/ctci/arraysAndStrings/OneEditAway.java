package com.tr.ctci.arraysAndStrings;

public class OneEditAway {
    public boolean isOneEditAway(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }

        String small = s1.length() < s2.length() ? s1 : s2;
        String big = s1.length() < s2.length() ? s2 : s1;

        if (big.length() - small.length() > 1 ) {
            return false;
        }

        int index1 = 0;
        int index2 = 0;

        boolean foundDifference = false;
        while (index2<big.length() && index1<small.length()) {
            if (big.charAt(index2) != small.charAt(index1)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;

                if (big.length() == small.length()) {
                    index1++;
                    index2++;
                } else {
                    index2++;
                }
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }
}
