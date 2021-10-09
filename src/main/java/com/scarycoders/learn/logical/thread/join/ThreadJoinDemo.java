package com.scarycoders.learn.logical.thread.join;

/**
 * Join wait release the locks
 */
public class ThreadJoinDemo extends Thread{

    static ThreadJoinDemo threadJoinDemo;
    @Override
    public void run(){
        synchronized(threadJoinDemo){
            System.out.println(Thread.currentThread().getName()+" acquired the lock on threadJoindemo");
            try {
                Thread.sleep(55);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" completed its task");
        }
    }

    public static void main(String[] args) {
        threadJoinDemo=new ThreadJoinDemo();
        threadJoinDemo.setName("Testing1");
        threadJoinDemo.start();

        synchronized(threadJoinDemo){
            System.out.println(Thread.currentThread().getName()+" acquired lock on thread testing");
            try {
                Thread.sleep(55);
                threadJoinDemo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" is resumed after threadJoinDemo");
        }
    }

}
