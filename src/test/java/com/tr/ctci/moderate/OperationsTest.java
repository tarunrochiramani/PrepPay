package com.tr.ctci.moderate;

import com.tr.exceptions.InvalidInputException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class OperationsTest {
    private Operations operations = new Operations();

    @Test
    public void canMultiply() throws InvalidInputException {
        assertEquals(10, operations.multiplyUsingAdd(2, 5));
        assertEquals(10, operations.multiplyUsingAdd(-2, -5));
    }

    @Test
    public void canDivide() throws InvalidInputException {
        assertEquals(10, operations.divideUsingAddOnly (50, 5));
    }
}
