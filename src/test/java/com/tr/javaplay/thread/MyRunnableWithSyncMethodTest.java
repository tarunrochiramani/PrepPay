package com.tr.javaplay.thread;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MyRunnableWithSyncMethodTest {

    @Test
    public void canInvokeSyncMethodWithTheSameLock() throws InterruptedException {
        Sync sync = new Sync();
        MyRunnableWithSyncMethod myRunnableWithSyncMethod = new MyRunnableWithSyncMethod(sync);
        Thread t1 = new Thread(myRunnableWithSyncMethod);
        Thread t2 = new Thread(myRunnableWithSyncMethod);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("Completing the test method - " + Thread.currentThread().getName());
    }

    @Test
    public void canInvokeSyncMethodWithDifferentLock() throws InterruptedException {
        Thread t1 = new Thread(new MyRunnableWithSyncMethod(new Sync()));
        Thread t2 = new Thread(new MyRunnableWithSyncMethod(new Sync()));

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("Completing the test method - " + Thread.currentThread().getName());
    }
}
