package com.tr.ctci.arraysAndStrings;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(JUnit4.class)
public class CompressStringsTest {
    CompressStrings compressStrings = new CompressStrings();

    @Test
    public void canCompress() {
        String input = "aabbbcccddde";

        String compressedString = compressStrings.compress(input);
        assertNotNull(compressedString);
        assertEquals("a2b3c3d3e1" , compressedString);
    }

    @Test
    public void cannotCompress() {
        String input = "abcdef";

        String compressedString = compressStrings.compress(input);
        assertNotNull(compressedString);
        assertEquals(input , compressedString);
    }

    @Test
    public void cannotCompressNull() {

        String compressedString = compressStrings.compress(null);
        assertNull(compressedString);
    }
}
