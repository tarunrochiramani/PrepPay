package com.tr.geeks4geeks;

public class RotatedArraySearch {

    public int findMin(int[] rotatedArray) {
        return findMin(rotatedArray, 0, rotatedArray.length-1);
    }

    private int findMin(int[] rotatedArray, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;

            if (mid > 0 && rotatedArray[mid] < rotatedArray[mid - 1]) {
                return rotatedArray[mid];
            }

            if (rotatedArray[start] <= rotatedArray[mid] && rotatedArray[mid] > rotatedArray[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return rotatedArray[start];
    }
}
