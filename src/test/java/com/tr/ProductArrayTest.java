package com.tr;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertArrayEquals;

@RunWith(JUnit4.class)
public class ProductArrayTest {
    private ProductArray productArray = new ProductArray();

    @Test
    public void canCalculateProductArray() throws InvalidInputException {
        int input[] = new int[] {1, 2, 3, 4};
        int result[] = new int[] {24, 12, 8, 6};

        assertArrayEquals(result, productArray.calculateProductArray(input));
    }


    @Test (expected = InvalidInputException.class)
    public void cannotCalculateProductArray() throws InvalidInputException {
        int input[] = new int[]{1};

        productArray.calculateProductArray(input);
    }
}
