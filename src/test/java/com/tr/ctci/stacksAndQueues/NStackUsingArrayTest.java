package com.tr.ctci.stacksAndQueues;

import com.tr.exceptions.InvalidInputException;
import com.tr.exceptions.StackOverFlowException;
import com.tr.exceptions.StackUnderFlowException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NStackUsingArrayTest {

    private NStackUsingArray nStackUsingArray = new NStackUsingArray(9, 3);

    @Test (expected = StackUnderFlowException.class)
    public void cannotPeekWhenStackEmpty() throws InvalidInputException, StackUnderFlowException {
        nStackUsingArray.peek(1);
    }

    @Test (expected = StackUnderFlowException.class)
    public void cannotPopWhenStackEmpty() throws InvalidInputException, StackUnderFlowException {
        nStackUsingArray.peek(1);
    }

    @Test
    public void canPushElement() throws InvalidInputException, StackOverFlowException, StackUnderFlowException {
        for (int i=0; i<9; i++) {
            nStackUsingArray.push(i, i/3 +1);
        }

        assertEquals(2, nStackUsingArray.peek(1));
        assertEquals(5, nStackUsingArray.peek(2));
        assertEquals(8, nStackUsingArray.peek(3));
    }

    @Test(expected = StackOverFlowException.class)
    public void cannotPushElement() throws InvalidInputException, StackOverFlowException, StackUnderFlowException {
        for (int i=0; i<3; i++) {
            nStackUsingArray.push(i, i/3 +1);
        }

        nStackUsingArray.push(10, 1);
    }
}
