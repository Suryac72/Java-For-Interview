package com.java.interview.multithreading.deadlocks;

/*
 Deadlocks typically occur when four conditions are met simultaneously:

 1. Mutual Exclusion:
    - Only one thread can access a resource at a time.

 2. Hold and Wait:
    - A thread holding at least one resource is waiting to acquire
      additional resources held by other threads.

 3. No Preemption:
    - Resources cannot be forcibly taken from threads holding them.

 4. Circular Wait:
    - A set of threads is waiting for each other in a circular chain.
*/

class Pen {
    public synchronized void writeWithPenAndPaper(Paper paper) {
        System.out.println(Thread.currentThread().getName() + " is using pen " + this + " and try to write");
        paper.finishWriting();
    }
    public synchronized void finishWriting() {
        System.out.println(Thread.currentThread().getName() + " is using pen " + " finished using pen " + this);
    }
}
class Paper{
    public synchronized void writeWithPaperAndPen(Pen pen) {
        System.out.println(Thread.currentThread().getName() + " is using Paper " + this + " and try to write");
        pen.finishWriting();
    }
    public synchronized void finishWriting() {
        System.out.println(Thread.currentThread().getName() + " is using pen " + " finished using pen " + this);
    }
}


class Task1 implements Runnable {
    private Pen pen;
    private Paper paper;

    public Task1(Pen pen,Paper paper) {
        this.pen = pen;
        this.paper = paper;
    }
    @Override
    public void run() {
        pen.writeWithPenAndPaper(paper);
    }
}

class Task2 implements Runnable {
    private Pen pen;
    private Paper paper;

    public Task2(Pen pen,Paper paper) {
        this.pen = pen;
        this.paper = paper;
    }
    @Override
    public void run() {
        //this block is use to ensure no deadlock. It will lock on paper when It has lock on pen
        synchronized (pen) {
            paper.writeWithPaperAndPen(pen);
        }

    }
}
public class DeadLockExample {
    public static void main(String[] args) {
        Pen pen = new Pen();
        Paper paper = new Paper();
        Thread thread1 = new Thread(new Task1(pen,paper),"Thread-1");
        Thread thread2 = new Thread(new Task2(pen,paper),"Thread-2");
        thread1.start();
        thread2.start();
    }
}
