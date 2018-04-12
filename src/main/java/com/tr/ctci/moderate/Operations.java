package com.tr.ctci.moderate;

import com.tr.exceptions.InvalidInputException;

public class Operations {

    public int multiplyUsingAdd(int base, int factor) throws InvalidInputException {
        if (factor == 0 || base == 0) {
            return 0;
        }

        boolean isFactorNegative =false;
        if (factor < 0) {
            isFactorNegative = true;
            factor *= -1;
        }

        boolean isBaseNegative = false;
        if (base < 0) {
            isBaseNegative = true;
            base *= -1;
        }

        if (isFactorNegative && !isBaseNegative) {
            throw new InvalidInputException();
        }

        int result = base;
        int counter = 2;
        while (counter <= factor) {
            result+= base;
            counter++;
        }

        if (isFactorNegative) {
            result *= -1;
        }

        if (isBaseNegative) {
            result *= -1;
        }

        return result;
    }

    public int divideUsingAddOnly(int dividend, int divisor) throws InvalidInputException {
        if (divisor <= 0 || dividend <=0) {
            throw new InvalidInputException();
        }

        int counter=0;
        while (dividend > 0) {
            dividend -= divisor;
            counter++;
        }

        return counter;
    }
}
