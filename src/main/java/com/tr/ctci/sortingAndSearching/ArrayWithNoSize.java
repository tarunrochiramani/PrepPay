package com.tr.ctci.sortingAndSearching;

import java.util.ArrayList;
import java.util.List;

/**
 * Collection that does not have the ability to get the length
 */
public class ArrayWithNoSize {
    private List<Integer> elements = new ArrayList<>();

    public void add(int ...values) {
        for (int value: values) {
            elements.add(value);
        }
    }

    public int elementAt(int index) {
        if (index > elements.size() -1) {
            return -1;
        }

        return elements.get(index);
    }
}
