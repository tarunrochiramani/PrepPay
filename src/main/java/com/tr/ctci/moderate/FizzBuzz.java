package com.tr.ctci.moderate;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public List<String> generateFizzBuzz(int divisor1, int divisor2, int maxLength) {
        List<String> result = new ArrayList<>();
        for (int i=1; i<=maxLength; i++) {
            if (i%divisor1==0 && i%divisor2==0) {
                result.add("FizzBuzz");
            } else if (i%divisor1 == 0) {
                result.add("Fizz");
            } else if (i%divisor2 == 0) {
                result.add("Buzz");
            } else {
                result.add(Integer.toString(i));
            }
        }

        return result;
    }
}
