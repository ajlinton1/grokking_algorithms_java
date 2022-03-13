package com.andrewlinton.grokkingalgorithms.hashtable;

import java.util.ArrayList;

public class HashTable<T> {

    int size;
    ArrayList<T>[] table;

    public HashTable(int size) {
        this.size = size;
        this.table = new ArrayList[this.size];
        for (int i = 0; i < this.size; i++) {
            this.table[i] = new ArrayList<>();
        }
    }

    int getBucketNumber(int hashCode) {
        return Math.abs(hashCode) % size;
    }

    public void push(T entry) {
        int bucketNumber = getBucketNumber(entry.hashCode());
        table[bucketNumber].add(entry);
    }

    public T pop(String key) {
        var bucketNumber = getBucketNumber(key.hashCode());
        var bucket = table[bucketNumber];
        int i = 0;
        while (bucket.get(i) != null) {
            var currentEntry = bucket.get(i);
            if (currentEntry.hashCode() == key.hashCode()) {
                return currentEntry;
            }
        }
        throw new RuntimeException("Not found");
    }
}
