package com.java.interview.multithreading.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class CompletableFutureExample {
    /*
     * This class is intended to demonstrate the usage of CompletableFuture in Java for asynchronous programming.
     * It can include examples of creating CompletableFutures, chaining them, handling exceptions,and combining multiple CompletableFutures.
     * 
     * 
     * CompletableFuture is a powerful feature introduced in Java 8 that allows you to write non-blocking, asynchronous code in a more readable and maintainable way.
     * It provides a way to represent a future result of an asynchronous computation and offers various methods to compose, combine, and handle the results of these computations.
     * 
     */

     public static void main(String[] args) {
        System.out.println("This is a placeholder for CompletableFuture examples.");
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            // Simulate a long-running task
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Task interrupted");
            }
            return "Hello, World!";
        });

        String result = completableFuture.join(); // Waits for the computation to complete and retrieves the result
        System.out.println("Result: " + result);

        try {
            result = completableFuture.get(); // Waits for the computation to complete and retrieves the result
            System.out.println("Result using get(): " + result);
            result = completableFuture.getNow(result); // Retrieves the result if available, otherwise returns the provided value
            System.out.println("Result using getNow(): " + result);
            result = completableFuture.get(3, java.util.concurrent.TimeUnit.SECONDS); // Waits for the computation to complete with a timeout
            System.out.println("Result using get with timeout: " + result);

            result = CompletableFuture.allOf().thenApply(v -> "All tasks completed").get(); // Combines multiple CompletableFutures and waits for all of them to complete
            System.out.println("Result using allOf(): " + result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch(ExecutionException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
     }
}
