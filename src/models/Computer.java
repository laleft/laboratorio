package models;

import adt.AbstractNode;

/**
* La clase Computer representa una computadora en la red.
*
* @author  sdebernardez
* @version 1.0
* @since   2024-06-14
*/
public class Computer extends AbstractNode {
    private boolean status; // true: activo, false: inactivo
    private String location;

    /**
     * Crea una nueva instancia de la clase Computer.
     * 
     * @param id el identificador de la computadora
     * @param ipAddress la dirección IP de la computadora
     * @param macAddress la dirección MAC de la computadora
     * @param status el estado de la computadora (true: activo, false: inactivo)
     * @param location la ubicación de la computadora
     */
    public Computer(String id, String ipAddress, String macAddress, boolean status, String location) {
        super(id, ipAddress, macAddress, "Computer");
        this.status = status;
        this.location = location;
    }

    
    
    /**
     * Devuelve el estado de la computadora.
     * @return el estado de la computadora
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Establece el estado de la computadora.
     * @param status el estado de la computadora
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Devuelve la ubicación de la computadora.
     * @return la ubicación de la computadora
     */
    public String getLocation() {
        return location;
    }

    /**
     * Establece la ubicación de la computadora.
     * @param location la ubicación de la computadora
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Devuelve una representación en cadena de la computadora.
     * @return una representación en cadena de la computadora
     */
    @Override
    public String toString() {
        return "Computer{id='" + getId() + "', ipAddress='" + getIpAddress() + "', macAddress='" + getMacAddress() + 
               "', status=" + (status ? "activo" : "inactivo") + ", location='" + location + "'}";
    }
}

