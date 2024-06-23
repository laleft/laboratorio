package org.network.abstracts;

import org.network.interfaces.Device;
import org.network.models.Location;

/**
 * Clase abstracta que representa un dispositivo.
 * @version 1.0
 * @since 2024-06-14
 * @author sdebernardez
 * @see Device
 */
public abstract class AbstractDevice  implements Device {
    private String id;
    private String ipAddress;
    private String macAddress;
    private boolean status;
    private Location location;

    /**
     * Crea una nueva instancia de la clase AbstractDevice.
     * @param id el identificador del dispositivo
     * @param ipAddress la dirección IP del dispositivo
     * @param macAddress la dirección MAC del dispositivo
     * @param status el estado del dispositivo (true: activo, false: inactivo)
     * @param location la ubicación del dispositivo
     */
    public AbstractDevice(String id, String ipAddress, String macAddress, boolean status, Location location) {
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((macAddress == null) ? 0 : macAddress.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AbstractDevice other = (AbstractDevice) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (macAddress == null) {
            if (other.macAddress != null)
                return false;
        } else if (!macAddress.equals(other.macAddress))
            return false;
        return true;
    }


}
