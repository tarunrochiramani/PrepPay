package com.tr.ctci.moderate;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class FizzBuzzTest {
    FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    public void canGenerateFizzBuzz() {
        List<String> result = fizzBuzz.generateFizzBuzz(3, 5, 20);

        assertNotNull(result);
        assertNotNull(result.isEmpty());
        assertEquals(20, result.size());
    }

}
