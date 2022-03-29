package com.scarycoders.learn.algo.sorting;

public class QuickSort {
    
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        /**
         * indicated the position of pivot so far
         */
        int indexLowerThanPivotElement = low ;
        for (int j = low; j <= high - 1; j++) {

            if (arr[j]< pivot) {
                swap(arr, indexLowerThanPivotElement, j);
                indexLowerThanPivotElement++;
            }
        }
        /**
         * place pivot element at correct location
         */
        swap(arr, indexLowerThanPivotElement , high);
        return indexLowerThanPivotElement ;
    }

    public static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public static void main(String[] args) {
       // int[] arr = {-1,100,1,2,200,4,5,6,7,-100};//
        //int [] arr=  {10,9,8,7,5,4,2,1,-10,-1};
        int arr[]= {10, 7, 8, 9, 1,-1, 5};
        int n = arr.length;

        quickSort(arr, 0, n - 1);
        System.out.println("Sorted array: ");
        printArray(arr, n);
    }
}
