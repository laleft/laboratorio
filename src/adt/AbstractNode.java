package adt;

import interfaces.Node;
import models.Location;

public abstract class AbstractNode  implements Node {
    private String id;
    private String ipAddress;
    private String macAddress;
    private boolean status;
    private Location location;

    public AbstractNode(String id, String ipAddress, String macAddress, boolean status, Location location) {
        this.id = id;
        this.ipAddress = ipAddress;
        this.macAddress = macAddress;
        this.status = status;
        this.location = location;
    }

    @Override
    public String getId() {
        return id;
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
    public boolean getStatus() {
        return status;
    }

    @Override
    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public Location getLocation() {
        return location;
    }
    
    @Override
    public void setLocation(Location location) {
        this.location = location;
    }
}
