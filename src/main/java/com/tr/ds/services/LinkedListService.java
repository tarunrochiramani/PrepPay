package com.tr.ds.services;

import java.util.LinkedList;

import com.tr.ds.LinkedListNode;
import com.tr.exceptions.InvalidLinkedListInput;

public class LinkedListService {

    public <T> LinkedListNode create(T[] data) {
        LinkedListNode<T> head = null;
        LinkedListNode<T> current = null;
        LinkedListNode<T> previous = null;

        for (T dataElement : data) {
            current = new LinkedListNode<T>();
            current.setData(dataElement);

            if (head == null) {
                head = current;
            } else {
                previous.setNext(current);
            }
            previous = current;
        }

        return head;
    }

    public <T> void append(T data, LinkedListNode<T> head) throws InvalidLinkedListInput {
        if (head == null) {
            throw new InvalidLinkedListInput("Invalid List");
        }

        LinkedListNode<T> current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }

        LinkedListNode<T> newNode = new LinkedListNode<T>();
        newNode.setData(data);

        current.setNext(newNode);
    }

    public <T> LinkedListNode<T> remove(T data, LinkedListNode<T> head) throws InvalidLinkedListInput {
        if (head == null) {
            throw new InvalidLinkedListInput("Invalid List");
        }

        LinkedListNode<T> current = head;
        LinkedListNode<T> previous = null;

        while(current != null) {
            if (current.getData().equals(data)) {
                if (current == head) {
                    head = current.getNext();
                    current.setNext(null);
                } else {
                    previous.setNext(current.getNext());
                }
            } else {
                previous = current;
            }

            current = current.getNext();
        }
        return head;
    }

    public <T> LinkedListNode<T> reverse(LinkedListNode<T> head) throws InvalidLinkedListInput {
        if (head == null) {
            throw new InvalidLinkedListInput("Invalid List");
        }

        LinkedListNode<T> current = head;
        LinkedListNode<T> previous = null;

        while (current != null) {
            LinkedListNode<T> nextNode = current.getNext();

            current.setNext(previous);
            previous = current;
            current = nextNode;
        }
        return previous;
    }

    public <T>LinkedListNode<T> findMiddleNode(LinkedListNode<T> head) throws InvalidLinkedListInput {
        if (head == null) {
            throw new InvalidLinkedListInput("Invalid List");
        }

        LinkedListNode<T> slow = head, fast = head;

        while (fast != null) {
            fast = fast.getNext();
            if (fast != null && fast.getNext() != null) {
                slow = slow.getNext();
                fast = fast.getNext();
            }
        }
        return slow;
    }
}
