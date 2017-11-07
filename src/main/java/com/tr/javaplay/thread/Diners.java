package com.tr.javaplay.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Diners {
    private ChopStick left, right;

    public Diners(ChopStick left, ChopStick right) {
        this.left = left;
        this.right = right;
    }

    public void eat() {
        left.pickUp();
        right.pickUp();
    }

    public void done() {
        right.putDown();
        left.putDown();
    }
}

class ChopStick {
    private Lock lock = new ReentrantLock();
    private String name;

    public ChopStick(String name) {
        this.name = name;
    }

    public void pickUp() {
        System.out.println("Picking up - " + name + " " + Thread.currentThread().getName());
        lock.lock();
    }

    public void putDown() {
        System.out.println("Putting down - " + name + " " + Thread.currentThread().getName());
        lock.unlock();
    }
}

class RunnableDiners extends Diners implements Runnable {

    public RunnableDiners(ChopStick left, ChopStick right) {
        super(left, right);
    }

    @Override
    public void run() {
        for (int count =0; count<2; count++) {
            eat();
        }

        for (int count =0; count<2; count++) {
            done();
        }
    }
}
