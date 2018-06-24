package com.scarycoders.learn.logical.thread.volatileProblems;

class ThreadB extends Thread{
    private ResourceLock resourceLock;

    ThreadB(ResourceLock resourceLock){
        this.resourceLock=resourceLock;
    }

    public void run(){


        synchronized (this.resourceLock){
            try {
                for (int i = 1; i <=6; i++) {

                    if (this.resourceLock.flag != 2)
                        this.resourceLock.wait();
                    if(i%2==0){
                        System.out.println(String.valueOf(i));
                        Thread.sleep(1000);
                    }
                    this.resourceLock.flag=1;
                    this.resourceLock.notify();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}