package com.tr.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.util.Pair;

public class ThreeSum {
    public List<List<Integer>> getThreeNumbersWithGivenSum(int[] array, int sum) {
        Arrays.sort(array);

        List<List<Integer>> result = new ArrayList<>();
        for (int pos = 0; pos < array.length -2; pos++) {
            int difference = sum - array[pos];
            int start = pos+1, end=array.length-1;
            while(start<end) {
                if (difference == (array[start] + array[end])) {
                    List<Integer> currentList = new ArrayList<>();
                    currentList.add(array[pos]);
                    currentList.add(array[start]);
                    currentList.add(array[end]);
                    result.add(currentList);
                    break;
                } else if (difference < (array[start] + array[end])) {
                    end --;
                } else {
                    start++;
                }
            }
        }


        return result;
    }
}
