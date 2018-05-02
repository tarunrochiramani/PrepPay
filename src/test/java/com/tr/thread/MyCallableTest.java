package com.tr.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MyCallableTest {

    @Test
    public void canCall() throws ExecutionException, InterruptedException {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
        Future<String> future = newFixedThreadPool.submit(new MyCallable());
        Future<String> future1 = newFixedThreadPool.submit(new MyCallable());

        System.out.println(future.get() + "\n" + future1.get());
    }
}
