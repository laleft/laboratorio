package org.network.models;

import org.network.abstracts.AbstractDevice;

/**
* La clase Computer representa una computadora en la red.
*
* @author  sdebernardez
* @version 1.0
* @since   2024-06-14
*/
public class Computer extends AbstractDevice {

    /**
     * Crea una nueva instancia de la clase Computer.
     * 
     * @param id el identificador de la computadora
     * @param ipAddress la dirección IP de la computadora
     * @param macAddress la dirección MAC de la computadora
     * @param status el estado de la computadora (true: activo, false: inactivo)
     * @param location la ubicación de la computadora
     */
    public Computer(String id, String ipAddress, String macAddress, boolean status, Location location) {
        super(id, ipAddress, macAddress, status, location);
    }

    /**
     * Devuelve una representación en cadena de la computadora.
     * @return String
     */
    @Override
    public String toString() {
        return "Computer{id='" + getId() + "', ipAddress='" + getIpAddress() + "', macAddress='" + getMacAddress() + 
               "', status=" + (getStatus() ? "activo" : "inactivo") + ", location='" + getLocation() + "'}";
    }
}

