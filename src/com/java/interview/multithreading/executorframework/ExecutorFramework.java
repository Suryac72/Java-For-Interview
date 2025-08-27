package com.java.interview.multithreading.executorframework;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorFramework {

    /*
   * Executor framework is a high-level concurrency framework provided in Java
   * that simplifies the management of threads and task execution.
   * It provides a higher level of abstraction over traditional thread management,
   * making it easier to create, manage, and control threads in a concurrent
   * application.
   * 
   * The Executors framework was introduced in Java 5 as part of the
   * java.util.concurrent package.
   * It provides a set of interfaces and classes that allow developers to create
   * and manage thread pools, schedule tasks, and handle concurrency in a more
   * efficient and organized manner.
   * 
   * Executor framework have following components
   * 1. Executor Interface: The core interface that defines a method for executing
   * tasks asynchronously. It has a single method, execute(Runnable command),
   * which takes a Runnable task and executes it.
   * 2. ExecutorService Interface: A subinterface of Executor that provides
   * additional methods for managing and controlling the execution of tasks. It
   * includes methods for submitting tasks, shutting down the executor, and
   * managing the lifecycle of threads.
   * 3. ThreadPoolExecutor Class: A concrete implementation of the ExecutorService
   * interface that manages a pool of worker threads. It allows you to configure
   * the number of threads, queue size, and other parameters for efficient task
   * execution.
   * 4. ScheduledExecutorService Interface: A subinterface of ExecutorService that
   * provides methods for scheduling tasks to run after a delay or at fixed
   * intervals. It is useful for tasks that need to be executed periodically.
   * 5. Executors Class: A utility class that provides factory methods for
   * creating different types of executor services, such as fixed thread pools,
   * cached thread pools, and single-threaded executors.
   * 6. Future Interface: Represents the result of an asynchronous computation. It
   * provides methods to check if the task is complete, retrieve the result, and
   * cancel the task if needed.
   * 7. Callable Interface: Similar to Runnable, but it can return a result and
   * throw checked exceptions. It is used for tasks that need to return a value
   * after execution.
   * 8. CompletionService Interface: A higher-level abstraction that combines the
   * functionality of Executor and Future. It allows you to submit tasks and
   * retrieve their results as they complete, making it easier to manage multiple
   * concurrent tasks.
   * 9. ForkJoinPool Class: A specialized implementation of ExecutorService
   * designed for parallelism and divide-and-conquer algorithms. It uses a
   * work-stealing algorithm to efficiently manage tasks across multiple threads.
   * 10. ThreadFactory Interface: An interface that allows you to customize the
   * creation of new threads in an executor. You can implement this interface to
   * set thread names, priorities, and other properties.
   * 11. RejectedExecutionHandler Interface: An interface that defines a method
   * for handling tasks that cannot be executed by the executor. You can implement
   * this interface to define custom behavior when the executor is saturated or
   * shut down.
   * 12. BlockingQueue Interface: A queue that supports operations that wait for
   * the queue to become non-empty when retrieving an element and wait for space
   * to become available in the queue when storing an element. It is used by
   * ThreadPoolExecutor to manage the tasks.
   * 13. CountDownLatch Class: A synchronization aid that allows one or more
   * threads to wait until a set of operations being performed in other threads
   * completes. It is often used in conjunction with executor services to
   * coordinate the completion of multiple tasks.
   * 14. CyclicBarrier Class: A synchronization aid that allows a set of threads
   * to all wait for each other to reach a common barrier point. It is useful for
   * coordinating tasks that need to wait for each other to complete before
   * proceeding.
   * 15. Phaser Class: A more flexible synchronization aid that allows threads to
   * wait for each other at multiple phases of execution. It is useful for complex
   * coordination scenarios in concurrent applications.
   * 16. ThreadLocalRandom Class: A random number generator designed for use in
   * multi-threaded environments. It provides better performance than the standard
   * Random class when used in concurrent applications.
     */

    public static void main(String[] args) {

        //Normal way of creating thread pools without Executor Framework
        System.out.println("Executor Framework in Java");
        long startTime = System.currentTimeMillis();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            threads[i] = new Thread(
                    () -> {
                        long result = factorial(finalI);
                        System.out.println("Factorial of " + finalI + " is: " + result);
                    });
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Time taken without Executor Framework: " + (System.currentTimeMillis() - startTime) + " ms");

        //Using Executor Framework
        startTime = System.currentTimeMillis();
        System.out.println("Using Executor Framework");
        ExecutorService executorService = Executors.newFixedThreadPool(9);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executorService.submit(
                    () -> {
                        long result = factorial(finalI);
                        System.out.println("Factorial of " + finalI + " is: " + result);
                    });
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {
            // Wait for all tasks to finish
        }
        System.out.println("Time taken with Executor Framework: " + (System.currentTimeMillis() - startTime) + " ms");

        //Some more methods of ExecutorService
        ExecutorService executorService1 = Executors.newFixedThreadPool(5);
        executorService1.execute(() -> System.out.println("Task executed using execute() method"));
        Future<?> future = executorService1.submit(() -> System.out.println("Task executed using submit() method"));
        try {
            System.out.println(future.get()); // Wait for the task to complete
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(future.isDone() ? "Task is completed" : "Task is not completed");

        executorService1.shutdown();

        //Using invokeAll() method to execute multiple Callable tasks
        Callable<Integer> callable = () -> {
            Thread.sleep(2000);
            System.out.println("Task 1");
            return factorial(5);
        };
        Callable<Integer> callable1 = () -> {
            Thread.sleep(2000);
            System.out.println("Task 2");
            return factorial(6);
        };
        Callable<Integer> callable2 = () -> {
            Thread.sleep(2000);
            System.out.println("Task 3");
            return factorial(7);
        };
        List<Callable<Integer>> callables = List.of(callable, callable1, callable2);
        ExecutorService executorService2 = Executors.newFixedThreadPool(3);
        try {
            List<Future<Integer>> futures = executorService2.invokeAll(callables);
            for (Future<Integer> f : futures) {
                System.out.println("Factorial result: " + f.get());
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }


        executorService2.shutdown();

        ExecutorService executorService3 = Executors.newSingleThreadExecutor();
        Future<Integer> future1 = executorService3.submit((Callable<Integer>) () -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO: handle exception
                System.out.println("Exception occurred" + e);
            }
            return factorial(11);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //Attempts to cancel execution of this task. 
        future.cancel(false); // Cancel the task if not completed within 1 second
        System.out.println(future1.isCancelled());
        System.out.println(future.isDone());

    }

    public static int factorial(int number) {
        if (number == 0) {
            return 1;
        }
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }

}
