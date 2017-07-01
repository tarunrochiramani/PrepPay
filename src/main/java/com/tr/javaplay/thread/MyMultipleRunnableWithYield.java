package com.tr.javaplay.thread;

public class MyMultipleRunnableWithYield implements Runnable {
    public void run() {
        for (int i=0; i<30; i++) {
            System.out.println("MyRunnable " + i + " - " + Thread.currentThread().getName());
            if (i % 10 == 0) {
                Thread.yield();
            }
        }
    }
}
