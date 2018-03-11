package com.tr.ctci.moderate;

import com.tr.exceptions.InvalidInputException;
import javafx.util.Pair;

public class UnsortedSequence {

    public Pair<Integer, Integer> findUnsortedSequence(int[] source) throws InvalidInputException {
        if (source == null || source.length <= 1) {
            throw new InvalidInputException();
        }

        int left_end = findLeftEnd(source);
        if (left_end == source.length) {
            return new Pair<>(0,0);
        }

        int right_start = findRightStart(source);

        int min_index = right_start;
        int max_index = left_end;

        for (int pos = left_end +1; pos<right_start; pos++) {
            if (source[pos] < source[min_index]) {
                min_index = pos;
            }
            if (source[pos] > source[max_index]) {
                max_index = pos;
            }
        }

        int left_side = 0, right_side = 0;
        for (int pos = left_end ; pos >=0; pos--) {
            if (source[pos] < source[min_index]) {
                left_side = pos;
                break;
            }
        }

        for (int pos=right_start; pos<source.length; pos++) {
            if (source[pos] > source[max_index]) {
                right_side = pos;
                break;
            }
        }

        return new Pair<>(left_side, right_side);
    }

    private int findRightStart(int[] source) {
        for (int pos = source.length -2; pos >=0; pos--) {
            if (source[pos] > source[pos+1]) {
                return pos+1;
            }
        }

        return 0;
    }

    private int findLeftEnd(int[] source) {
        for (int pos = 1; pos < source.length; pos ++) {
            if (source[pos] < source [pos -1]) {
                return pos-1;
            }
        }
        return source.length;
    }
}
