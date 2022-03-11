package com.andrewlinton.grokkingalgorithms;

import org.junit.jupiter.api.Test;

public class TestQuicksort {

    @Test
    public void testQuickSort() {
        int size = 100;
        int[] a = Array.getRandomArray(size);
        int[] sorted = quicksort(a);

        assert(sorted != null);
        assert(sorted.length == size);
        for (int i=0; i<sorted.length-1; i++) {
            assert(sorted[i] <= sorted[i+1]);
        }
    }

    // TODO: Speed up array operations

    int[] quicksort(int[] a) {
        if (a.length < 2){
            return a;
        } else {
            int pivot = a.length/2;
            int pivotValue = a[pivot];
            int[] less = new int[a.length];
            int lessPos = 0;
            int[] greater = new int[a.length];
            int greaterPos = 0;

            for (int i=0; i<a.length; i++) {
                if (i!=pivot) {
                    if (a[i] <= pivotValue) {
                        less[lessPos++] = a[i];
                    } else {
                        greater[greaterPos++] = a[i];
                    }
                }

            }

            int[] less1 = new int[lessPos];
            for (int i=0; i<lessPos; i++) {
                less1[i] = less[i];
            }
            int[] lessArray1 = quicksort(less1);
            int[] greater1 = new int[greaterPos];
            for (int i=0; i<greaterPos; i++) {
                greater1[i] = greater[i];
            }
            int[] greaterArray1 = quicksort(greater1);
            int[] ret = new int[less1.length + greater1.length + 1];
            for (int i=0; i<lessArray1.length; i++) {
                ret[i] = lessArray1[i];
            }
            ret[lessArray1.length] = pivotValue;
            for (int i=0; i<greaterArray1.length; i++) {
                ret[i + lessArray1.length + 1] = greaterArray1[i];
            }
            return ret;
        }
    }
}
