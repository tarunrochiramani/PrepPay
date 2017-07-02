package com.tr.ds;

public class LinkedListNode<T> {
    private LinkedListNode next;
    private T data;


    public LinkedListNode getNext() {
        return next;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
