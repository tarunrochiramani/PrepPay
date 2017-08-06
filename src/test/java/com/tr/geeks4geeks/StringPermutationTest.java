package com.tr.geeks4geeks;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class StringPermutationTest {
    StringPermutation stringPermutation = new StringPermutation();

    @Test
    public void canGetPermutations() {
        String input = "abc";
        List<String> permutations = stringPermutation.permutations(input);

        assertNotNull(permutations);
        assertFalse(permutations.isEmpty());
        assertEquals(fact(input.length()), permutations.size());
        assertTrue(permutations.contains("abc"));
        assertTrue(permutations.contains("acb"));
        assertTrue(permutations.contains("bac"));
        assertTrue(permutations.contains("bca"));
        assertTrue(permutations.contains("cab"));
        assertTrue(permutations.contains("cba"));
    }

    @Test
    public void canGetPermutationsForLongerString() {
        String input = "abcd";
        List<String> permutations = stringPermutation.permutations(input);

        assertNotNull(permutations);
        assertFalse(permutations.isEmpty());
        assertEquals(fact(input.length()), permutations.size());
    }

    @Test
    public void canGetRecursivePermutations() {
        String input = "abc";
        List<String> permutations = stringPermutation.recursivePerms("", input);

        assertNotNull(permutations);
        assertFalse(permutations.isEmpty());
        assertEquals(fact(input.length()), permutations.size());
        assertTrue(permutations.contains("abc"));
        assertTrue(permutations.contains("acb"));
        assertTrue(permutations.contains("bac"));
        assertTrue(permutations.contains("bca"));
        assertTrue(permutations.contains("cab"));
        assertTrue(permutations.contains("cba"));
    }

    @Test
    public void canGetRecursivePermutationsForLongerString() {
        String input = "abcd";
        List<String> permutations = stringPermutation.recursivePerms("",input);

        assertNotNull(permutations);
        assertFalse(permutations.isEmpty());
        assertEquals(fact(input.length()), permutations.size());
    }

    private int fact(int num) {
        if (num == 0) {
            return 1;
        }

        if (num == 1) {
            return 1;
        }

        return num * fact(num-1);
    }
}
