package com.tr;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)

/*
0       6       12
    3       9       15
1       7       13
    4       10      16
2       8       14
    5       11      17
*/

public class HexGridTest {
    private HexGrid hexGrid = new HexGrid(3, 6);

    @Test
    public void canGetAdjacentTiles() {
        List<Integer> adjacentTiles = hexGrid.getAdjacentTiles(10);
        assertNotNull(adjacentTiles);
        assertFalse(adjacentTiles.isEmpty());
        assertArrayEquals(new Integer[] { 9, 13, 14, 11, 8, 7}, adjacentTiles.toArray(new Integer[6]));
    }


    @Test
    public void canGetAdjacentTiles_1() {
        List<Integer> adjacentTiles = hexGrid.getAdjacentTiles(13);
        assertNotNull(adjacentTiles);
        assertFalse(adjacentTiles.isEmpty());
        assertArrayEquals(new Integer[] {12, 15, 16, 14, 10, 9}, adjacentTiles.toArray(new Integer[6]));
    }

    @Test
    public void canGetAdjacentTiles_2() {
        List<Integer> adjacentTiles = hexGrid.getAdjacentTiles(15);
        assertNotNull(adjacentTiles);
        assertFalse(adjacentTiles.isEmpty());
        assertArrayEquals(new Integer[] {-1, -1, -1, 16, 13, 12}, adjacentTiles.toArray(new Integer[6]));
    }
}
