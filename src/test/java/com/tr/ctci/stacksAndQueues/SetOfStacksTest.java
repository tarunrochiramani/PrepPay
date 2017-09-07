package com.tr.ctci.stacksAndQueues;

import java.util.Stack;

import com.tr.exceptions.InvalidInputException;
import com.tr.exceptions.StackUnderFlowException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class SetOfStacksTest {
    private static int individualStackSize = 3;
    private int numberOfStacks;
    SetOfStacks<Integer> setOfStacks = new SetOfStacks<Integer>(individualStackSize);

    @Before
    public void setUp() {
        for (int count=1; count<=12; count++) {
            setOfStacks.push(count);
        }

        numberOfStacks = setOfStacks.getStacks().size();
        assertEquals(4,numberOfStacks);
        for (Stack<Integer> aStack : setOfStacks.getStacks()) {
            assertEquals(individualStackSize, aStack.size());
        }
    }

    @Test
    public void canPop() throws StackUnderFlowException {
        for (int count=12; count>0; count--) {
            assertEquals(count, setOfStacks.pop().intValue());
            if (count % individualStackSize == 0) {
                assertEquals(numberOfStacks, setOfStacks.getStacks().size());
                numberOfStacks--;
            }
        }
    }

    @Test
    public void canPopAtIndex() throws InvalidInputException, StackUnderFlowException {
        int popAtIndex = 2;
        int expectedElement = 6;

        Integer poppedElement = setOfStacks.popAtIndex(popAtIndex);

        assertEquals(expectedElement, poppedElement.intValue());
        for (int count=12; count>0; count--) {
            if (count == expectedElement) {
                continue;
            }
            assertEquals(count, setOfStacks.pop().intValue());
        }
    }
}
