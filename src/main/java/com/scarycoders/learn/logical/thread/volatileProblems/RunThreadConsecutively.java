package com.scarycoders.learn.logical.thread.volatileProblems;

import java.util.Date;

/*
two thread are running make them run consecutively one thread prints even number and other thread prints even number make them print in sync
 */
class RunThreadConsecutively {

    static class Resource {

        volatile int flag = 1;
    }

    public static void main(String[] args) {
        /*ResourceLock resourceLock = new ResourceLock();
        ThreadA threadA = new ThreadA(resourceLock);
        ThreadB threadB = new ThreadB(resourceLock);
        threadA.start();
        threadB.start();*/
        Resource resource = new Resource();

        Runnable r1 = () -> {

            synchronized (resource) {
                for (int i = 0; i < 20; i++) {
                    /*if (resource.flag == 1) {
                        System.out.println("A");
                        resource.flag = 2;
                    } else {
                        try {
                            resource.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    resource.notifyAll();*/
                    while (resource.flag != 1) {
                        try {
                            resource.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("A*******");
                    resource.notifyAll();
                    resource.flag = 2;
                }

            }

        };

        Runnable r2 = () -> {

            synchronized (resource) {
                for (int i = 0; i < 20; i++) {
                    /*if (resource.flag == 2) {
                        System.out.println("B");
                        resource.flag = 3;
                    } else {
                        try {
                            resource.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    resource.notifyAll();*/
                    while (resource.flag != 2) {
                        try {
                            resource.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("B++++++++++");
                    resource.flag = 3;
                    resource.notifyAll();
                }
            }

        };

        Runnable r3 = () -> {

            synchronized (resource) {
                for (int i = 0; i < 20; i++) {
                    /*if (resource.flag == 3) {
                        resource.flag = 1;

                    } else {
                        try {
                            resource.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    resource.notifyAll();*/
                    while (resource.flag != 3) {
                        try {
                            resource.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("C-----------");
                    resource.flag = 1;
                    resource.notifyAll();
                }
            }

        };
        long time = new Date().getTime();
        Thread thread = new Thread(r1);
        Thread thread1 = new Thread(r2);
        Thread thread2 = new Thread(r3);
        thread.start();
        thread1.start();
        thread2.start();
        try {
            thread.join();
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long time1 = new Date().getTime();
        long time3 = time1 - time;
        System.out.println("time=" + time3);
    }
}
