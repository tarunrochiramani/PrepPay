package com.tr.javaplay.thread;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MyMultipleRunnableTest {
    @Test
    public void canInvokeMultipleRun() {
        MyMultipleRunnable myMultipleRunnable = new MyMultipleRunnable();
        Thread t1 = new Thread(myMultipleRunnable, "first");
        Thread t2 = new Thread(myMultipleRunnable, "second");
        Thread t3 = new Thread(myMultipleRunnable, "third");

        t1.start();
        t2.start();
        t3.start();
    }

    @Test
    public void canInvokeMultipleRunWithYield() {
        MyMultipleRunnableWithYield myMultipleRunnableWithYield = new MyMultipleRunnableWithYield();
        Thread t1 = new Thread(myMultipleRunnableWithYield, "first");
        Thread t2 = new Thread(myMultipleRunnableWithYield, "second");
        Thread t3 = new Thread(myMultipleRunnableWithYield, "third");

        t1.start();
        t2.start();
        t3.start();
    }
}
