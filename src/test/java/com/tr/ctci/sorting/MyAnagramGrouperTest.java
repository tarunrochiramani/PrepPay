package com.tr.ctci.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class MyAnagramGrouperTest {

    @Test
    public void canGroupAnagrams() {
        String[] input = new String[]{"abbbd", "ab", "ba", "aa", "bdabb", "bcabb", "abbdd"};
        String[] expected = new String[]{"aa", "ab", "ba", "abbdd", "bcabb", "abbbd", "bdabb"};

        Arrays.sort(input, new MyAnagramGrouper());

        assertArrayEquals(expected, input);
    }
}
