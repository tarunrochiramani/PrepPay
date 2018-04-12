package com.tr;

public class ProductArray {
    public int[] calculateProductArray(int[] input) throws InvalidInputException {
        if (input == null || input.length <=1) {
            throw new InvalidInputException();
        }

        int result[] = new int[input.length];
        int left[] = new int[input.length];
        int right[] = new int[input.length];
        for(int pos=0; pos<input.length; pos++) {
            storeProducts(pos, input, -1, left);
            storeProducts(input.length-1-pos, input, 1, right);
        }

        for(int pos=0; pos<input.length; pos++) {
            result[pos] = left[pos] * right[pos];
        }

        return result;
    }

    private void storeProducts(int pos, int[] input, int direction, int[] storage) {
        if ((direction == -1 && pos == 0) || (direction == 1 && pos == input.length-1)) {
            storage[pos] = 1;
        } else {
            storage[pos] = storage[pos+direction] * input[pos+direction];
        }
    }
}
