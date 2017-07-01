package com.tr.javaplay.thread;

public class MyRunnable implements Runnable {

    public void run() {
        System.out.println("MyRunnable - " + Thread.currentThread().getName());
    }
}
