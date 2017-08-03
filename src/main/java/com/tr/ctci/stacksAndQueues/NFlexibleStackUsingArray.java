package com.tr.ctci.stacksAndQueues;

import java.util.Arrays;

import com.tr.exceptions.StackOverFlowException;
import com.tr.exceptions.StackUnderFlowException;

public class NFlexibleStackUsingArray {
    private int[] storage;
    private int freeSpaceIndexPointer = 0;
    private StackInfo[] stackInfos;

    public NFlexibleStackUsingArray(int totalSize, int numberOfstacks) {
        storage = new int[totalSize];
        Arrays.fill(storage, -1);
        createStackInfo(totalSize, numberOfstacks);
    }

    public void push(int element, int stackNum) throws StackOverFlowException {
        if (freeSpaceIndexPointer >= storage.length) {
            throw new StackOverFlowException();
        }
        stackNum--;
        storage[freeSpaceIndexPointer] = element;
        int currentStackTOS = stackInfos[stackNum].getTos();
        int[] currentStackstorageIndexes = stackInfos[stackNum].getStorageIndexes();
        currentStackstorageIndexes[currentStackTOS] = freeSpaceIndexPointer;
        stackInfos[stackNum].setTos(currentStackTOS + 1);
        setNextFreeSpaceIndex();
    }

    public int peek(int stackNum) throws StackUnderFlowException {
        stackNum--;
        int tos = stackInfos[stackNum].getTos();
        int[] storageIndexes = stackInfos[stackNum].getStorageIndexes();
        if (tos == 0) {
            throw  new StackUnderFlowException();
        }
        int elementPosition = storageIndexes[tos -1];

        return storage[elementPosition];
    }

    public int pop(int stackNum) throws StackUnderFlowException {
        stackNum--;
        int tos = stackInfos[stackNum].getTos();
        int[] storageIndexes = stackInfos[stackNum].getStorageIndexes();
        if (tos == 0) {
            throw  new StackUnderFlowException();
        }
        int elementPosition = storageIndexes[tos -1];
        int result = storage[elementPosition];

        storage[elementPosition] = -1;
        freeSpaceIndexPointer = elementPosition;
        stackInfos[stackNum].setTos(tos - 1);
        return result;
    }

    private void setNextFreeSpaceIndex() {
        freeSpaceIndexPointer++;
        while (freeSpaceIndexPointer < storage.length) {
            if (storage[freeSpaceIndexPointer] == -1) {
                break;
            }
            freeSpaceIndexPointer++;
        }
    }

    private void createStackInfo(int totalSize, int numberOfStacks) {
        stackInfos = new StackInfo[numberOfStacks];
        for (int n=0; n<numberOfStacks; n++) {
            StackInfo stackInfo = new StackInfo(totalSize);
            stackInfos[n] = stackInfo;
        }
    }
}

class StackInfo {
    private int tos;
    private int[] storageIndexes;

    StackInfo(int totalSize) {
        storageIndexes = new int[totalSize];
    }

    public int getTos() {
        return tos;
    }

    public void setTos(int tos) {
        this.tos = tos;
    }

    public int[] getStorageIndexes() {
        return storageIndexes;
    }
}
