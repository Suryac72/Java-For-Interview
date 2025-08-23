package com.java.interview.multithreading.threads;

public class ThreadUsingRunnableInterface implements Runnable{

    @Override
    public void run() {
        System.out.println("This thread is created via thread class....");
        for(int i = 0;i<10000;i++) {
            System.out.println("Thread " + Thread.currentThread().getName() + " called " + i + " time ");
        }
    }
}
