package com.tr.thread;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i=0; i<50; i++) {
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + " - " + i);
            }
        }
    }
}
