package com.tr.geeks4geeks;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import com.tr.ds.LinkedListNode;
import com.tr.ds.services.LinkedListService;
import com.tr.exceptions.InvalidInputException;

public class LinkedListProblems {
    LinkedListService linkedListService = new LinkedListService();

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

    public<T> LinkedListNode<T> createUnion(LinkedListNode<T> listA, LinkedListNode<T> listB) throws InvalidInputException {
        if (listA == null && listB == null) {
            throw new InvalidInputException();
        }
        if (listA == null) {
            return listB;
        }
        if (listB == null) {
            return listA;
        }

        Set<T> myStorage = new HashSet<T>();
        LinkedListNode<T> current = listA;
        while (current != null) {
            myStorage.add(current.getData());
            current = current.getNext();
        }

        current = listB;
        while (current != null) {
            myStorage.add(current.getData());
            current = current.getNext();
        }

        return linkedListService.create(myStorage.toArray());
    }

    public<T> LinkedListNode<T> createIntersection(LinkedListNode<T> listA, LinkedListNode<T> listB) throws InvalidInputException {
        if (listA == null || listB == null) {
            throw new InvalidInputException();
        }

        Set<T> myStorage = new HashSet<T>();
        LinkedListNode<T> current = listA;
        while (current != null) {
            myStorage.add(current.getData());
            current = current.getNext();
        }

        current = listB;
        while (current != null) {
            if (!myStorage.contains(current.getData())) {
                myStorage.remove(current.getData());
            }
            current = current.getNext();
        }

        return linkedListService.create(myStorage.toArray());
    }

    public <T extends Comparable> LinkedListNode<T> sortedMerge(LinkedListNode<T> listA, LinkedListNode<T> listB) throws InvalidInputException {
        if (listA == null && listB == null) {
            throw new InvalidInputException();
        }

        if (listA == null) {
            return listB;
        }

        if (listB == null) {
            return listA;
        }

        LinkedListNode<T> currentA=listA, nextA, previousA=null;
        LinkedListNode<T> currentB=listB, nextB;

        while(currentA!=null && currentB!=null) {
            nextA = currentA.getNext();
            nextB = currentB.getNext();

            if (nextA == null || nextA.getData().compareTo(currentB.getData()) > 0) {
                currentA.setNext(currentB);
                currentB.setNext(nextA);
                currentB = nextB;
            }

            previousA = currentA;
            currentA = currentA.getNext();
        }

        if (currentB != null) {
            previousA.setNext(currentB);
        }

        return listA;
    }
}
