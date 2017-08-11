package com.tr.geeks4geeks;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class MathsTest {
    Maths maths = new Maths();

    @Test
    public void canGCD() {
        assertEquals(2, maths.gcd(4, 6));
        assertEquals(1, maths.gcd(1, 6));
        assertEquals(1, maths.gcd(2, 6));
    }
}
