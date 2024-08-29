package com.andrewlinton.grokkingalgorithms;

import org.junit.Test;

import java.util.ArrayList;

import com.andrewlinton.grokkingalgorithms.hashtable.*;

public class TestHashTables {

    @Test
    public void testHashCode() {
        String s = "This is a test";
        int hashCode = s.hashCode();

        String s0 = "Another test";
        int hashCode0 = s0.hashCode();

        assert (hashCode != hashCode0);
    }

    @Test
    public void testHashTable() {
        int size = 10;
        ArrayList<String>[] hashTable = new ArrayList[size];
        for (int i = 0; i < size; i++) {
            hashTable[i] = new ArrayList<>();
        }
        for (int i=0; i< 5; i++) {
            String s = "This is a test" + i;
            int hashCode = s.hashCode();
            hashCode = Math.abs(hashCode);
            int bucket = hashCode % size;
            hashTable[bucket].add(s);
        }

        assert(hashTable != null);
        int hashCode0 = "This is a test2".hashCode();
        hashCode0 = Math.abs(hashCode0);
        int bucket0 = hashCode0 % size;
        var list = hashTable[bucket0];
        assert(list.size() > 0);
    }

    @Test
    public void testHashTable0() {
        int size = 10;
        var hashTable = new HashTable<Car>(size);
        for (int i=0; i< 5; i++) {
            String name = "This is a test" + i;
            var power = i * 100;
            hashTable.push(new Car(name, power));
        }

        var result = hashTable.pop("This is a test2");

        assert(result != null);
    }
}
