package com.tr.leetcode;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class NnumberSumTest {
    NnumberSum sum = new NnumberSum();

    @Test
    public void canGetThreeNumsWithGivenSum() {
        List<List<Integer>> result = sum.getThreeNumbersWithGivenSum(new int[]{-1, 0, 1, 2, -1, -4}, 0);

        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void canGetFourNumsWithGivenSum() {
        List<List<Integer>> result = sum.getFourNumbersWithGivenSum(new int[]{1, 0, -1, 0, -2, 2}, 0);

        assertNotNull(result);
        assertFalse(result.isEmpty());
    }
}
