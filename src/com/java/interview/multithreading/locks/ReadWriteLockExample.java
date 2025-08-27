package com.java.interview.multithreading.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {

    private int count = 0;

    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();


    public void increment() {
        //lock for writing (updating in value)
        writeLock.lock();
        try {
            System.out.println("Counter incremented");
            count++;
        }finally {
            writeLock.unlock();
        }
    }

    public void decrement() {
        writeLock.lock();
        try {
            count--;
        }finally {
            writeLock.unlock();
        }
    }
    public int getCount() {
        //lock for reading value
        readLock.lock();
        try {
            System.out.println("Counter is " + count);
            return count;
        }finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args){
        ReadWriteLockExample counter = new ReadWriteLockExample();
        Runnable readTask = () -> {
            for(int i = 0;i<10;i++) {
                System.out.println(Thread.currentThread().getName() + " read:" + counter.getCount() + " " + (i + 1) + " time");
            }
        };
        Runnable writeTask = () -> {
            for(int i = 0;i<10;i++) {
                System.out.println(Thread.currentThread().getName() + " write:" + counter.getCount() + " " + (i + 1) + " time");
                counter.increment();
            }
        };
        Thread writeThread = new Thread(readTask,"writeThread");
        Thread readThread1 = new Thread(writeTask,"readThread1");
        Thread readThread2 = new Thread(writeTask,"readThread2");
        writeThread.start();
        readThread1.start();
        readThread2.start();

        try {
            writeThread.join();
            readThread1.join();
            readThread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


        System.out.println("Final count: " + counter.getCount());
    }

}
