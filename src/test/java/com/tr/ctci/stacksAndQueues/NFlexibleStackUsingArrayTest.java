package com.tr.ctci.stacksAndQueues;

import com.tr.exceptions.InvalidInputException;
import com.tr.exceptions.StackOverFlowException;
import com.tr.exceptions.StackUnderFlowException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class NFlexibleStackUsingArrayTest {
    private NFlexibleStackUsingArray nFlexibleStackUsingArray = new NFlexibleStackUsingArray(9, 3);

    @Test (expected = StackUnderFlowException.class)
    public void cannotPeekWhenStackEmpty() throws InvalidInputException, StackUnderFlowException {
        nFlexibleStackUsingArray.peek(1);
    }

    @Test (expected = StackUnderFlowException.class)
    public void cannotPopWhenStackEmpty() throws InvalidInputException, StackUnderFlowException {
        nFlexibleStackUsingArray.peek(1);
    }

    @Test
    public void canPushElement() throws InvalidInputException, StackOverFlowException, StackUnderFlowException {
        for (int i=0; i<9; i++) {
            nFlexibleStackUsingArray.push(i, i/3 +1);
        }

        assertEquals(2, nFlexibleStackUsingArray.peek(1));
        assertEquals(5, nFlexibleStackUsingArray.peek(2));
        assertEquals(8, nFlexibleStackUsingArray.peek(3));
    }

    @Test(expected = StackOverFlowException.class)
    public void cannotPushElement() throws InvalidInputException, StackOverFlowException, StackUnderFlowException {
        for (int i=0; i<=9; i++) {
            nFlexibleStackUsingArray.push(i, i/3 +1);
        }
    }

    @Test
    public void canPushElementPeekNPopFromOneStack() throws InvalidInputException, StackOverFlowException, StackUnderFlowException {
        for (int i=0; i<9; i++) {
            nFlexibleStackUsingArray.push(i, 1);
        }

        assertEquals(8, nFlexibleStackUsingArray.peek(1));
        assertEquals(8, nFlexibleStackUsingArray.pop(1));
        assertEquals(7, nFlexibleStackUsingArray.pop(1));
        assertEquals(6, nFlexibleStackUsingArray.pop(1));
        assertEquals(5, nFlexibleStackUsingArray.pop(1));
        assertEquals(4, nFlexibleStackUsingArray.pop(1));
        assertEquals(3, nFlexibleStackUsingArray.pop(1));
        assertEquals(2, nFlexibleStackUsingArray.pop(1));
        assertEquals(1, nFlexibleStackUsingArray.pop(1));
        assertEquals(0, nFlexibleStackUsingArray.pop(1));
    }

    @Test
    public void canPushElementPeekNPopFromMultipleStack() throws InvalidInputException, StackOverFlowException, StackUnderFlowException {
        for (int i=0; i<9; i++) {
            nFlexibleStackUsingArray.push(i, i/3 +1);
        }


        nFlexibleStackUsingArray.pop(2);
        nFlexibleStackUsingArray.push(9, 3);
        assertEquals(9, nFlexibleStackUsingArray.pop(3));
        assertEquals(8, nFlexibleStackUsingArray.pop(3));
        assertEquals(7, nFlexibleStackUsingArray.pop(3));
        assertEquals(6, nFlexibleStackUsingArray.pop(3));
        assertEquals(4, nFlexibleStackUsingArray.pop(2));
        assertEquals(3, nFlexibleStackUsingArray.pop(2));
        assertEquals(2, nFlexibleStackUsingArray.pop(1));
        assertEquals(1, nFlexibleStackUsingArray.pop(1));
        assertEquals(0, nFlexibleStackUsingArray.pop(1));

    }
}
