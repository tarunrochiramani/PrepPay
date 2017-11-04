package com.tr.javaplay.thread.gaurdedBlock;

public class Consumer implements Runnable {
    private Drop drop;

    public Consumer(Drop drop) {
        this.drop = drop;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < 10) {
            drop.take();
            count++;
        }
    }
}
