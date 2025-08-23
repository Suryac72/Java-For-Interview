package com.java.interview.multithreading.threads;

public class ThreadMethods extends Thread{
    public static void main(String args[]) {
        //Interrupting thread - Means the task which thread is doing, we interrupt to do that
        ThreadMethods thread1 = new ThreadMethods();
        ThreadMethods thread2 = new ThreadMethods();
        thread1.setPriority(Thread.MAX_PRIORITY); //method to set priority to the thread
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread1.start();
        thread2.start();

        //Interrupting thread - Means the task which thread is doing, we interrupt to do that
        ThreadLifeCycle t1 = new ThreadLifeCycle();
        t1.start();
        t1.interrupt();



    }

    @Override
    public void run() {
       for(int i = 0;i< 5;i++) {
           System.out.println(Thread.currentThread().getName() + " is running");
           /*
             Yield method gives hint to the scheduler that the current thread is willing to yield its current use of a processor.
             The scheduler is free to ignore this hint.
            */
           Thread.yield();
       }
    }
}
