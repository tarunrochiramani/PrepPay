package com.tr.hkrnk;

public class CeasarCipher {
     public String cipher(String s, int k) {
        char[] rotatedChars = new char[s.length()];

        int pos =0;
        for (char c : s.toCharArray()) {
            if (c >='a' && c<='z') {
                int place = ((c - 'a') + k) % 26;
                rotatedChars[pos] = (char)(place + 'a');
            } else  if (c >='A' && c<='Z') {
                int place = ((c - 'A') + k) % 26;
                rotatedChars[pos] = (char)(place + 'A');
            } else {
                rotatedChars[pos] = c;
            }
            pos++;
        }

        return new String(rotatedChars);
    }
}
