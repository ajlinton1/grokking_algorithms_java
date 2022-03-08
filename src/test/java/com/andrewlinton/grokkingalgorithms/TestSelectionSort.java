package com.andrewlinton.grokkingalgorithms;

import org.junit.jupiter.api.Test;

public class TestSelectionSort {

    @Test
    public void testSelectionSort() {
        int[] a = getRandomArray(100);
        int[] sorted = new int[100];
        int smallestPos = -1;
        int smallest = -1;
        for (int i=0; i<a.length; i++) {
            smallestPos = findSmallest(a, smallest);
            smallest = a[smallestPos];
            sorted[i] = smallest;
            a[smallestPos] = -1;
        }
        assert(sorted != null);
    }

    int[] getRandomArray(int size) {
        int[] a = new int[size];
        for (int i=0; i<size; i++) {
            a[i] = (int)(Math.random() * size);
        }
        return a;
    }

    int findSmallest(int[] a, int bottom) {
        int smallest = Integer.MAX_VALUE;
        int pos = -1;
        for (int i=0; i<a.length; i++) {
            if ((a[i] < smallest) && (a[i] >= bottom)) {
                smallest = a[i];
                pos = i;
            }
        }
        return pos;
    }
}
