package com.tr.ctci.recursive;

import java.util.ArrayList;
import java.util.List;

public class Paranthesis {

    public List<String> generateParens(int count) {
        List<String> result = new ArrayList<>();
        generateParens(result, count, count, new char[count * 2], 0);
        return result;
    }

    private void generateParens(List<String> strings, int left, int right, char[] chars, int index) {
        if (left <0 || right < left) {
            return;
        }

        if (left == 0 && right == 0) {
            strings.add(new String(chars));
        } else {
            chars[index] = '(';
            generateParens(strings, left -1, right, chars, index +1 );

            chars[index] = ')';
            generateParens(strings, left, right-1, chars, index +1 );
        }
    }
}

class Driver {
    public static void main(String[] args) {
        Paranthesis paranthesis = new Paranthesis();
        paranthesis.generateParens(3);
    }
}
