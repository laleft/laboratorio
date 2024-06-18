package models;

import net.datastructures.AdjacencyMapGraph;

import interfaces.Edge;
import interfaces.Node;

public class Network extends AdjacencyMapGraph<Node, Edge>{

    public Network(boolean directed) {
        super(directed);
    }

}
