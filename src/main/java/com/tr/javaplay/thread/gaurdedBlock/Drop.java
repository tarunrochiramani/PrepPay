package com.tr.javaplay.thread.gaurdedBlock;

public class Drop {
    private boolean empty = true;
    private String message;

    public synchronized void take() {
         while (empty) {
             try {
                 wait();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
         empty = true;
         System.out.println("Taken message -" + message);
         message = null;
         notifyAll();
    }

    public synchronized void put(String message) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        empty = false;
        this.message = message;
        System.out.println("Put message - " + message);
        notifyAll();
    }
}

