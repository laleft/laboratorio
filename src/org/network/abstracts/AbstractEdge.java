package org.network.abstracts;

import org.network.interfaces.Edge;

public abstract class AbstractEdge  implements Edge {
    private String source;
    private String target;
    private double weight;

    public AbstractEdge(String source, String target, double weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    @Override
    public String getSource() {
        return source;
    }

    @Override
    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String getTarget() {
        return target;
    }

    @Override
    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }
}
