package adt;

import interfaces.Node;

public abstract class AbstractNode  implements Node {
    private String id;
    private String ipAddress;
    private String macAddress;
    private String model;

    public AbstractNode(String id, String ipAddress, String macAddress, String model) {
        this.id = id;
        this.ipAddress = ipAddress;
        this.macAddress = macAddress;
        this.model = model;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getIpAddress() {
        return ipAddress;
    }

    @Override
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String getMacAddress() {
        return macAddress;
    }

    @Override
    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }
    
}
