package com.tr.javaplay.file;

public abstract class Animal {
    private String name;

    public Animal() {
        name = "I am an Animal";
        System.out.println("Inside Animal Constructor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
