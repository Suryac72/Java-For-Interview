package com.java.interview.multithreading.synchronization;

class Counter {
    private int count = 0;
    public  void  increment() {
        /* synchronized keyword is used to achieve thread synchronization,
         * which is a mechanism to control access to shared resources by multiple threads in a multithreaded environment.
         * Its primary purpose is to prevent thread interference and data inconsistency issues,such as race conditions.
         * It also allows Mutual Exclusion
         */

        //below block is also know as critical section
        synchronized (this) {
            count++;
        }
    }
    public synchronized void decrement() {
        count--;
    }
    public int getCount() {
        return count;
    }
}
public class Synchronization extends Thread{
    private final Counter counter;

    public Synchronization(Counter counter) {
        this.counter = counter;
    }
    @Override
    public void run() {
        for(int i = 1;i<=1000;i++) {
            counter.increment();
        }
    }

    public static void main(String[] args) {
         Counter counter = new Counter();
         Synchronization t1 = new Synchronization(counter);
         Synchronization t2 = new Synchronization(counter);
         t1.start();
         t2.start();
         try{
             t1.join();
             t2.join();
         }catch (InterruptedException e) {
             System.out.println(e.getMessage());
         }finally {
             System.out.println(counter.getCount());
         }

    }
}
