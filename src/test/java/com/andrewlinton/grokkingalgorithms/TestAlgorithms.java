package com.andrewlinton.grokkingalgorithms;

import junit.framework.TestCase;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class TestAlgorithms {

    @Test
    public void testSetCovering() {
        Set<String> statesNeeded = Set.of("mt", "wa", "or", "id", "nv", "ut", "ca", "az");

        var stations = new HashMap<String, Set<String>>();
        stations.put("kone", Set.of("id", "nv", "ut"));
        stations.put("ktwo", Set.of("wa", "id", "mt"));
        stations.put("kthree", Set.of("or", "nv", "ca"));
        stations.put("kfour", Set.of("nv", "ut"));
        stations.put("kfive", Set.of("ca", "az"));

        Collection<String> finalStations = new HashSet<String>();

        while (statesNeeded.size()>0) {
            String bestStation = null;
            Collection<String> statesCovered = new HashSet<String>();
            for (var stationName: stations.keySet()) {
                System.out.println(stationName);
                var states = stations.get(stationName);
                for (var state: states) {
                    System.out.println(state);
                }

                var covered = intersection(statesNeeded, states);
                if (covered.size() > statesCovered.size()) {
                    bestStation = stationName;
                    statesCovered = covered;
                }
            }

            Set<String> tempSet = new HashSet<>();
            for (String state: statesNeeded) {
                if (!statesCovered.contains(state)) {
                    tempSet.add(state);
                }
            }
            statesNeeded = tempSet;
            finalStations.add(bestStation);
        }

        assert(finalStations.size()>0);
    }

    Set<String> intersection(Set<String> s0, Set<String> s1){
        Set<String> ret = new HashSet<>();
        for (String s: s0) {
            if (s1.contains(s)) {
                ret.add(s);
            }
        }
        return ret;
    }
}
