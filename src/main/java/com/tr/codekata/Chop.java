package com.tr.codekata;

public class Chop {
    public int binaryChop(int target, int[] source) {
        if (source.length == 0) {
            return -1;
        }

        int start=0, end=source.length-1;
        while (start <= end) {
            int mid = (start+end)/2;
            if (source[mid] == target) {
                return mid;
            }

            if (target > source[mid]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        return -1;
    }
}
