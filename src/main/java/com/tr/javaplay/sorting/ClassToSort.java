package com.tr.javaplay.sorting;

public class ClassToSort implements Comparable<ClassToSort> {
    private Integer num;
    private String name;


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int compareTo(ClassToSort o) {
        return this.num.compareTo(o.getNum());
    }
}
