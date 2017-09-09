package com.tr.ctci.sorting;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class SearchInSortedArrayNoSizeTest {
    SearchInSortedArrayNoSize searchInSortedArrayNoSize = new SearchInSortedArrayNoSize();
    ArrayWithNoSize collection = new ArrayWithNoSize();


    @Test
    public void canSearch() {
        collection.add(1,2,3,4,5,6,7,8,9);
        int foundIndex = searchInSortedArrayNoSize.search(collection, 5);

        assertEquals(4, foundIndex);
    }

    @Test
    public void canSearchWithOneElementOnly() {
        collection.add(1);
        int foundIndex = searchInSortedArrayNoSize.search(collection, 1);

        assertEquals(0, foundIndex);
    }

    @Test
    public void cannotSearchWithOneElementOnly() {
        collection.add(1);
        int foundIndex = searchInSortedArrayNoSize.search(collection, 3);

        assertEquals(-1, foundIndex);
    }
}
