package com.java.interview.multithreading.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    private final Lock lock = new ReentrantLock();

    public void innerMethod() {
        lock.lock();
        try{
            System.out.println("Inner method");
        }finally {
            lock.unlock();
        }
    }
    public void outerMethod() {
        lock.lock();
        try{
            System.out.println("Outer method");
            innerMethod();
        }finally {
            lock.unlock();
        }
    }
    public static void main(String[] args){
        //ReentrantLock Implementation class maintains lock count to track number of lock unlock counts during execution
        ReentrantLockExample example = new ReentrantLockExample();
        example.outerMethod();
    }
}
