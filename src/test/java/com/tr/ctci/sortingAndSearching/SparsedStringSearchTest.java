package com.tr.ctci.sortingAndSearching;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class SparsedStringSearchTest {
    SparseStringSearch sparsedStringSearch = new SparseStringSearch();

    @Test
    public void cannotFind() {
        String[] input1 = new String[] {"", ""};
        String[] input2 = new String[] {""};

        assertEquals(-1, sparsedStringSearch.search(input1, "a"));
        assertEquals(-1, sparsedStringSearch.search(input2, "a"));
    }

    @Test
    public void canFind() {
        String[] input1 = new String[] {"", "", "a", "", "", "b", ""};
        String[] input2 = new String[] {"a", "", "", "c", "d", "e", "f"};

        assertEquals(2, sparsedStringSearch.search(input1,"a"));
        assertEquals(0, sparsedStringSearch.search(input2,"a"));
        assertEquals(5, sparsedStringSearch.search(input2,"e"));
    }

}
