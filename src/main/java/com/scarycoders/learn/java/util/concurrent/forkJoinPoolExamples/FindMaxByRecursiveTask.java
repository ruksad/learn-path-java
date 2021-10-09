package com.scarycoders.learn.java.util.concurrent.forkJoinPoolExamples;

import java.time.Instant;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * program find the largest number of an array if duplicate element largest found
 * then return first occurrence
 */
public class FindMaxByRecursiveTask extends RecursiveTask<Integer> {

  private static final int THRESHOLD = 10000;
  private int data[];
  private int startIndex;
  private int endIndex;


  public FindMaxByRecursiveTask(int[] data, int startIndex, int endIndex) {
    this.data = data;
    this.startIndex = startIndex;
    this.endIndex = endIndex;
  }

  @Override
  protected Integer compute() {
    int position = 0;
    if (endIndex - startIndex < THRESHOLD) {
      for (int i = startIndex; i < endIndex; i++) {
        /**
         * we do not need else because previous(position) element is the biggest
         */
        if (data[i] > data[position]) {
          position = i;
        }
      }
      return position;
    } else {
      int halfWay = ((endIndex - startIndex) / 2) + startIndex;
      FindMaxByRecursiveTask findMaxByRecursiveTask = new FindMaxByRecursiveTask(data, startIndex,
          halfWay);
      FindMaxByRecursiveTask findMaxByRecursiveTask1 = new FindMaxByRecursiveTask(data, halfWay,
          endIndex);
      findMaxByRecursiveTask.fork();
      Integer position2 = findMaxByRecursiveTask1.compute();
      Integer position1 = findMaxByRecursiveTask.join();
      if (data[position1] > data[position2]) {
        return position1;
      } else if (data[position2] > data[position1]) {
        return position2;
      } else {
        /**
         * to return first occurrence of duplicate biggest element
         */
        return position1 < position2 ? position1 : position2;
      }
    }

  }

  public static void main(String[] args) {
    int[] data=new int[10_000_000];
    RandomInitRecursiveAction randomInitRecursiveAction = new RandomInitRecursiveAction(data, 0,
        data.length);
    ForkJoinPool forkJoinPool = new ForkJoinPool();
    forkJoinPool.invoke(randomInitRecursiveAction);

    long start1 = Instant.now().toEpochMilli();

    FindMaxByRecursiveTask findMaxByRecursiveTask = new FindMaxByRecursiveTask(data, 0,
        data.length);
    Integer invoke = forkJoinPool.invoke(findMaxByRecursiveTask);
    long end1 = Instant.now().toEpochMilli();
    System.out.println("Max of all intgers is :"+data[invoke]+" TimeTaken: "+(end1-start1));

    long start2 = Instant.now().toEpochMilli();
    OptionalInt max = Arrays.stream(data).unordered().parallel().max();
    long end2 = Instant.now().toEpochMilli();
    System.out.println("Max of all integers is :"+max.getAsInt()+" TimeTaken: "+(end2-start2));
  }
}
