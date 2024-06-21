package org.network.abstracts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.network.interfaces.Device;
import org.network.interfaces.Edge;
import org.network.interfaces.Graph;

public abstract class AbstractGraph implements Graph {
    protected Map<Device, List<Device>> adjacencyList;
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
    public void addNode(Device node) {
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
