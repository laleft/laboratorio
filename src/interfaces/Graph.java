package interfaces;

import java.util.List;

public interface Graph {
    /**
     * Devuelve el número de nodos del grafo.
     * @return el número de nodos del grafo
     */
    public int getNumNodes();

    /**
     * Devuelve el número de aristas del grafo.
     * @return el número de aristas del grafo
     */
    public int getNumEdges();

    /**
     * Devuelve el nodo con el identificador especificado.
     * @param id el identificador del nodo
     * @return el nodo con el identificador especificado
     */
    public Node getNode(String id);

    /**
     * Devuelve la arista con el identificador del nodo origen y destino especificados.
     * @param source el identificador del nodo origen
     * @param target el identificador del nodo destino
     * @return la arista con el identificador del nodo origen y destino especificados
     */
    public Edge getEdge(String source, String target);

    /**
     * Devuelve una lista con los nodos del grafo.
     * @return una lista con los nodos del grafo
     */
    public List<Node> getNodes();

    /**
     * Devuelve una lista con las aristas del grafo.
     * @return una lista con las aristas del grafo
     */
    public List<Edge> getEdges();

    /**
     * Agrega un nodo al grafo.
     * @param node el nodo a agregar
     */
    public void addNode(Node node);

    /**
     * Agrega una arista al grafo.
     * @param edge la arista a agregar
     */
    public void addEdge(Edge edge);

    /**
     * Elimina un nodo del grafo.
     * @param id el identificador del nodo a eliminar
     */
    public void removeNode(String id);

    /**
     * Elimina una arista del grafo.
     * @param source el identificador del nodo origen
     * @param target el identificador del nodo destino
     */
    public void removeEdge(String source, String target);

    /**
     * Devuelve una lista con los nodos adyacentes al nodo con el identificador especificado.
     * @param id el identificador del nodo
     * @return una lista con los nodos adyacentes al nodo con el identificador especificado
     */
    public List<Node> getNeighbors(String id);
}
