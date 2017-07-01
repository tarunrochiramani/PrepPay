package com.tr.javaplay.a;

public class PackageAClass {
    protected String protectedMember;
    String defaultMember;

    static int num = 0;

    static void staticMethod() {
        num = 1;
    }

    void defaultMethod() {

    }


    public void unLabeledBreak() {
        System.out.println("\n#### Unlabeled Break ######");
        for(int i=0 ; i <2; i++) {
            System.out.println("Staring with i = " + i);
            for (int j=0; j<2; j++) {
                System.out.println("Staring with j = " + j);
                for (int k=0; k<2; k++) {
                    System.out.println("Staring with k = " + k);
                    if (k == 1) {
                        break;
                    }
                    System.out.println("Ending with k = " + k);
                }
                System.out.println("Ending with j = " + j);
            }
            System.out.println("Ending with i = " + i);
        }
        System.out.println("Outside for loop");
    }


    public void labeledBreak() {
        System.out.println("\n#### Labeled Break ######");
        outer:
        for(int i=0 ; i <2; i++) {
            System.out.println("Staring with i = " + i);
            for (int j=0; j<2; j++) {
                System.out.println("Staring with j = " + j);
                for (int k=0; k<2; k++) {
                    System.out.println("Staring with k = " + k);
                    if (k == 1) {
                        break outer;
                    }
                    System.out.println("Ending with k = " + k);
                }
                System.out.println("Ending with j = " + j);
            }
            System.out.println("Ending with i = " + i);
        }
        System.out.println("Outside for loop");
    }

    public static void main(String[] args) {
        PackageAClass packageAClass = new PackageAClass();
        packageAClass.unLabeledBreak();
        packageAClass.labeledBreak();
    }
}
