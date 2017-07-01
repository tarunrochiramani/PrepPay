package com.tr.javaplay.b;

import com.tr.javaplay.a.PackageAClass;

public class PackageBClass extends PackageAClass {

    public void cannotUseReferenceOutsidePackage() {
        PackageAClass packageAClass = new PackageAClass();

//        The following creates compilation error
//        packageAClass.protectedMember;
    }

    public void canOnlyInherit() {
        this.protectedMember = "";

//        The following creates compilation error
//        this.defaultMember = "";
//        this.defaultMethod();
    }
}
