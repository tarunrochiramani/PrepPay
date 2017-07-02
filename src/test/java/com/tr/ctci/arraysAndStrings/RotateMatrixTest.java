package com.tr.ctci.arraysAndStrings;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(JUnit4.class)
public class RotateMatrixTest {
    RotateMatrix rotateMatrix = new RotateMatrix();

    @Test
    public void canRotateWithLowSize() {
        int[][] input = createMatrix(2);
        int[][] originalInput = createMatrix(2);
        printMatrix(input);
        assertEquals(originalInput, input);

        rotateMatrix.rotateNinetyDegreeClockwise(input);

        printMatrix(input);
        assertNotEquals(originalInput, input);

    }

    @Test
    public void canRotateWithSize3() {
        int[][] input = createMatrix(3);
        int[][] originalInput = createMatrix(3);
        printMatrix(input);
        assertEquals(originalInput, input);

        rotateMatrix.rotateNinetyDegreeClockwise(input);

        printMatrix(input);
        assertNotEquals(originalInput, input);

    }

    @Test
    public void canRotateWithSize4() {
        int[][] input = createMatrix(4);
        int[][] originalInput = createMatrix(4);
        printMatrix(input);
        assertEquals(originalInput, input);

        rotateMatrix.rotateNinetyDegreeClockwise(input);

        printMatrix(input);
        assertNotEquals(originalInput, input);

    }

    @Test
    public void canRotateWithSize5() {
        int[][] input = createMatrix(5);
        int[][] originalInput = createMatrix(5);
        printMatrix(input);
        assertEquals(originalInput, input);

        rotateMatrix.rotateNinetyDegreeClockwise(input);

        printMatrix(input);
        assertNotEquals(originalInput, input);

    }

    private int[][] createMatrix(int size) {
        int[][] matrix = new int[size][size];

        int counter = 1;
        for (int x =0; x<size; x++) {
            for (int y=0; y<size; y++) {
                matrix[x][y] = counter++;
            }
        }

        return matrix;
    }

    private void printMatrix(int[][] matrix) {
        int size = matrix.length;

        System.out.println("=============Matrix==============");
        for (int x =0; x<size; x++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int y=0; y<size; y++) {
                int value = matrix[x][y];
                stringBuilder.append(matrix[x][y] + " ");
                if (value < 10) {
                    stringBuilder.append(" ");
                }
            }
            System.out.println(stringBuilder.toString());
        }
        System.out.println("=================================");
    }
}
