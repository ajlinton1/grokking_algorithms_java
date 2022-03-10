package com.andrewlinton.grokkingalgorithms;

public class Array {

    public static int[] getRandomArray(int size) {
        int[] a = new int[size];
        for (int i=0; i<size; i++) {
            a[i] = (int)(Math.random() * size);
        }
        return a;
    }

}
