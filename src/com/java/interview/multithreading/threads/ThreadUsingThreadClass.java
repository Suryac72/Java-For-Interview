package com.java.interview.multithreading.threads;

public class ThreadUsingThreadClass extends Thread{

    public ThreadUsingThreadClass(String name) {
        super(name);
    }

    @Override
    public void run() {
       System.out.println("This thread is created via thread class....");
    }
}
