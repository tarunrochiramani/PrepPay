package com.tr.javaplay.sorting;

import java.util.Comparator;

public class ClassToSortByStringComp implements Comparator<ClassToSort> {

    public int compare(ClassToSort a, ClassToSort b) {
        return a.getName().compareTo(b.getName());
    }
}
