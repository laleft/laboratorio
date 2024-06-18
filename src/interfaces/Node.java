package interfaces;

public interface Node {

    /**
     * Devuelve el identificador del nodo.
     * @return el identificador del nodo
     */
    public String getId();

    /**
     * Establece el identificador del nodo.
     * @param id el identificador del nodo
     */
    public void setId(String id);

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
     * Devuelve el modelo del nodo.
     * @return el modelo del nodo
     */
    public String getModel();

    /**
     * Establece el modelo del nodo.
     * @param model el modelo del nodo
     */
    public void setModel(String model);

}
