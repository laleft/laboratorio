package org.network.models;

import org.network.interfaces.Device;

/**
 * Clase que representa una conexión.
 * @version 1.0
 * @since 2024-06-14
 * @author sdebernardez
 * @see Device
 */
public class Connection {
    
    private String id;
    private Device source;
    private Device target;
    private String type;
    private int bandwidth;
    private int latency;
    private Double errorRate;

    /**
     * Crea una nueva instancia de la clase Connection.
     * @param id el identificador de la conexión
     * @param source el dispositivo origen
     * @param target el dispositivo destino
     * @param type el tipo de conexión
     * @param bandwidth el ancho de banda de la conexión
     * @param latency la latencia de la conexión
     * @param errorRate la tasa de error de la conexión
     */
    public Connection(String id, Device source, Device target, String type, int bandwidth, int latency, Double errorRate) {
        this.id = id;
        this.source = source;
        this.target = target;
        this.type = type;
        this.bandwidth = bandwidth;
        this.latency = latency;
        this.errorRate = errorRate;
    }

    /**
     * Devuelve el identificador de la conexión.
     * @return String
     */
    public String getId() {
        return id;
    }

    /**
     * Devuelve el dispositivo origen.
     * @return Device
     */
    public Device getSource() {
        return source;
    }

    /**
     * Devuelve el dispositivo destino.
     * @return Device
     */
    public Device getTarget() {
        return target;
    }

    /**
     * Devuelve el tipo de conexión.
     * @return String
     */
    public String getType() {
        return type;
    }

    /**
     * Devuelve el ancho de banda de la conexión.
     * @return int
     */
    public int getBandwidth() {
        return bandwidth;
    }

    /**
     * Devuelve la latencia de la conexión.
     * @return int
     */
    public int getLatency() {
        return latency;
    }

    /**
     * Devuelve la tasa de error de la conexión.
     * @return Double
     */
    public Double getErrorRate() {
        return errorRate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        Connection other = (Connection) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Connection [id=" + id + ", source=" + source + ", target=" + target + ", type=" + type + ", bandwidth="
                + bandwidth + ", latency=" + latency + ", errorRate=" + errorRate + "]";
    }

}


