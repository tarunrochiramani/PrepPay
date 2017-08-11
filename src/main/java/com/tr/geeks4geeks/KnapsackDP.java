package com.tr.geeks4geeks;

import java.util.ArrayList;
import java.util.List;

public class KnapsackDP {

    public int[][] knapsackMemoization(int[] weights, int[] values, int knapSackSize) {
        int[][] memoizedValues = new int[weights.length+1][knapSackSize + 1];

        for (int weigthPos=0; weigthPos<=weights.length; weigthPos++) {
            for (int aWeigth=0; aWeigth<=knapSackSize; aWeigth++) {
                if (weigthPos ==0 || aWeigth == 0) {
                    memoizedValues[weigthPos][aWeigth]=0;
                } else if (weights[weigthPos-1] <= aWeigth) {
                    memoizedValues[weigthPos][aWeigth]=Math.max(values[weigthPos-1] + memoizedValues[weigthPos-1][aWeigth-(weights[weigthPos-1])], memoizedValues[weigthPos-1][aWeigth]);
                } else {
                    memoizedValues[weigthPos][aWeigth] = memoizedValues[weigthPos-1][aWeigth];
                }
            }
        }

        return memoizedValues;
    }

    public List<Integer> itemsPicked(int[][] memoizedValues, int[] weights, int[] values) {
        int x=memoizedValues.length-1;
        int y=memoizedValues[x].length-1;

        List<Integer> itemsPicked = new ArrayList<Integer>();
        while(x > 0 && y >0) {
            if (memoizedValues[x][y] != memoizedValues[x-1][y]) {
                itemsPicked.add(values[x-1]);
                y -= weights[x-1];
            }
            x = x -1;
        }

        return itemsPicked;
    }
}
