package com.scarycoders.learn.java.util.concurrent.forkJoinPoolExamples;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Initialize a single huge array with RecursiveAction which uses forkJoinPool
 */
public class RandomInitRecursiveAction extends RecursiveAction {

  private static final int THRESHOLD = 10000;
  private int data[];
  private int startIndex;
  private int endIndex;

  public RandomInitRecursiveAction(int[] data, int startIndex, int endIndex) {
    this.data = data;
    this.startIndex = startIndex;
    this.endIndex = endIndex;
  }

  @Override
  protected void compute() {
    if (endIndex - startIndex <= THRESHOLD) {
      for (int i = startIndex; i < endIndex; i++) {
        data[i] = ThreadLocalRandom.current().nextInt();
      }
    } else {
      int halfWay = ((endIndex - startIndex) / 2) + startIndex;
      RandomInitRecursiveAction randomInitRecursiveAction = new RandomInitRecursiveAction(data,
          startIndex, halfWay);
      randomInitRecursiveAction.fork();
      RandomInitRecursiveAction randomInitRecursiveAction1 = new RandomInitRecursiveAction(data,
          halfWay, endIndex);
      randomInitRecursiveAction1.compute();
      randomInitRecursiveAction.join();
    }
  }

  public static void main(String[] args) {
    int[] data=new int[10_000_000];
    RandomInitRecursiveAction randomInitRecursiveAction = new RandomInitRecursiveAction(data, 0,
        data.length);
    ForkJoinPool forkJoinPool = new ForkJoinPool();
    forkJoinPool.invoke(randomInitRecursiveAction);
    System.out.println(data);
  }
}
