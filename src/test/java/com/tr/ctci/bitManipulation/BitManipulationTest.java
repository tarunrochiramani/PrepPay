package com.tr.ctci.bitManipulation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class BitManipulationTest {
    BitManipulation bitManipulation = new BitManipulation();

    @Test
    public void canGetBit() {
        assertEquals(1, bitManipulation.getBit(4, 2));
        assertEquals(0, bitManipulation.getBit(4, 1));
        assertEquals(0, bitManipulation.getBit(4, 0));
    }


    @Test
    public void canSetBit() {
        assertEquals(6, bitManipulation.setBit(4, 1));
        assertEquals(5, bitManipulation.setBit(4, 0));
    }

    @Test
    public void canClearBit() {
        assertEquals(0, bitManipulation.clearBit(4, 2));
        assertEquals(4, bitManipulation.clearBit(5, 0));
    }

    @Test
    public void canUpdateBit() {
        assertEquals(7, bitManipulation.updateBit(5, 1, true));
        assertEquals(4, bitManipulation.updateBit(5, 0, false));
        assertEquals(5, bitManipulation.updateBit(5, 1, false));
    }

}
