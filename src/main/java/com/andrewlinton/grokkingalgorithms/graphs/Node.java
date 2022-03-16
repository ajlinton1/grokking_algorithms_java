package com.andrewlinton.grokkingalgorithms.graphs;

import java.util.ArrayList;
import java.util.List;

public class Node {

    String name;
    ArrayList<Node> connections;

    ArrayList<Edge> edges;

    public Node(String name) {
        this.name = name;
        connections = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public void addConnection(Node node) {
        connections.add(node);
    }

    public List<Node> getConnections() {
        return connections;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }

}
