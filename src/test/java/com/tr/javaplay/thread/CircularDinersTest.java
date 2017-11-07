package com.tr.javaplay.thread;

import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CircularDinersTest {
    private ChopStick[] chopSticks = new ChopStick[5];
    private Diners[] diners = new Diners[4];
    private RunnableDiners[] runnableDiners = new RunnableDiners[4];

    @Before
    public void setUp() {
        for (int count = 0; count<5; count++) {
            chopSticks[count] = new ChopStick("count - " + count );
        }

        for (int count =0; count<4; count++) {
            ChopStick left = chopSticks[count];
            ChopStick right = null;
            if (count == 3) {
                right = chopSticks[0];
            } else {
                right = chopSticks[count+1];
            }
            diners[count] = new Diners(left, right);
            runnableDiners[count] = new RunnableDiners(left, right);
        }
    }

    @Test
    public void canDine() {
        for (Diners dine : diners) {
            dine.eat();
        }

        for (Diners dine : diners) {
            dine.done();
        }
    }

    @Test
    public void canDineExecutors() {
        for (RunnableDiners diner : runnableDiners) {
            new Thread(diner).start();
        }
    }

}
