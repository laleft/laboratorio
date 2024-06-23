package org.network;

import net.datastructures.AdjacencyMapGraph;
import net.datastructures.ChainHashMap;
import net.datastructures.Edge;
import net.datastructures.Entry;
import net.datastructures.Graph;
import net.datastructures.Map;
import net.datastructures.Vertex;

import org.network.interfaces.Device;
import org.network.models.Connection;
import org.network.services.AppInitializer;
import org.network.storage.Connections;

/**
 * Clase principal de la aplicación.
 * @version 1.0
 * @since 2024-06-14
 * @author sdebernardez
 */
public class App {
    public static void main(String[] args) throws Exception {
        
        /**
         * Inicializa la aplicación.
         * Carga las ubicaciones y los dispositivos.
         * Carga las conexiones.
         */
        AppInitializer.init();
        
        Graph<Device, Connection> network = new AdjacencyMapGraph<>(false);
        
        Map<String, Connection> connections = Connections.getConnections();

        Map<Device, Vertex<Device>> vertexMap = new ChainHashMap<>();

        for(Entry<String, Connection> connection : connections.entrySet()) {
            Vertex<Device> source = network.insertVertex(connection.getValue().getSource());
            Vertex<Device> target = network.insertVertex(connection.getValue().getTarget());
            network.insertEdge(source, target, connection.getValue());
            vertexMap.put(connection.getValue().getSource(), source);
            vertexMap.put(connection.getValue().getTarget(), target);
        }

        System.out.println("Dispositivos: " + network.numVertices());
        System.out.println("Conexiones: " + network.numEdges());
        
        System.out.println("Listado:");
        for(Edge<Connection> edge : network.edges()) {
            System.out.println(edge.getElement().getSource().getId() + " -> " + edge.getElement().getTarget().getId());
        }
    }
}
