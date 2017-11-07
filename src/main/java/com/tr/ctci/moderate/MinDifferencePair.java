package com.tr.ctci.moderate;

import java.util.Arrays;

import javafx.util.Pair;

public class MinDifferencePair {

    public Pair<Integer, Integer> getMinDifferencePair(int[] source1, int[] source2) {
        Arrays.sort(source1);
        Arrays.sort(source2);

        int source1counter = 0;
        int source2counter = 0;
        int difference = Integer.MAX_VALUE;

        int source1Value=0, source2Value=0;
        while (source1counter < source1.length && source2counter < source2.length) {
            if (Math.abs(source1[source1counter] - source2[source2counter]) < difference) {
                difference = Math.abs(source1[source1counter] - source2[source2counter]);
                source1Value = source1[source1counter];
                source2Value = source2[source2counter];
            }

            if (source1[source1counter] < source2[source2counter]) {
                source1counter++;
            } else {
                source2counter++;
            }
        }

        return new Pair<>(source1Value, source2Value);

    }
}
