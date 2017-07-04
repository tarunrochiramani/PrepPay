package com.tr.ctci.stacksAndQueues;

import com.tr.exceptions.InvalidInputException;
import com.tr.exceptions.StackOverFlowException;
import com.tr.exceptions.StackUnderFlowException;

public class NStackUsingArray {
    private int[] storage;
    private int[] tos;
    private int sizeOfEachStack;

    public NStackUsingArray(int totalStorageSize, int numberOfStacks) {
        storage = new int[totalStorageSize];
        tos = new int[numberOfStacks];
        sizeOfEachStack = totalStorageSize/numberOfStacks;
    }

    public void push(int element, int stackNum) throws InvalidInputException, StackOverFlowException {
        if (stackNum > tos.length) {
            throw new InvalidInputException();
        }
        stackNum--;
        if (tos[stackNum] == sizeOfEachStack) {
            throw new StackOverFlowException();
        }

        int index = (stackNum * sizeOfEachStack) + tos[stackNum];
        storage[index] = element;
        tos[stackNum]++;
    }

    public int peek(int stackNum) throws InvalidInputException, StackUnderFlowException {
        if (stackNum > tos.length) {
            throw new InvalidInputException();
        }
        stackNum--;
        if (tos[stackNum] == 0) {
            throw new StackUnderFlowException();
        }

        int index = (stackNum * sizeOfEachStack) + (tos[stackNum] -1);

        return storage[index];
    }

    public int pop(int stackNum) throws InvalidInputException, StackUnderFlowException {
        if (stackNum > tos.length) {
            throw new InvalidInputException();
        }
        stackNum--;
        if (tos[stackNum] == 0) {
            throw new StackUnderFlowException();
        }

        int index = (stackNum * sizeOfEachStack) + (tos[stackNum] -1);
        tos[stackNum]--;

        return storage[index];
    }
}
