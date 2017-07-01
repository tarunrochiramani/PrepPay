package com.tr;

import java.util.List;

import com.tr.javaplay.a.PackageAClass;

public class Generics {

    public void add(List<? extends PackageAClass> packageAClasses) {
//        This shows that with wildcards, nothing can be added to the collection
//        packageAClasses.add(new PackageAClass());
//        packageAClasses.add(new PackageBClass());
    }
}
