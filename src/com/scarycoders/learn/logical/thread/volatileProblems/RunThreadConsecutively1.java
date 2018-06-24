package com.scarycoders.learn.logical.thread.volatileProblems;

public class RunThreadConsecutively1 {

    private static ResourceLock resourceLock=new ResourceLock();

    public static void main(String[] args) {


        Runnable printA = new Runnable() {
            //private volatile Integer resourceLock = 1;
            @Override
            public void run() {

                synchronized (resourceLock) {
                    for (int i = 0; i < 20; i++) {
                        try {
                            while (resourceLock.flag != 1)
                                resourceLock.wait();
                            System.out.print("A");
                            resourceLock.flag = 2;
                            resourceLock.notifyAll();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        };

        Runnable printB = new Runnable() {
           // private volatile Integer resourceLock = 1;
            @Override
            public void run() {

                synchronized (resourceLock) {


                    for (int i = 0; i < 20; i++) {
                        try {

                            while (resourceLock.flag != 2)
                                resourceLock.wait();
                            System.out.print("B");

                            resourceLock.flag = 3;
                            resourceLock.notifyAll();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        };

        Runnable printc = new Runnable() {

           // private volatile Integer resourceLock = 1;
            @Override
            public void run() {
                synchronized (resourceLock) {
                    try {

                        for (int i=0;i<20;i++){
                            while(resourceLock.flag!=3)
                                resourceLock.wait();
                            System.out.print("C");
                            resourceLock.flag=1;
                            resourceLock.notifyAll();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        new Thread(printA).start();
        new Thread(printB).start();
        new Thread(printc).start();
    }


}
