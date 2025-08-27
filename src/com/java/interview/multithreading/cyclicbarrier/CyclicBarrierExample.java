package com.java.interview.multithreading.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class SubSystem implements Runnable {
    private final String name;
    private final int initializationTime; // in milliseconds
    private final CyclicBarrier barrier;

    public SubSystem(String name, int initializationTime, CyclicBarrier barrier) {
        this.name = name;
        this.initializationTime = initializationTime;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " is initializing...");
            Thread.sleep(initializationTime);
            System.out.println(name + " has completed initialization.");
            barrier.await(); // Wait for other subsystems to reach this point
            System.out.println(name + " is proceeding with the main task.");
        } catch (InterruptedException | BrokenBarrierException e) {
            Thread.currentThread().interrupt();
            System.err.println(name + " was interrupted or barrier was broken.");
        }
    }
}

public class CyclicBarrierExample {

    /*
     * CountDownLatch are not reusable but CyclicBarrier are reusable
     * CyclicBarrier is used when multiple threads are working on a task and main
     * thread has to wait for all the threads to complete their task
     * CyclicBarrier is used to synchronize a fixed number of threads at a common
     * barrier point
     * CyclicBarrier is initialized with the number of threads to be synchronized
     * Once all the threads reach the barrier point, they are released to continue
     * their execution
     * CyclicBarrier can be reused after the barrier is tripped
     */

    public static void main(String[] args) {
        /*
         * Cyclicbarrier is used when multiple threads are working on a task and main
         * thread has to wait for all the threads to complete their task
         * Cyclicbarrier is used to synchronize a fixed number of threads at a common
         * barrier point
         */

        // Create a CyclicBarrier for 3 threads
        int numberOfSubSystems = 4;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(numberOfSubSystems, () -> {
            System.out.println("All subsystems are ready. Proceeding with the main task.");
        });

        // Create and start threads for each subsystem
        Thread dbThread = new Thread(new SubSystem("Database", 2000, cyclicBarrier));
        Thread cacheThread = new Thread(new SubSystem("Cache", 3000, cyclicBarrier));
        Thread messagingThread = new Thread(new SubSystem("Messaging", 4000, cyclicBarrier));
        Thread apiThread = new Thread(new SubSystem("API", 2500, cyclicBarrier));

        dbThread.start();
        cacheThread.start();
        messagingThread.start();
        apiThread.start();
    }

}
