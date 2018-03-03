package com.tr;

import java.util.ArrayList;
import java.util.List;

public class PairWithGivenSum {

    public static void main(String[] args) {
        int[] input = new int[] {1, 14, 20, 8, 4,  -5, 1};

        printPairWithGivenSum(input, 15);
    }

    public static void printPairWithGivenSum(int[] input, int sum) {
        if (input.length == 0) {
            System.out.println("Invalid Input - Input is empty");
        }

        List<Integer> additionalSpace = new ArrayList<>();
        List<Integer> coveredIndexes = new ArrayList<Integer>();
        for (int pos=0; pos<input.length; pos++) {
            additionalSpace.add(input[pos]);
        }

        for (int pos=0; pos<input.length; pos++) {

            if (coveredIndexes.contains(pos)) {
                continue;
            }

            int difference;
            if (sum >= 0) {
                difference = sum - input[pos];
            } else {
                difference = sum + input[pos];
            }

            if (additionalSpace.contains(difference)) {
                System.out.println("Values: " + input[pos] + "," + difference);

                coveredIndexes.add(additionalSpace.indexOf(input[pos]));
                coveredIndexes.add(additionalSpace.indexOf(difference));

                additionalSpace.remove(additionalSpace.indexOf(input[pos]));
                additionalSpace.remove(additionalSpace.indexOf(difference));

            }
        }
    }
}
