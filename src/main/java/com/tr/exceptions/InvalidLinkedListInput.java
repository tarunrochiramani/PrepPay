package com.tr.exceptions;

public class InvalidLinkedListInput extends Exception {
    private String msg;

    public InvalidLinkedListInput(String msg) {
        this.msg = msg;
    }
}
