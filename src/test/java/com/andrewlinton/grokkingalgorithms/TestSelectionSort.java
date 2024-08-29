package com.andrewlinton.grokkingalgorithms;

import org.junit.Test;


public class TestSelectionSort {

    @Test
    public void testSelectionSort() {
        int[] a = Array.getRandomArray(100);
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
        for (int i=0; i<sorted.length-1; i++) {
            assert(sorted[i] <= sorted[i+1]);
        }
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

    int findSmallest1(int[] a, int length) {
        int smallest = Integer.MAX_VALUE;
        int pos = -1;
        for (int i=0; i<length; i++) {
            if ((a[i] < smallest)) {
                smallest = a[i];
                pos = i;
            }
        }
        return pos;
    }

    @Test
    public void testSelectionSort1() {
        int length = 100;
        int[] a = Array.getRandomArray(length);
        int[] sorted = new int[length];
        for (int i=0; i<a.length; i++) {
            int smallestPos = findSmallest1(a, a.length-i);
            int smallest = a[smallestPos];
            sorted[i] = smallest;
            a[smallestPos] = a[a.length - 1];
        }
        assert(sorted != null);
        for (int i=0; i<sorted.length-1; i++) {
            assert(sorted[i] <= sorted[i+1]);
        }
    }
}
