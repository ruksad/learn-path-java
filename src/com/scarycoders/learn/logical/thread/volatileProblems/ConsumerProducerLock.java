package com.scarycoders.learn.logical.thread.volatileProblems;


import java.util.ArrayList;
import java.util.List;

public class ConsumerProducerLock {

  static class  Resource{
    public List<Integer> integerList=new ArrayList<>();
    public volatile boolean consume=false;
    public volatile int producerFlag=1;
  }
  public static void main(String[] args) {
    Resource resource=new Resource();

    Runnable producer1=()->{
      while (true)
      synchronized (resource){
        if(resource.producerFlag==1 && resource.consume==false){
          resource.integerList.add(1);
          resource.consume=true;
        }else{
          try {
            resource.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
          resource.notifyAll();

      }

    };
    Runnable producer2=()->{
      while (true)
          synchronized (resource){
            if(resource.producerFlag==2 && resource.consume==false){
              resource.integerList.add(2);
              resource.consume=true;
            }else{
              try {
                resource.wait();
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            }
              resource.notifyAll();

          }
    };
    Runnable producer3=()->{
      while (true)
        synchronized (resource){
          if (resource.producerFlag==3 && resource.consume==false){
            resource.integerList.add(3);
            resource.consume=true;
          }else{
            try {
              resource.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
            resource.notifyAll();

        }
    };

    Runnable consumer=()->{
      while (true)
        synchronized (resource){
          if (resource.consume){
            Integer remove = resource.integerList.remove(0);
            System.out.println("Producer: "+remove);
            System.out.println("Consumer:"+ resource.producerFlag);

            if(resource.producerFlag==1){

              resource.producerFlag=2;
            }else if(resource.producerFlag==2){
              resource.producerFlag=3;
            }else {
              resource.producerFlag=1;
            }
            resource.consume=false;

          }else{
            try {
              resource.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
            resource.notifyAll();


          try {
            Thread.sleep(2000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }

    };

    Thread a = new Thread(producer1);
    Thread b= new Thread(producer2);
    Thread c= new Thread(producer3);
    Thread d= new Thread(consumer);
    a.start();
    b.start();
    c.start();
    d.start();
  }
}
