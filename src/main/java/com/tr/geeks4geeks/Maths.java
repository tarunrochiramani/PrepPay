package com.tr.geeks4geeks;

public class Maths {
    int gcd(int a, int b) {
        System.out.println("a: " + a +" b: " + b);
        if (b ==0) {
            return a;
        }
        return gcd(b, a%b);
    }
}
