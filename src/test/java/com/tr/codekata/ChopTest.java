package com.tr.codekata;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ChopTest {

    Chop chop = new Chop();

    @Test
    public void canChop() {
        assertEquals(-1, chop.binaryChop(3, new int[0]));
        assertEquals(-1, chop.binaryChop(3, new int[] {1}));
        assertEquals(0, chop.binaryChop(1, new int[] {1}));

        assertEquals(0, chop.binaryChop(1, new int[] {1, 3, 5}));
        assertEquals(1, chop.binaryChop(3, new int[] {1, 3, 5}));
        assertEquals(2, chop.binaryChop(5, new int[] {1, 3, 5}));
        assertEquals(-1, chop.binaryChop(0, new int[] {1, 3, 5}));
        assertEquals(-1, chop.binaryChop(2, new int[] {1, 3, 5}));
        assertEquals(-1, chop.binaryChop(4, new int[] {1, 3, 5}));
        assertEquals(-1, chop.binaryChop(6, new int[] {1, 3, 5}));


        assertEquals(0, chop.binaryChop(1, new int[] {1, 3, 5, 7}));
        assertEquals(1, chop.binaryChop(3, new int[] {1, 3, 5, 7}));
        assertEquals(2, chop.binaryChop(5, new int[] {1, 3, 5, 7}));
        assertEquals(3, chop.binaryChop(7, new int[] {1, 3, 5, 7}));

        assertEquals(-1, chop.binaryChop(0, new int[] {1, 3, 5, -7}));
        assertEquals(-1, chop.binaryChop(2, new int[] {1, 3, 5, -7}));
        assertEquals(-1, chop.binaryChop(4, new int[] {1, 3, 5, -7}));
        assertEquals(-1, chop.binaryChop(6, new int[] {1, 3, 5, -7}));
        assertEquals(-1, chop.binaryChop(8, new int[] {1, 3, 5, -7}));
    }
}
