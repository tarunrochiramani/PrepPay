package com.tr.javaplay.file;

import java.io.Serializable;

public class Cat extends Animal implements Serializable {
    private int num;

    public Cat() {
        System.out.println("Inside the Cat constructor");
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
