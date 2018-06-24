package com.scarycoders.learn.logical.thread.volatileProblems;

class ThreadA extends Thread{
    private ResourceLock resourceLock;
    ThreadA(ResourceLock resourceLock){
        this.resourceLock=resourceLock;
    }

    public void run(){

        try {
            synchronized (this.resourceLock) {
                for (int i = 1; i <=6; i++) {
                    if (this.resourceLock.flag != 1)
                        this.resourceLock.wait();

                    if(i%2!=0){
                        System.out.println(String.valueOf(i));
                        Thread.sleep(1000);
                    }
                    this.resourceLock.flag=2;
                    this.resourceLock.notify();
                }
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}