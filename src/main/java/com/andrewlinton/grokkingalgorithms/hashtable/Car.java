package com.andrewlinton.grokkingalgorithms.hashtable;

public class Car {

    String name;
    int power;

    public Car(String name, int power) {
        this.name = name;
        this.power = power;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
