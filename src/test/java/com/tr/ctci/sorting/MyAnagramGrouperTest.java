package com.tr.ctci.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class MyAnagramGrouperTest {

    @Test
    public void canGroupAnagrams() {
        String[] strings = new String[]{"abbbd", "ab", "ba", "aa", "bdabb", "bcabb"};

        Arrays.sort(strings, new MyAnagramGrouper());

        for (int pos = 0; pos< strings.length - 2; pos ++) {
            assertTrue(strings[pos].length() <= strings[pos+1].length());
            assertTrue(strings[pos].hashCode() <= strings[pos+1].hashCode());
        }
    }
}
