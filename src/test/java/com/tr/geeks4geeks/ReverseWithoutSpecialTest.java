package com.tr.geeks4geeks;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ReverseWithoutSpecialTest {
    ReverseWithoutSpecial reverseWithoutSpecial = new ReverseWithoutSpecial();

    @Test
    public void canReverse() throws Exception {
        assertEquals("c,b$a", reverseWithoutSpecial.reverseWithoutSpecial("a,b$c"));
        assertEquals("ed,c,bA!$", reverseWithoutSpecial.reverseWithoutSpecial("Ab,c,de!$"));
    }
}
