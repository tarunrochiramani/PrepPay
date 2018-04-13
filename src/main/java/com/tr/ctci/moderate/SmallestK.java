package com.tr.ctci.moderate;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.tr.exceptions.InvalidInputException;

public class SmallestK {

    public Integer[] smallestK(int[] input, int k) throws InvalidInputException {
        if (k <= 0 || input == null || input.length == 0 || k > input.length) {
            throw new InvalidInputException();
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(k , new MaxHeapComparator());

        for (int num : input) {
            if (heap.size() < k) {
                heap.add(num);
            } else {
                if (num < heap.peek()) {
                    heap.poll();
                    heap.add(num);
                }
            }
        }

        Integer result[] = new Integer[k];
        int pos = k-1;
        while (!heap.isEmpty()) {
            result[pos] = heap.poll();
            pos--;
        }
        return result;
    }

    static class MaxHeapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
}
