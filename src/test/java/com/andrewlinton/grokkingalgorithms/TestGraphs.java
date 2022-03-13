package com.andrewlinton.grokkingalgorithms;

import org.junit.jupiter.api.Test;
import com.andrewlinton.grokkingalgorithms.graphs.*;

import java.util.*;

public class TestGraphs {

    @Test
    public void testShortestPath() {
        var cab = new Node("CAB");
        var car = new Node("CAR");
        var bar = new Node("BAR");
        var cat = new Node("CAT");
        var bat = new Node("BAT");
        var mat = new Node("MAT");

        var start = cab;
        var end = mat;

        cab.addConnection(car);
        cab.addConnection(cat);
        car.addConnection(bar);
        car.addConnection(cat);
        bar.addConnection(bat);
        cat.addConnection(mat);
        cat.addConnection(bat);
        mat.addConnection(bat);

        Queue<Node> connections = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        var found = false;

        connections.add(start);

        while (!connections.isEmpty()) {
            Node node = connections.remove();
            if (!visited.contains(node.getName())) {
                if (node == end) {
                    found = true;
                } else {
                    var currentConnections = node.getConnections();
                    for (Node connection: currentConnections) {
                        connections.add(connection);
                    }
                }
                visited.add(node.getName());
            }
        }

        assert(found);

    }
}
