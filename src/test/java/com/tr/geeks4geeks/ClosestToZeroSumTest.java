package com.tr.geeks4geeks;

import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ClosestToZeroSumTest {
    ClosestToZeroSum closestToZeroSum = new ClosestToZeroSum();

    @Test
    public void canGetClosestToZeroSum() {
        Pair<Integer, Integer> pairs = this.closestToZeroSum.getClosestToZeroSum(new int[]{20, 5, 35, -1, -20});

        assertNotNull(pairs);
        assertEquals(-20, pairs.getKey().intValue());
        assertEquals(20, pairs.getValue().intValue());
    }
}
