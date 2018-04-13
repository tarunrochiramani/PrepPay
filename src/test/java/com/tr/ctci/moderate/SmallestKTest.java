package com.tr.ctci.moderate;

import com.tr.exceptions.InvalidInputException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SmallestKTest {

    private SmallestK smallestK = new SmallestK();

    @Test
    public void canGetSmallestK() throws InvalidInputException {
        int[] input = new int[] {5,3,0,6,7,1,4,2,11,50,22,55};
        Integer[] expectedResult = new Integer[] {0, 1, 2, 3, 4};

        Assert.assertArrayEquals(expectedResult, smallestK.smallestK(input, 5));

    }

}
