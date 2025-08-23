package com.java.interview.multithreading.threads;

public class Main {
    public static void main(String args[]) {
        ThreadUsingThreadClass thread1 = new ThreadUsingThreadClass("Thread1");
        ThreadUsingRunnableInterface threadUsingRunnableInterface = new ThreadUsingRunnableInterface();
        Thread thread2 = new Thread(threadUsingRunnableInterface,"Thread2");
        thread1.start();
        thread2.start();
    }
}
