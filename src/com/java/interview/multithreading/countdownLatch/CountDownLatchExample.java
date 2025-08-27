package com.java.interview.multithreading.countdownLatch;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class DependentService implements Callable<String> {
    private final String serviceName;
    private final CountDownLatch latch;

    public DependentService(String serviceName, CountDownLatch latch) {
        this.serviceName = serviceName;
        this.latch = latch;
    }

    @Override
    public String call() throws Exception {
        // Simulate service initialization
        try {
            Thread.sleep(2000); // Simulating time taken to initialize the service
            System.out.println(serviceName + " is initialized.");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
        } finally {
            latch.countDown(); // Decrement the count of the latch
        }

        return serviceName + " is ready.";
    }
}

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // CountDownLatch definition
        /*
         * CountDownLatch is a synchronization aid that allows one or more threads to
         * wait until a set of operations being performed in other threads completes.
         */
        int numberOfServices = 3;
        CountDownLatch latch = new CountDownLatch(numberOfServices);

        // Create and start service threads
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfServices);
        executorService.submit(new DependentService("Database Service", latch));
        executorService.submit(new DependentService("Cache Service", latch));
        executorService.submit(new DependentService("Messaging Service", latch));

        latch.await(); // Wait until all services are initialized
        System.out.println("All services are initialized. Application is starting...");
        executorService.shutdown();
    }
}
