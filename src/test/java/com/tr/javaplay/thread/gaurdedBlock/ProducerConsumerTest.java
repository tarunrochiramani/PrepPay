package com.tr.javaplay.thread.gaurdedBlock;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class ProducerConsumerTest {

    @Test
    public void canRunGuardedBlock() throws InterruptedException {
        Drop drop = new Drop();

        Thread producerThread = new Thread(new Producer(drop));
        Thread consumerThread = new Thread(new Consumer(drop));

        producerThread.start();
        consumerThread.start();


        producerThread.join();
        consumerThread.join();

        assertTrue(true);
    }
}
