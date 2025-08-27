package com.java.interview.multithreading.executorframework;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExample {

    public static void main(String[] args) {

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        // You can schedule tasks to run after a delay or at fixed intervals using
        // scheduler
        scheduler.schedule(
                () -> System.out.println("Task executed after delay"), 5, java.util.concurrent.TimeUnit.SECONDS);
     

        // Schedule a task to run at fixed intervals
        scheduler.scheduleAtFixedRate(
            () -> System.out.println("Task execute after every 5 seconds!"), 5, 5,
                TimeUnit.SECONDS);
        
        // Shutdown the scheduler after some time to stop the program
        scheduler.schedule(() -> {
            scheduler.shutdown();
            System.out.println("Initiationg  shutdown.....");
        }, 20, TimeUnit.SECONDS);

        // Note: In a real application, you would typically not shut down the scheduler
        // immediately after scheduling tasks.

        
        scheduler.scheduleWithFixedDelay(
            () -> System.out.println("Task executed with fixed delay of 3 seconds"), 0, 60,
                TimeUnit.SECONDS);

        // Shutdown the scheduler after some time to stop the program
        scheduler.schedule(() -> {
            scheduler.shutdown();
            System.out.println("Initiationg  shutdown.....");
        }, 20, TimeUnit.SECONDS);

    }
}
