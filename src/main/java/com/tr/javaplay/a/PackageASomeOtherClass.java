package com.tr.javaplay.a;

public class PackageASomeOtherClass {
    public void foo() {
        PackageAClass packageAClass = new PackageAClass();
        packageAClass.protectedMember = "";
        packageAClass.defaultMember = "";

        packageAClass.defaultMethod();


        //Shows that an instance variable can be used to access static (just a convenience)
        packageAClass.num = 2;
        packageAClass.staticMethod();
    }

    public void goo() {
        PackageAInheritedClass packageAInheritedClass = new PackageAInheritedClass();
        packageAInheritedClass.defaultMethod();
        packageAInheritedClass.defaultMember = "";

    }
}
