package com.scarycoders.learn.logical.thread.deadLock;

public class DeadLockCreation {

    private String string1 = "Hi i am ruksad";
    private String string2 = "Hi i am siddiqui";

    Runnable runnable1 = new Runnable() {
        @Override
        public void run() {
            while (true) {
                synchronized (string1) {
                    synchronized (string2) {
                        System.out.println(string1 + string2);
                    }
                }
            }
        }
    };

    Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
            while (true) {
                    synchronized (string2){
                        synchronized (string1){
                            System.out.println(string2+string1);
                        }
                    }
            }
        }
    };

    public static void main(String[] args) {
        DeadLockCreation deadLockCreation=new DeadLockCreation();
        Thread thread1 = new Thread(deadLockCreation.runnable1);
        thread1.setName("ruksad");
        Thread thread2 = new Thread(deadLockCreation.runnable2);
        thread2.setName("siddiqui");
        thread1.start();
        thread2.start();
    }
}
