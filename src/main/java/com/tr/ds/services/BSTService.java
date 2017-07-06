package com.tr.ds.services;

import com.tr.ds.BSTNode;
import com.tr.exceptions.InvalidInputException;

public class BSTService {
    public BSTNode createTree(int[] values) throws InvalidInputException {
        BSTNode head = null;

        for(int value : values) {
            if (head == null) {
                head = new BSTNode();
                head.setValue(value);
            } else {
                append(head, value);
            }
        }

        return head;
    }

    public void append(BSTNode head, int value) throws InvalidInputException {
        if (head == null) {
            throw new InvalidInputException();
        }
        BSTNode current = head;
        BSTNode previous = null;
        while (current != null) {
            previous = current;
            if (value <= current.getValue()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }

        BSTNode newNode = new BSTNode();
        newNode.setValue(value);

        if (value <= previous.getValue()) {
            previous.setLeft(newNode);
        } else {
            previous.setRight(newNode);
        }
    }

    public void printInorder(BSTNode head) {
        if (head == null) {
            return;
        }
        printInorder(head.getLeft());
        System.out.println(head.getValue());
        printInorder(head.getRight());
    }
}
