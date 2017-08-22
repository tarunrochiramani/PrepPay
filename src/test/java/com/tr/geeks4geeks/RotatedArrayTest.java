package com.tr.geeks4geeks;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class RotatedArrayTest {
    RotatedArraySearch rotatedArraySearch = new RotatedArraySearch();

    @Test
    public void canGetMin() {
        assertEquals(1, rotatedArraySearch.findMin(new int[] {12, 15, 1, 3, 6, 9}));
        assertEquals(1, rotatedArraySearch.findMin(new int[] {15, 1, 3, 6, 9, 12}));
        assertEquals(1, rotatedArraySearch.findMin(new int[] {3, 6, 9, 12, 15, 1}));
    }
}
