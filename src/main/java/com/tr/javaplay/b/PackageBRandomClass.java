package com.tr.javaplay.b;

public class PackageBRandomClass {
    public void foo() {
        PackageBClass packageBClass = new PackageBClass();

//        The following line creates a compile error
//        packageBClass.protectedMember;
    }
}
