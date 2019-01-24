package com.scarycoders.learn.logical.thread.volatileProblems;

import java.util.stream.IntStream;

public class RunThreadsConcurrentlyJava8 {
    public static Resource resource = new Resource();

    public static void main(String[] args) {
        Runnable runnable = () -> {

            synchronized (resource) {
                for (int i = 0; i < 20; i++) {
                    while (resource.flag != 1) {
                        try {
                            resource.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }

                    System.out.println("A");
                    resource.flag = 2;
                    resource.notifyAll();
                }
            }

        };

        Runnable runnable1 = () -> {
            synchronized (resource) {
                for (int i = 0; i < 20; i++) {
                    while (resource.flag != 2) {
                        try {
                            resource.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    System.out.println("B");
                    resource.flag = 3;
                    resource.notifyAll();
                }
            }
        };

        Runnable runnable2 = () -> {
            synchronized (resource) {
                for (int i = 0; i < 20; i++) {
                    while (resource.flag != 3) {
                        try {
                            resource.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    System.out.println("C");
                    resource.flag = 1;
                    resource.notifyAll();
                }
            }
        };

        new Thread(runnable).start();
        new Thread(runnable1).start();
        new Thread(runnable2).start();
    }


}

class Resource {
    public int flag = 1;
}