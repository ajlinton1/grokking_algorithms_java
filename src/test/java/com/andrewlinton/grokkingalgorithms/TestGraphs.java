package com.andrewlinton.grokkingalgorithms;

import org.junit.Test;
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

    @Test
    public void testDijkstra() {
        var start = new Node("Start");
        var A = new Node("A");
        var B = new Node("B");
        var finish = new Node("Finish");
        start.getEdges().add(new Edge(A, 6));
        start.getEdges().add(new Edge(B, 2));
        A.getEdges().add(new Edge(finish, 1));
        B.getEdges().add(new Edge(A, 3));
        B.getEdges().add(new Edge(finish, 5));

        var costs = new HashMap<String, Integer>();
        costs.put("A", Integer.MAX_VALUE);
        costs.put("B", Integer.MAX_VALUE);
        costs.put("Finish", Integer.MAX_VALUE);

        Queue<Node> connections = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        connections.add(start);
        while (!connections.isEmpty()) {
            Node node = connections.remove();
            if (!visited.contains(node.getName())) {
                var edges = node.getEdges();
                for (Edge edge: edges) {
                    connections.add(edge.getNode());
                    var currentCost = costs.get(edge.getNode().getName());
                    if (edge.getWeight() < currentCost) {
                        costs.put(edge.getNode().getName(), edge.getWeight());
                    }
                }
                visited.add(node.getName());
            }
        }

        assert(true);
    }
}
