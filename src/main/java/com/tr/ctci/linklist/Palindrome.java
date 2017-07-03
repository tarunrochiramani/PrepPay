package com.tr.ctci.linklist;

import java.util.LinkedList;
import java.util.Stack;

import com.tr.ds.LinkedListNode;
import com.tr.ds.services.LinkedListService;
import com.tr.exceptions.InvalidLinkedListInput;

public class Palindrome {
    private LinkedListService linkedListService = new LinkedListService();

    public <T> boolean isPalindrome(LinkedListNode<T> head) throws InvalidLinkedListInput {
        if (head == null) {
            throw new InvalidLinkedListInput("Invalid Lists");
        }

        LinkedListNode<T> middleNode = linkedListService.findMiddleNode(head);

        boolean foundMiddle = false;
        LinkedListNode<T> current = head;
        Stack<T> myStack = new Stack<T>();

        while (current != null) {
            if (!foundMiddle) {
                foundMiddle = populateStack(middleNode, current, myStack);
            } else {
                if (myStack.isEmpty() || current.getData() != myStack.pop()) {
                    return false;
                }
            }
            current = current.getNext();
        }

        return true;
    }

    private <T> boolean populateStack(LinkedListNode<T> middleNode, LinkedListNode<T> current, Stack<T> myStack) {
        myStack.push(current.getData());

        if (current == middleNode) {
            if (myStack.size() % 2 > 0) {
                myStack.pop();
            }
            return true;
        }

        return false;
    }
}
