package com.tr.ctci.arraysAndStrings;

public class CompressStrings {
    public String compress(String input) {
        if (input == null) {
            return input;
        }

        StringBuilder resultBuilder = new StringBuilder();
        int fast =1;
        int slow =0;
        while (fast<input.length()) {
            if (input.charAt(fast) != input.charAt(slow)) {
                resultBuilder.append(input.charAt(slow));
                resultBuilder.append(fast-slow);
                slow = fast;
            }
            fast ++;
        }
        resultBuilder.append(input.charAt(slow));
        resultBuilder.append(fast-slow);


        return (resultBuilder.length()<input.length() ? resultBuilder.toString():input);
    }
}
