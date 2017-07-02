package com.tr.ctci.linklist;

import java.util.HashSet;
import java.util.Set;

import com.tr.ds.LinkedListNode;
import com.tr.exceptions.InvalidLinkedListInput;

public class RemoveDuplicate {

    public <T> void removeDupsWithBuffer(LinkedListNode<T> head) throws InvalidLinkedListInput {
        if (head == null) {
            throw new InvalidLinkedListInput("Invalid List");
        }

        Set<T> buffer = new HashSet<T>();
        LinkedListNode<T> current = head;
        LinkedListNode<T> previous = null;
        while (current != null) {
            if (buffer.contains(current.getData())) {
                previous.setNext(current.getNext());
            } else {
                buffer.add(current.getData());
                previous = current;
            }
            current = current.getNext();
        }
    }

    public <T> void removeDupsWithoutBuffer(LinkedListNode<T> head) throws InvalidLinkedListInput {
        if (head == null) {
            throw new InvalidLinkedListInput("Invalid List");
        }

        LinkedListNode<T> current = head;
        while (current!=null) {
            LinkedListNode<T> previous = current;
            LinkedListNode<T> runner = current.getNext();
            while(runner != null) {
                if (current.getData().equals(runner.getData())) {
                    previous.setNext(runner.getNext());
                } else {
                    previous = runner;
                }
                runner = runner.getNext();
            }
            current = current.getNext();
        }
    }


}
