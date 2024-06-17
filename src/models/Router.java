package models;

/**
 * La clase Router representa un router en la red.
 * 
 * @author  sdebernardez
 * @version 1.0
 * @since   2024-06-14
 */
public class Router {
    private String id;
    private String ipAddress;
    private String macAddress;
    private String model;
    private String firmware;
    private boolean status; // true: activo, false: inactivo
    private int throughput; // en Mbps
    private String location;

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
    public Router(String id, String ipAddress, String macAddress, String model, String firmware, boolean status, int throughput, String location) {
        this.id = id;
        this.ipAddress = ipAddress;
        this.macAddress = macAddress;
        this.model = model;
        this.firmware = firmware;
        this.status = status;
        this.throughput = throughput;
        this.location = location;
    }
    
    /**
     * Devuelve el identificador del router.
     * @return el identificador del router
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador del router.
     * @param id el identificador del router
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Devuelve la dirección IP del router.
     * @return la dirección IP del router
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * Establece la dirección IP del router.
     * @param ipAddress la dirección IP del router
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * Devuelve la dirección MAC del router.
     * @return la dirección MAC del router
     */
    public String getMacAddress() {
        return macAddress;
    }

    /**
     * Establece la dirección MAC del router.
     * @param macAddress la dirección MAC del router
     */
    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
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
     * Devuelve el estado del router.
     * @return el estado del router
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Establece el estado del router.
     * @param status el estado del router
     */
    public void setStatus(boolean status) {
        this.status = status;
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

    /**
     * Devuelve la ubicación del router.
     * @return la ubicación del router
     */
    public String getLocation() {
        return location;
    }

    /**
     * Establece la ubicación del router.
     * @param location la ubicación del router
     */
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    /**
     * Devuelve una representación en cadena del router.
     * @return una representación en cadena del router
     */
    @Override
    public String toString() {
        return "Router{id='" + id + "', ipAddress='" + ipAddress + "', macAddress='" + macAddress + 
               "', model='" + model + "', firmware='" + firmware + "', status=" + (status ? "activo" : "inactivo") + 
               ", throughput=" + throughput + " Mbps, location='" + location + "'}";
    }
}

