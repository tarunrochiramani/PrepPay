package com.tr.ctci.sorting;

public class SearchInSortedArrayNoSize {

    public int search(ArrayWithNoSize collection, int searchValue) {

        int index=1;

        while(collection.elementAt(index) != -1 && collection.elementAt(index) < searchValue) {
            index *=2;
        }

        return binarySearch(collection, searchValue, index /2, index);
    }

    private int binarySearch(ArrayWithNoSize collection, int searchValue, int start, int end) {
        start -=1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (collection.elementAt(mid) == searchValue) {
                return mid;
            }

            if (collection.elementAt(mid) == -1 || collection.elementAt(mid) > searchValue) {
                end = mid - 1;
            } else  {
                start = mid + 1;
            }

        }

        return -1;
    }
}