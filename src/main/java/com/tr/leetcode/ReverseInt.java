package com.tr.leetcode;

public class ReverseInt {

    public int reverse(int input) {
        int result = 0;
        boolean isNegative = input < 0 ? true : false;
        if (isNegative) {
            input *= -1;
        }
        while (input > 0) {
            int tail  = input%10;
            result = (result * 10) + tail;
            input /= 10;
        }
        if (isNegative) {
            result *= -1;
        }

        return result;
    }
}
