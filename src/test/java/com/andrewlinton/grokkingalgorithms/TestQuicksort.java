package com.andrewlinton.grokkingalgorithms;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestQuicksort {

    @Test
    public void testQuickSort() {
        /*int size = 100;
        int[] a = Array.getRandomArray(size);
        Integer[] b = new Integer[size];
        for (int i=0; i<size; i++) {
            b[i] = a[i];
        }*/

        int size = 4;
        Integer[] b = new Integer[] {10, 5, 2, 3};
        Integer[] sorted = quicksort(b);

        assert(sorted != null);
        assert(sorted.length == size);
        for (int i=0; i<sorted.length-1; i++) {
            assert(sorted[i] <= sorted[i+1]);
        }
    }

    Integer[] quicksort(Integer[] a) {
        if (a.length < 2){
            return a;
        } else {
            int pivot = a.length/2;
            int pivotValue = a[pivot];
            ArrayList<Integer> less = new ArrayList<Integer>();
            ArrayList<Integer> greater = new ArrayList<Integer>();
            for (int c:a) {
                if (c <= pivotValue) {
                    less.add(c);
                } else {
                    greater.add(c);
                }
            }
            Integer[] lessArray = new Integer[less.size()];
            for (int i=0; i<less.size(); i++) {
                lessArray[i] = less.get(i);
            }
            Integer[] greaterArray = new Integer[greater.size()];
            for (int i=0; i<greater.size(); i++) {
                greaterArray[i] = greater.get(i);
            }

            Integer[] lessArray1 = quicksort(lessArray);
            Integer[] greaterArray1 = quicksort(greaterArray);
            Integer[] ret = new Integer[lessArray1.length + greaterArray1.length];
            for (int i=0; i<lessArray1.length; i++) {
                ret[i] = lessArray1[i];
            }
//            ret[lessArray1.length] = pivot;
            for (int i=0; i<greaterArray1.length; i++) {
                ret[i + lessArray1.length] = greaterArray1[i];
            }
            return ret;
        }
    }
}
