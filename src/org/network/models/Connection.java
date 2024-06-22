package org.network.models;

import org.network.interfaces.Device;

public class Connection {
    
    private String id;
    private Device source;
    private Device target;
    private String type;
    private int bandwidth;
    private int latency;
    private Double errorRate;

    public Connection(String id, Device source, Device target, String type, int bandwidth, int latency, Double errorRate) {
        this.id = id;
        this.source = source;
        this.target = target;
        this.type = type;
        this.bandwidth = bandwidth;
        this.latency = latency;
        this.errorRate = errorRate;
    }

    public String getId() {
        return id;
    }

    public Device getSource() {
        return source;
    }

    public Device getTarget() {
        return target;
    }

    public String getType() {
        return type;
    }

    public int getBandwidth() {
        return bandwidth;
    }

    public int getLatency() {
        return latency;
    }

    public Double getErrorRate() {
        return errorRate;
    }

    

}


