package com.tr.ctci.moderate;

import java.util.Stack;

public class EngInt {
    private String[] numbers = new String[] {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private String[] tens = new String[] {"", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private String[] bigs = new String[] {"Hundred", "Thousand", "Million"};

    public String toEnglish(int number) {
        if (number == 0) {
            return numbers[0];
        }

        Stack<String> words = new Stack<>();
        int bigsCount = 1;

        while (true) {
            convertThreeDigitNumber(number%1000, words);

            if ((number / 1000) < 1) {
                break;
            }
            words.push(bigs[bigsCount]);
            number /= 1000;
            bigsCount++;
        }

        return convertToString(words);
    }

    private void convertThreeDigitNumber(int number, Stack<String> words) {

        int ten, one;
        int hundred = number / 100;
        number = number % 100;

        if (number > 0) {
            if (number <= numbers.length) {
                words.push(numbers[number]);
            } else {
                ten = number / 10;
                one = number % 10;

                if (one > 0) {
                    words.push(numbers[one]);
                }
                words.push(tens[ten-1]);
            }
        }

        if (hundred >= 1) {
            words.push(numbers[hundred] + " " + bigs[0]);
        }

    }

    private String convertToString(Stack<String> words) {
        if (words == null || words.isEmpty()) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!words.isEmpty()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(words.pop());
        }

        return stringBuilder.toString();
    }
}
