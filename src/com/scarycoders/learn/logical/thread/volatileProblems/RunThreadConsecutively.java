package com.scarycoders.learn.logical.thread.volatileProblems;
/*
two thread are running make them run consecutively one thread prints even number and other thread prints even number make them print in sync
 */
class RunThreadConsecutively {

    public static void main(String[] args) {
        ResourceLock resourceLock = new ResourceLock();
        ThreadA threadA = new ThreadA(resourceLock);
        ThreadB threadB = new ThreadB(resourceLock);
        threadA.start();
        threadB.start();
    }
}
