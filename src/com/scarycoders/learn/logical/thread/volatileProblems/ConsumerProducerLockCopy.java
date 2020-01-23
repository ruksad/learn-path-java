package com.scarycoders.learn.logical.thread.volatileProblems;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ConsumerProducerLockCopy {

    static class Resource{
        int consumerFlag=1;
        boolean consume=false;
        List<Integer> ints=new ArrayList<>();
    }

    public static void main(String[] args) {
        Resource resource=new Resource();
        Runnable producer1= ()->{
            while (true){

                synchronized (resource) {
                    if (!resource.consume && resource.consumerFlag == 1) {
                        resource.consume=true;
                        resource.ints.add(1);
                        System.out.println("produced"+1);
                    } else {
                        try {
                            resource.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    resource.notifyAll();
                }
            }

        }; //producer1


        Runnable producer2=()->{

            while (true){

                synchronized (resource){
                    if(!resource.consume && resource.consumerFlag==2){
                       resource.consume=true;
                       resource.ints.add(2);
                        System.out.println("produced"+2);
                    }else{
                        try {
                            resource.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    resource.notifyAll();
                }
            }
        };

        Runnable producer3=()->{
          while (true){
              synchronized (resource){
                  if(!resource.consume && resource.consumerFlag==3){
                      resource.consume=true;
                      resource.ints.add(3);
                      System.out.println("produced"+3);
                  }else{
                      try {
                          resource.wait();
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }

                  }
                  resource.notifyAll();
              }
          }

        };

        Runnable consumer=()->{

            while (true){
                synchronized (resource){
                    Integer integer = null;
                    if(resource.consume && resource.consumerFlag==1){
                        integer = resource.ints.remove(0);
                        resource.consumerFlag=2;
                        System.out.println("consumed= "+integer);
                    }else if(resource.consume && resource.consumerFlag==2){
                        integer = resource.ints.remove(0);
                        resource.consumerFlag=3;
                        System.out.println("consumed= "+integer);
                    }else if(resource.consume && resource.consumerFlag==3){
                        integer = resource.ints.remove(0);
                        resource.consumerFlag=1;
                        System.out.println("consumed= "+integer);
                    }


                    resource.consume=false;
                    try {
                        resource.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    resource.notifyAll();
                }
            }

        };

        Thread thread = new Thread(producer1);
        Thread thread1 = new Thread(producer2);
        Thread thread2 = new Thread(producer3);
        Thread thread3 = new Thread(consumer);
        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
    }

}
