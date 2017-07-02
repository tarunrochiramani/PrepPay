package com.tr.ctci.linklist;

import com.tr.ds.LinkedListNode;

public class Partition {

    public <T extends Comparable> LinkedListNode<T> partition(LinkedListNode<T> head, T partitionData) {
        LinkedListNode<T> current = head;
        LinkedListNode<T> before = null, beforeEnd = null;
        LinkedListNode<T> after = null, afterEnd = null;
        LinkedListNode<T> pivotElement = null;

        while (current!=null) {
            LinkedListNode<T> nextNode = current.getNext();
            current.setNext(null);
            if (current.getData().compareTo(partitionData) == 0) {
                if (pivotElement == null) {
                    pivotElement = current;
                } else {
                    pivotElement.setNext(current);
                }
            } else if (current.getData().compareTo(partitionData) < 0) {
                if (before == null) {
                    before = current;
                } else {
                    beforeEnd.setNext(current);
                }
                beforeEnd = current;
            } else {
                if (after == null) {
                    after = current;
                } else {
                    afterEnd.setNext(current);
                }
                afterEnd = current;
            }
            current = nextNode;
        }


        if (before == null && after == null) {
            return pivotElement;
        }

        LinkedListNode<T> last;
        if (before == null || after == null) {
            if (before == null) {
                head = after;
                last = afterEnd;
            } else {
                head = before;
                last = beforeEnd;
            }

        } else {
            head = before;
            beforeEnd.setNext(after);
            last = afterEnd;
        }

        last.setNext(pivotElement);
        return head;
    }
}
