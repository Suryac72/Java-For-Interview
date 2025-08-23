package com.java.interview.multithreading.threads;

public class ThreadLifeCycle extends Thread{
    /**
     * Thread lifecycle
     * There are 5 stages of thread lifecycle which are listed below
     * New: A thread is in this state when it is created but not yet started.
     *----------------------------------------------
     * Runnable: After the start method is called, the thread becomes runnable.
     *  It's ready to run and is waiting for CPU time.
     *----------------------------------------------
     * Running: The thread is in this state when it is executing.
     *----------------------------------------------
     * Blocked/Waiting: A thread is in this state when it is waiting for a resource
     *  or for another thread to perform an action.
     *----------------------------------------------
     * Terminated: A thread is in this state when it has finished executing.
     **/
    @Override
    public void run() {
        System.out.println("Running....");
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String args[]) {
        ThreadLifeCycle thread1 = new ThreadLifeCycle(); //NEW state
        System.out.println(thread1.getState());
        thread1.start(); //RUNNABLE state
        System.out.println(thread1.getState());

        try {
            Thread.sleep(100); //TIMED_WAITING
            System.out.println(thread1.getState());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        try {
            thread1.join(); //TERMINATED
            System.out.println(thread1.getState());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
