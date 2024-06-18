package models;

import adt.AbstractNode;

/**
 * La clase Router representa un router en la red.
 * 
 * @author  sdebernardez
 * @version 1.0
 * @since   2024-06-14
 */
public class Router extends AbstractNode {
    private String model;
    private String firmware;
    private int throughput; // en Mbps

    /**
     * Crea una nueva instancia de la clase Router.
     * 
     * @param id el identificador del router
     * @param ipAddress la dirección IP del router
     * @param macAddress la dirección MAC del router
     * @param model el modelo del router
     * @param firmware la versión del firmware del router
     * @param status el estado del router (true: activo, false: inactivo)
     * @param throughput el rendimiento del router en Mbps
     * @param location la ubicación del router
     */
    public Router(String id, String ipAddress, String macAddress, String model, String firmware, boolean status, int throughput, Location location) {
        super(id, ipAddress, macAddress, status, location);
        this.model = model;
        this.firmware = firmware;
        this.throughput = throughput;
    }

    /**
     * Devuelve el modelo del router.
     * @return el modelo del router
     */
    public String getModel() {
        return model;
    }

    /**
     * Establece el modelo del router.
     * @param model el modelo del router
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Devuelve la versión del firmware del router.
     * @return la versión del firmware del router
     */
    public String getFirmware() {
        return firmware;
    }

    /**
     * Establece la versión del firmware del router.
     * @param firmware la versión del firmware del router
     */
    public void setFirmware(String firmware) {
        this.firmware = firmware;
    }

    /**
     * Devuelve el rendimiento del router.
     * @return el rendimiento del router
     */
    public int getThroughput() {
        return throughput;
    }

    /**
     * Establece el rendimiento del router.
     * @param throughput el rendimiento del router
     */
    public void setThroughput(int throughput) {
        this.throughput = throughput;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }

    /**
     * Compara dos routers para determinar si son iguales.
     * 
     * @param obj el objeto a comparar
     * @return true si los routers son iguales, false en caso contrario
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Router other = (Router) obj;
        if (getId() == null) {
            if (other.getId() != null)
                return false;
        } else if (!getId().equals(other.getId()))
            return false;
        return true;
    }

    /**
     * Devuelve una representación en cadena del router.
     * @return una representación en cadena del router
     */
    @Override
    public String toString() {
        return "Router{id='" + getId() + "', ipAddress='" + getIpAddress() + "', macAddress='" + getMacAddress() + 
               "', model='" + model + "', firmware='" + firmware + "', status=" + (getStatus() ? "activo" : "inactivo") + 
               ", throughput=" + getThroughput() + " Mbps, location='" + getLocation() + "'}";
    }
}

