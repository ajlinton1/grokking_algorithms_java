package com.andrewlinton.grokkingalgorithms;

import org.junit.Test;

public class TestBinarySearch {

    @Test
    public void testBinarySearch() {
        int a[] = new int[100];
        for (int i=0; i<100; i++) {
            a[i] = i;
        }
        int target = 77;
        int pos = binarySearch(a, 0, a.length-1, target);
        assert(pos > -1);
    }

    int binarySearch(int[] a, int start, int end, int target) {
        int mid = (end - start)/2 + start;
        if (start == end) {
            return -1;
        }
        if (a[mid] == target) {
            return mid;
        } else if (a[mid] < target) {
            return binarySearch(a, mid+1, end, target);
        } else {
            return binarySearch(a, start, mid-1, target);
        }
    }

}
