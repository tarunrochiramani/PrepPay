package com.tr;

import java.util.ArrayList;
import java.util.List;

public class HexGrid {

    private int heigth, width;
    private static int EMPTY = -1;

    public HexGrid(int heigth, int width) {
        this.heigth = heigth;
        this.width = width;
    }

    public List<Integer> getAdjacentTiles(int position) {
        if (position < 0 || position >= (heigth * width)) {
            throw new IllegalArgumentException();
        }

        List<Integer> result = new ArrayList<>();
        int row = position % heigth;
        int column = position / heigth;
        boolean oddColumn = (column+1)%2 != 0;

        result.add(getNorth(position, row));
        result.add(getNorthEast(position, row, column, oddColumn));
        result.add(getSouthEast(position, row, column, oddColumn));
        result.add(getSouth(position, row));
        result.add(getSouthWest(position, row, column, oddColumn));
        result.add(getNorthWest(position, row, column, oddColumn));

        return result;
    }

    private int getNorth(int position, int row) {
        if (row == 0) {
            return EMPTY;
        }

        return position - 1;
    }

    private int getSouth(int position, int row) {
        if (row + 1 == heigth) {
            return EMPTY;
        }

        return position + 1;
    }

    private int getNorthEast(int position, int row, int column, boolean oddColumn) {

        if ((row ==0 && oddColumn) || column+1 == width) {
            return EMPTY;
        }

        int value = position + this.heigth;
        if (oddColumn) {
            value -= 1;
        }

        return value;
    }

    private int getNorthWest(int position, int row, int column, boolean oddColumn) {
        if ((row ==0 && oddColumn) || column == 0) {
            return EMPTY;
        }

        int value = position - this.heigth;
        if (oddColumn) {
            value -= 1;
        }

        return value;
    }

    private int getSouthEast(int position, int row, int column, boolean oddColumn) {

        if (((row + 1 == heigth) && !oddColumn) || (column +1 == width)) {
            return EMPTY;
        }

        int value = position + this.heigth + 1;
        if (oddColumn) {
            value -= 1;
        }

        return value;
    }

    private int getSouthWest (int position, int row, int column, boolean oddColumn) {

        if (((row + 1 == heigth) && !oddColumn) || (column  == 0)) {
            return EMPTY;
        }

        int value = position - this.heigth + 1;
        if (oddColumn) {
            value -= 1;
        }

        return value;
    }
}
