package com.tr.javaplay.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ClassToSortTest {
    ClassToSort a = new ClassToSort();
    ClassToSort b = new ClassToSort();
    List<ClassToSort> classToSortList;

    @Before
    public void setup() {
        a.setName("blah");
        a.setNum(0);

        b.setName("aah");
        b.setNum(1);

        classToSortList = new ArrayList<ClassToSort>();
        classToSortList.add(a);
        classToSortList.add(b);
    }

    @Test
    public void canSortWithComparable() {
        Collections.sort(classToSortList);

        assertEquals(a, classToSortList.get(0));
        assertEquals(b, classToSortList.get(1));
    }

    @Test
    public void canSortWithComparator() {
        Collections.sort(classToSortList, new ClassToSortByStringComp());

        assertEquals(b, classToSortList.get(0));
        assertEquals(a, classToSortList.get(1));
    }
}
