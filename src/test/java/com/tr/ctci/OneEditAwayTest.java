package com.tr.ctci;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class OneEditAwayTest {
    OneEditAway oneEditAway = new OneEditAway();

    @Test
    public void isOneEditAway_Insert() {
        String s1 = "abc";
        String s2 = "abcd";

        assertTrue(oneEditAway.isOneEditAway(s1, s2));
    }

    @Test
    public void isOneEditAway_Removal() {
        String s2 = "abc";
        String s1 = "abcd";

        assertTrue(oneEditAway.isOneEditAway(s1, s2));
    }

    @Test
    public void isOneEditAway_Replace() {
        String s2 = "abc";
        String s1 = "abd";

        assertTrue(oneEditAway.isOneEditAway(s1, s2));
    }

    @Test
    public void isNotOneEditAway_Removal() {
        String s2 = "abe";
        String s1 = "abcd";

        assertFalse(oneEditAway.isOneEditAway(s1, s2));
    }

    @Test
    public void isNotOneEditAway_Insert() {
        String s1 = "abe";
        String s2 = "abcd";

        assertFalse(oneEditAway.isOneEditAway(s1, s2));
    }

    @Test
    public void isNotOneEditAway_Replace() {
        String s1 = "abe";
        String s2 = "acd";

        assertFalse(oneEditAway.isOneEditAway(s1, s2));
    }

    @Test
    public void isNotOneEditAwayForWrongInput() {
        String s1 = "abe";
        String s2 = "acdgef";

        assertFalse(oneEditAway.isOneEditAway(s1, s2));
    }
}
