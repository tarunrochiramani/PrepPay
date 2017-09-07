package com.tr.ctci.stacksAndQueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.tr.exceptions.InvalidInputException;
import com.tr.exceptions.StackUnderFlowException;

public class SetOfStacks<E> {
    private int individualStackSize;
    private List<Stack<E>> stacks = new ArrayList<Stack<E>>();

    protected List<Stack<E>> getStacks() {
        return stacks;
    }

    public SetOfStacks(int individualStackSize) {
        this.individualStackSize = individualStackSize;
    }

    public void push(E element) {
        if (stacks.isEmpty()) {
            stacks.add(new Stack<E>());
        }

        Stack<E> lastStack = stacks.get(stacks.size() - 1);
        if (lastStack.size() == individualStackSize) {
            lastStack = new Stack<E>();
            stacks.add(lastStack);
        }
        lastStack.push(element);
    }

    public E pop() throws StackUnderFlowException {
        if (stacks.isEmpty()) {
            throw new StackUnderFlowException();
        }

        Stack<E> lastStack = stacks.get(stacks.size() - 1);
        if (lastStack.isEmpty()) {
            throw new StackUnderFlowException();
        }

        E retVal = lastStack.pop();
        if (lastStack.isEmpty()) {
            stacks.remove(lastStack);
        }

        return retVal;
    }

    public E popAtIndex(int indexOfStack) throws InvalidInputException, StackUnderFlowException {
        if (indexOfStack > stacks.size()) {
            throw new InvalidInputException();
        }

        if (indexOfStack == stacks.size() -1) {
            return pop();
        }

        Stack<E> currentStack = stacks.get(indexOfStack - 1);
        E retVal = currentStack.pop();
        int nextIndex = indexOfStack++;
        while (nextIndex < stacks.size()) {
            Stack<E> nextStack = stacks.get(nextIndex);
            rotateElements(nextStack, 1);
            currentStack.push(nextStack.pop());
            nextIndex++;
            currentStack = nextStack;
        }

        return retVal;
    }

    protected void rotateElements(Stack<E> stack, int numberOfShifts) {
        Stack<E> tempStack = new Stack<E>();
        List<E> tempList = new ArrayList<E>();

        while (true) {
            if (stack.isEmpty()) {
                break;
            }
            tempStack.push(stack.pop());
        }

        int counter=0;
        while (counter < numberOfShifts) {
            tempList.add(tempStack.pop());
            counter++;
        }

        while (true) {
            if (tempStack.isEmpty()) {
                break;
            }
            stack.push(tempStack.pop());
        }

        for (E element : tempList) {
            stack.push(element);
        }
    }
}
