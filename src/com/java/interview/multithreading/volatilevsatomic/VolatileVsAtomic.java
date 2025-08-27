package com.java.interview.multithreading.volatilevsatomic;

import java.util.concurrent.atomic.AtomicInteger;

class Shared {
    private volatile boolean flag = false;

    public void setFlagTrue() {
        System.out.println("Setting flag to true");
        flag = true;
    }

    public void printIfFlagTrue() {
        while (!flag) {
            // Busy-wait
        }
        System.out.println("Flag is true!");
    }
}

class Counter {
    private AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        counter.incrementAndGet();
    }

    public int getValue() {
        return counter.get();
    }
}

public class VolatileVsAtomic {
    public static void main(String[] args) {
        Shared shared = new Shared();

        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(1000); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            shared.setFlagTrue();
        });

        Thread readerThread = new Thread(() -> {
            shared.printIfFlagTrue();
        });

        readerThread.start();
        writerThread.start();

        try {
            readerThread.join();
            writerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Counter counter = new Counter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        t1.start();
        t2.start();
        System.out.println("Final Counter Value: " + counter.getValue());
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
