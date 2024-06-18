package interfaces;

public interface Edge {
    /**
     * Devuelve el identificador del nodo origen.
     * @return el identificador del nodo origen
     */
    public String getSource();

    /**
     * Establece el identificador del nodo origen.
     * @param source el identificador del nodo origen
     */
    public void setSource(String source);

    /**
     * Devuelve el identificador del nodo destino.
     * @return el identificador del nodo destino
     */
    public String getTarget();

    /**
     * Establece el identificador del nodo destino.
     * @param target el identificador del nodo destino
     */
    public void setTarget(String target);

    /**
     * Devuelve el peso de la arista.
     * @return el peso de la arista
     */
    public double getWeight();

    /**
     * Establece el peso de la arista.
     * @param weight el peso de la arista
     */
    public void setWeight(double weight);

}
