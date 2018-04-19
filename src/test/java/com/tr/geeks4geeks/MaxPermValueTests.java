package com.tr.geeks4geeks;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MaxPermValueTests {

    private MaxPermValue maxPermValue = new MaxPermValue();

    @Test
    public void canGetMaxPermValue() {
        Integer[] input = new Integer[] {33, 12, 9, 1, 5};
        Integer[] expectedOutput = new Integer[] {9, 5, 33, 12, 1};
        Assert.assertArrayEquals(expectedOutput, maxPermValue.getMaxPermValue(input));
    }
}
