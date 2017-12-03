package com.tr.leetcode;

import java.util.Arrays;
import java.util.List;

import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class ThreeSumTest {
    ThreeSum sum = new ThreeSum();

    @Test
    public void canGetThreeNumsWithGivenSum() {
        List<List<Integer>> result = sum.getThreeNumbersWithGivenSum(new int[]{-1, 0, 1, 2, -1, -4}, 0);

        assertNotNull(result);
        assertFalse(result.isEmpty());


    }
}
