package com.andrewlinton.grokkingalgorithms.hashtable;

public class HashTableEntry {

    private String key;
    private String value;

    public HashTableEntry(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int hashCode() {
        return this.key.hashCode();
    }

}
