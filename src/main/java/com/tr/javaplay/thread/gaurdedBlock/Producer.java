package com.tr.javaplay.thread.gaurdedBlock;

public class Producer implements Runnable {
    private Drop drop;

    public Producer(Drop drop) {
        this.drop = drop;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < 10) {
            drop.put("Message-" + count);
            count++;
        }
    }
}
