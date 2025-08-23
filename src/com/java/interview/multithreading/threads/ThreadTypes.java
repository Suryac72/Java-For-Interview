package com.java.interview.multithreading.threads;

public class ThreadTypes extends Thread{
    @Override
    public void run() {
        while(true) {
            System.out.println("Thread running.......");
        }
    }

    /*
     User Threads (Non-Daemon Threads):
     -----------------------------------
     - These are the standard threads responsible for executing the main logic
       and tasks of an application.
     - The Java Virtual Machine (JVM) will wait for all user threads to complete
       their execution before terminating the program.
       -> This means that if a user thread is still running, the JVM will not shut down.
     - They are typically created explicitly by the application to perform
       specific computations or operations.


     Daemon Threads:
     ----------------
     - These are low-priority threads that provide background services to user threads.
     - Unlike user threads, the JVM does not wait for daemon threads to complete their
       execution before terminating.
       -> When all user threads have finished, any remaining daemon threads
          are automatically terminated.
     - Examples of daemon threads in the JVM include:
       -> Garbage Collector
       -> Finalizer
     - They are primarily used for tasks that should not prevent the JVM from
       shutting down, such as housekeeping or monitoring activities.
    */

    public static void main(String[] args) {
        ThreadTypes thread1 = new ThreadTypes();
        ThreadTypes thread2 = new ThreadTypes();
        thread1.setDaemon(true); //to set thread1 as daemon thread
        thread1.start();
        thread2.start(); //user thread (normal default thread)
        System.out.println("Main Done");
    }

}
