package com.tr.ctci.moderate;

import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class MinDifferencePairTest {
    MinDifferencePair minDifferencePair = new MinDifferencePair();

    @Test
    public void canGetMinDifferencePair() {
        Pair<Integer, Integer> minDifferencePair = this.minDifferencePair.getMinDifferencePair(new int[]{3, 2, 9, 6, 4, 10, 1}, new int[]{20, 8});

        assertNotNull(minDifferencePair);
        assertEquals(9, minDifferencePair.getKey().intValue());
        assertEquals(8, minDifferencePair.getValue().intValue());

    }
}
