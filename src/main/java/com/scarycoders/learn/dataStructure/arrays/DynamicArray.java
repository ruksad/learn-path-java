package com.scarycoders.learn.dataStructure.arrays;

import com.scarycoders.learn.dataStructure.arrays.interfaces.Array;

import java.util.Iterator;

public class DynamicArray<T> implements Iterable<T>, Array<T> {
    private T[] arr;
    private int len = 0;  //actual number of elements present in array
    private int capacity = 0; //Actual array size

    public DynamicArray() {
        this(16);
    }

    public DynamicArray(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("Illegal capacity" + capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    @Override public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            @Override public boolean hasNext() {
                return index < len;
            }

            @Override public T next() {
                return arr[index++];
            }
        };
    }

    @Override public int size() {
        return len;
    }

    @Override public boolean isEmpty() {
        return len == 0;
    }

    @Override public boolean add(T element) {
        doubleMyCapacityIfNeeded();
        arr[len++] = element;
        return true;
    }

    @Override public boolean addAt(int index, T element) {
        if (index >= len) {
            add(element);//add element at the end as index is larger than length
        }  else {
            doubleMyCapacityIfNeeded(); //to handle the case(in between the array) when one element increased causes array index out of bound exception
            if(index<0){
                index=0;
            }
            T[] new_arr = (T[]) new Object[capacity];
            for (int i = 0, j = 0; i < len; i++, j++) {
                if (i == index) {
                    new_arr[j++] = element;
                }
                new_arr[j] = arr[i];
            }
            arr = new_arr;
        }
        return true;
    }

    @Override public T remove(T element) {
        T removedElement = null;
        final T[] new_arr = (T[]) new Object[capacity];
        for (int i = 0, j = 0; i < len; j++, i++) {
            if (arr[i].equals(element)) {
                removedElement = arr[i];
                i++;
            }
            new_arr[j] = arr[i];
        }
        arr = new_arr;
        return removedElement;
    }

    @Override public T removeAt(int index) {
        T removedElement = null;
        T[] new_arr = (T[]) new Object[capacity];
        for (int i = 0, j = 0; i < len; j++, i++) {
            if (index == i) {
                removedElement = arr[i];
                i++;
            }
            new_arr[j] = arr[i];
        }
        arr=new_arr;
        return removedElement;
    }

    private boolean doubleMyCapacityIfNeeded() {
        if (len + 1 == capacity) {
            capacity *= 2;
            T[] new_arr = (T[]) new Object[capacity];
            for (int i = 0; i < len; i++) {
                new_arr[i] = arr[i];
            }
            arr = new_arr;
            return true;
        }
        return false;
    }

    public int getCapacity() {
        return capacity;
    }
}
