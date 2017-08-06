package com.tr.geeks4geeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringPermutation {

    public List<String> recursivePerms(String prefix, String input) {
        List<String> results = new ArrayList<String>();
        if (input.length() == 0) {
            results.add(prefix);
            return results;
        }

        for (int pos =0; pos<input.length(); pos++) {
            List<String> perms = recursivePerms(prefix + input.charAt(pos), input.substring(0, pos) + input.substring(pos + 1));
            results.addAll(perms);
        }
        return results;
    }

    public List<String> permutations(String input) {
        if(input == null) {
            return null;
        }

        if (input.length() == 1) {
            return Arrays.asList(input);
        }

        List<String> result = null;

        char c = input.charAt(0);
        String rem = input.substring(1);
        List<String> subStringPermutations = permutations(rem);
        result = insertCharAtEveryPost(c, subStringPermutations);

        return result;
    }

    private List<String> insertCharAtEveryPost(char c, List<String> subStringPermutations) {
        List<String> result = new ArrayList<String>();
        for (String subStringPermutation : subStringPermutations) {
            result.add(c + subStringPermutation);
            for (int count = 0; count < subStringPermutation.length()-1; count++) {
                result.add(subStringPermutation.substring(0, count+1) + c + subStringPermutation.substring(count+1));
            }
            result.add(subStringPermutation + c);
        }
        return result;
    }
}
