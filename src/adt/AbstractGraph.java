package adt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import interfaces.Edge;
import interfaces.Graph;
import interfaces.Node;

public abstract class AbstractGraph implements Graph {
    protected Map<Node, List<Node>> adjacencyList;
    private int numNodes;
    private int numEdges;

    public AbstractGraph() {
        numNodes = 0;
        numEdges = 0;
        adjacencyList = new HashMap<>();
    }

    @Override
    public int getNumNodes() {
        return numNodes;
    }

    @Override
    public int getNumEdges() {
        return numEdges;
    }

    @Override
    public void addNode(Node node) {
        adjacencyList.putIfAbsent(node, getNodes());
        numNodes++;
    }

    @Override
    public void addEdge(Edge edge) {
        numEdges++;
    }

    @Override
    public void removeNode(String id) {
        numNodes--;
    }

    @Override
    public void removeEdge(String source, String target) {
        numEdges--;
    }

}
