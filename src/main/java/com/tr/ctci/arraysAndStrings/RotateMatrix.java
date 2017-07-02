package com.tr.ctci.arraysAndStrings;

public class RotateMatrix {

    public void rotateNinetyDegreeClockwise(int[][] input) {
        int offset = 0;


        while(offset < (input.length -1)) {
            int size = input.length -1 - offset;
            for (int x=offset, y=size; y>offset && x<size; x++, y--) {
                int temp = input[offset][x];
                input[offset][x] = input[y][offset];
                input[y][offset] = input[size][y];
                input[size][y] = input[x][size];
                input[x][size] = temp;
            }

            offset++;
        }
    }
}
