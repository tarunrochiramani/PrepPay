package com.tr.ctci.linklist;

import com.tr.ds.LinkedListNode;
import com.tr.ds.services.LinkedListService;
import com.tr.exceptions.InvalidLinkedListInput;

public class SumList {
    private LinkedListService linkedListService = new LinkedListService();

    public LinkedListNode<Integer> sum(LinkedListNode<Integer> aHead, LinkedListNode<Integer> bHead) throws InvalidLinkedListInput {
        if (aHead == null || bHead == null) {
            throw new InvalidLinkedListInput("Invalid Lists");
        }

        LinkedListNode<Integer> currentA = aHead, currentB = bHead;
        LinkedListNode<Integer> head = null, previous = null;

        int carry = 0;
        while (currentA !=null && currentB != null) {
            Integer sum = currentA.getData() + currentB.getData() + carry;

            if (sum >= 10) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }

            LinkedListNode<Integer> newNode = new LinkedListNode<Integer>();
            newNode.setData(sum);

            if (head == null) {
                head = newNode;
            } else {
                previous.setNext(newNode);
            }
            previous = newNode;
            currentA = currentA.getNext();
            currentB = currentB.getNext();
        }


        while (currentA != null) {
            int sum = currentA.getData() + carry;

            if (sum >= 10) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }

            LinkedListNode<Integer> newNode = new LinkedListNode<Integer>();
            newNode.setData(sum);

            previous.setNext(newNode);
            previous = newNode;
            currentA = currentA.getNext();
        }

        while (currentB != null) {
            int sum = currentB.getData() + carry;

            if (sum >= 10) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }

            LinkedListNode<Integer> newNode = new LinkedListNode<Integer>();
            newNode.setData(sum);

            previous.setNext(newNode);
            previous = newNode;
            currentB = currentB.getNext();
        }

        if (carry > 0) {
            LinkedListNode<Integer> newNode = new LinkedListNode<Integer>();
            newNode.setData(carry);

            previous.setNext(newNode);
        }


        return linkedListService.reverse(head);
    }
}
