package com.tr.javaplay.thread;

public class MyRunnableWithSyncMethod implements Runnable {
    private Sync sync;

    public MyRunnableWithSyncMethod(Sync sync) {
        this.sync = sync;
    }

    @Override
    public void run() {
        System.out.println("calling the synchronized method - " + Thread.currentThread().getName());
        sync.foo(Thread.currentThread().getName());
    }
}

class Sync {
    public synchronized void foo(String name) {
        System.out.println(name);
    }
}
