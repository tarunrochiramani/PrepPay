package com.tr.geeks4geeks;

import java.util.Arrays;

import javafx.util.Pair;

public class ClosestToZeroSum {

    public Pair<Integer, Integer> getClosestToZeroSum(int[] input) {
        Arrays.sort(input);

        int start=0, end=input.length-1;
        int minSum = Integer.MAX_VALUE;
        int value1=0, value2=0;
        while (start < end) {
            if (input[start] + input[end] < 0) {
                start ++;
            } else {
                int sum = input[start] + input[end];
                if (sum < minSum) {
                    minSum = sum;
                    value1 = input[start];
                    value2 = input[end];
                }
                end --;
            }
        }

        return new Pair<Integer, Integer>(value1, value2);
    }
}
