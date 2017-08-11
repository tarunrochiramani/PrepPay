package com.tr.geeks4geeks;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class KnapsackDPTest {
    KnapsackDP knapsackDP = new KnapsackDP();

    @Test
    public void canGetKnapsackMemoizedValues() {
        int[] weights = new int[] {1, 2, 5, 6, 7};
        int[] values = new int[] {1, 6, 18, 22, 28};
        int[][] knapsackMemoization = knapsackDP.knapsackMemoization(weights, values, 11);

        assertNotNull(knapsackMemoization);
    }

    @Test
    public void canGetKnapsacK() {
        int[] weights = new int[] {1, 2, 5, 6, 7};
        int[] values = new int[] {1, 6, 18, 22, 28};
        int[][] knapsackMemoization = knapsackDP.knapsackMemoization(weights, values, 11);
        List<Integer> valuesOfItemsPicked = knapsackDP.itemsPicked(knapsackMemoization, weights, values);

        assertNotNull(valuesOfItemsPicked);
        assertEquals(2, valuesOfItemsPicked.size());
        assertTrue(valuesOfItemsPicked.contains(22));
        assertTrue(valuesOfItemsPicked.contains(18));
    }


}
