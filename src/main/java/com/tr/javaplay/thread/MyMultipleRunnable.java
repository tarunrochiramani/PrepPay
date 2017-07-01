package com.tr.javaplay.thread;

public class MyMultipleRunnable implements Runnable {
    public void run() {
        for (int i=0; i<30; i++) {
            System.out.println("MyRunnable " + i + " - " + Thread.currentThread().getName());
        }
    }
}
