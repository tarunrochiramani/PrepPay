package com.tr.javaplay.thread;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MyRunnableTest {

    @Test
    public void canInvokeRun() {
        MyRunnable myRunnable = new MyRunnable();
        Thread t = new Thread(myRunnable, "innerThread");
        t.start();
        System.out.println("canInvokeMyRun - " + t.getName());
    }

    @Test
    public void canInvokeParentRun() {
        Thread t = new Thread();
        t.start();
        System.out.println("canInvokeParentRun - " + t.getName());
    }

    @Test
    public void canInvokeManyRuns() {
        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable, "first");
        Thread t2 = new Thread(myRunnable, "second");
        Thread t3 = new Thread(myRunnable, "third");

        t1.start();
        t2.start();
        t3.start();
    }
}
