package com.java.interview.multithreading.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private int balance = 100;
    private final Lock lock = new ReentrantLock();
    public void withDraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);
        try {
            //Acquires the lock if it is free within the given waiting time and the current thread has not been
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if(balance >= amount) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " Proceeding with payment...");
                        Thread.sleep(3000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " completed withdrawal " + balance);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                        Thread.currentThread().interrupt();
                    }finally {
                        //release the lock
                        lock.unlock();
                    }
                }
            }
            else {
                System.out.println(Thread.currentThread().getName() + " Insufficient Balance");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
public class JavaLock extends Thread{
    @Override
    public void run() {
        super.run();
    }
    /*
      Intrinsic Locks: These are build into every object in java. You don't see them, but they're there.
      When you use a synchronized keyword, you're using these automatic locks
      ========================================================================
      Explicit Locks: These are more advanced locks, You can control yourself using the Lock class from java.util.concurrent.locks.
      You explicitly say when you lock and unlock,
      giving you more control over how and when people can write in the notebook.
     */
    public static void main(String[] args) {
        BankAccount sbi = new BankAccount();
        Runnable task = () -> sbi.withDraw(50);
        Thread t1 = new Thread(task,"Thread 1");
        Thread t2 = new Thread(task,"Thread 2");
        t1.start();
        t2.start();
    }
}
