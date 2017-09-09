package com.tr.ctci.sortingAndSearching;

public class SparseStringSearch {

    public int search(String[] collection, String stringToSearch) {
        int low = 0;
        int high = collection.length -1;

        while (low <= high) {
            int mid = (low + high) /2;

            if (collection[mid].equals("")) {
                int left = mid-1;
                int right = mid+1;

                while (left >= low && right <= high) {
                    if (collection[left] != "") {
                        mid = left;
                        break;
                    }

                    if (collection[right] != "") {
                        mid = right;
                        break;
                    }
                    left--;
                    right++;
                }

                if (!(mid == left || mid == right)) {
                    return -1;
                }

            }

            if (collection[mid].equals(stringToSearch)) {
                return mid;
            }

            if (collection[mid].compareTo(stringToSearch) < 0) {
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }

        return -1;
    }
}
