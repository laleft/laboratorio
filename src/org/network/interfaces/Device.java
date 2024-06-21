package org.network.interfaces;

import org.network.models.Location;

public interface Device {

    /**
     * Devuelve el identificador del nodo.
     * @return el identificador del nodo
     */
    public String getId();

    /**
     * Devuelve la dirección IP del nodo.
     * @return la dirección IP del nodo
     */
    public String getIpAddress();

    /**
     * Establece la dirección IP del nodo.
     * @param ipAddress la dirección IP del nodo
     */
    public void setIpAddress(String ipAddress);

    /**
     * Devuelve la dirección MAC del nodo.
     * @return la dirección MAC del nodo
     */
    public String getMacAddress();

    /**
     * Establece la dirección MAC del nodo.
     * @param macAddress la dirección MAC del nodo
     */
    public void setMacAddress(String macAddress);

    /**
     * Devuelve el estado del nodo.
     * @return el estado del nodo
     */
    public boolean getStatus();

    /**
     * Establece el estado del nodo.
     * @param status el estado del nodo
     */
    public void setStatus(boolean status);

    /**
     * Devuelve la ubicación del nodo.
     * @return la ubicación del nodo
     */
    public Location getLocation();

    /**
     * Establece la ubicación del nodo.
     * @param location la ubicación del nodo
     */
    public void setLocation(Location location);

}
