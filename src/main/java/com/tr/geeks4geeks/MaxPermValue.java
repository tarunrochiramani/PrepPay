package com.tr.geeks4geeks;

import java.util.Arrays;
import java.util.Comparator;

public class MaxPermValue {

    public Integer[] getMaxPermValue(Integer[] input) {
        Arrays.sort(input, new MaxPermValueComparator());
        return input;
    }
}

class MaxPermValueComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        Integer big, small;
        if (o1 > o2) {
            big = o1;
            small = o2;
        } else {
            big = o2;
            small = o1;
        }

        int bigNoOfDigits = 0;
        int big1 = big;
        while (big %10 > 0) {
            big /=10;
            bigNoOfDigits++;
        }

        int smallNoOfDigits = 0;
        int small1 = small;
        while (small %10 > 0) {
            small /=10;
            smallNoOfDigits++;
        }

        Integer bigPlusSmall = ((int) (big1 * Math.pow(10, smallNoOfDigits))) + small1;
        Integer smallPlusBig = ((int)(small1 * Math.pow(10, bigNoOfDigits))) + big1;
        return bigPlusSmall.compareTo(smallPlusBig);
    }
}
