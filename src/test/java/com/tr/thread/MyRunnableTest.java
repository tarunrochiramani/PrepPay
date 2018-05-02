package com.tr.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MyRunnableTest {

    @Test
    public void runExec() {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
        newFixedThreadPool.submit(new MyRunnable());
        newFixedThreadPool.submit(new MyRunnable());
    }
}
