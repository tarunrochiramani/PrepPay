package com.tr.geeks4geeks;

import com.tr.ds.LinkedListNode;
import com.tr.exceptions.InvalidInputException;

public class LinkedListProblems {

    public LinkedListNode<Integer> mergeAtAlternatePos(LinkedListNode<Integer> listA, LinkedListNode<Integer> listB) throws InvalidInputException {
        if (listA == null) {
            return listB;
        }

        if (listB == null) {
            throw new InvalidInputException();
        }

        LinkedListNode<Integer> currentA = listA;
        LinkedListNode<Integer> currentB = listB;
        LinkedListNode<Integer> nextNodeA = null;
        LinkedListNode<Integer> nextNodeB = null;

        while(currentA != null) {
            nextNodeA = currentA.getNext();
            nextNodeB = currentB.getNext();

            currentA.setNext(currentB);
            currentB.setNext(nextNodeA);

            currentA = nextNodeA;
            currentB = nextNodeB;
            if (currentB == null) {
                break;
            }
        }

        return currentB;
    }
}
