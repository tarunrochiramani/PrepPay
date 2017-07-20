package com.tr.stringops;

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
}
