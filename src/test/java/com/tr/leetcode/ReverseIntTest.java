package com.tr.leetcode;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ReverseIntTest {
    private ReverseInt reverseInt = new ReverseInt();

    @Test
    public void canReverse() {
        assertEquals(101, reverseInt.reverse(101));
        assertEquals(123, reverseInt.reverse(321));
        assertEquals(-123, reverseInt.reverse(-321));
        assertEquals(1, reverseInt.reverse(1));
    }
}
