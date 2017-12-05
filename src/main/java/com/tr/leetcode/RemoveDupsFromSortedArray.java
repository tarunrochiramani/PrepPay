package com.tr.leetcode;

public class RemoveDupsFromSortedArray {

    public int inPlaceRemoveDups(int[] inputArray) {
        if (inputArray.length <= 1) {
            return inputArray.length;
        }

        int current=0, fast=1;
        while (fast < inputArray.length) {
            if (inputArray[fast] != inputArray[current]) {
                inputArray[++current] = inputArray[fast];
            }

            fast++;
        }

        int length = ++current;
        while (current < inputArray.length) {
            inputArray[current] = 0;
            current++;
        }
        return length;
    }
}
