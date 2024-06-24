package org.network;

import net.datastructures.AdjacencyMapGraph;
import net.datastructures.ChainHashMap;
import net.datastructures.Edge;
import net.datastructures.Entry;
import net.datastructures.Graph;
import net.datastructures.GraphAlgorithms;
import net.datastructures.LinkedPositionalList;
import net.datastructures.Map;
import net.datastructures.PositionalList;
import net.datastructures.ProbeHashMap;
import net.datastructures.Vertex;

import java.util.HashSet;
import java.util.Set;

import org.network.interfaces.Device;
import org.network.models.Connection;
import org.network.services.AppInitializer;
import org.network.storage.Connections;
import org.network.storage.Devices;

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
        
        Graph<Device, Integer> network = new AdjacencyMapGraph<>(false);
        
        Map<String, Connection> connections = Connections.getConnections();

        Map<String, Vertex<Device>> vertexMap = new ChainHashMap<>();

        for(Entry<String, Connection> connection : connections.entrySet()) {
            Vertex<Device> source = network.insertVertex(connection.getValue().getSource());
            Vertex<Device> target = network.insertVertex(connection.getValue().getTarget());
            network.insertEdge(source, target, connection.getValue().getLatency());
            vertexMap.put(connection.getValue().getSource().getId(), source);
            vertexMap.put(connection.getValue().getTarget().getId(), target);
        }

        System.out.println("Dispositivos: " + network.numVertices());
        System.out.println("Conexiones: " + network.numEdges());

        Map<Vertex<Device>, Integer> distances = GraphAlgorithms.shortestPathLengths(network, vertexMap.get("PC1"));
        for(Entry<Vertex<Device>, Integer> distance : distances.entrySet()) {
            System.out.println("Distancia de PC1 a " + distance.getKey().getElement().getId() + ": " + distance.getValue());
        }
        
        Map<Vertex<Device>, Edge<Integer>> result = new ProbeHashMap<>();
        PositionalList<Edge<Integer>> path = new LinkedPositionalList<>();		
		path = GraphAlgorithms.constructPath(network, vertexMap.get("PC1"), vertexMap.get("PC7"), result);
		System.out.println("Un camino para alcanzar dos vertices");
        System.out.println("Camino: " + result.size());
		for (Edge<Integer> arcos : path)
			System.out.println("Arco: " + arcos.getElement());


            Graph<String, Integer> g = new AdjacencyMapGraph<>(true);

		Vertex<String> v1 = g.insertVertex("1");
		Vertex<String> v2 = g.insertVertex("2");
		Vertex<String> v3 = g.insertVertex("3");
		Vertex<String> v4 = g.insertVertex("4");
		Vertex<String> v5 = g.insertVertex("5");
		Vertex<String> v6 = g.insertVertex("6");
		Vertex<String> v7 = g.insertVertex("7");

		Edge<Integer> a1 = g.insertEdge(v1, v7, 100);
		Edge<Integer> a2 = g.insertEdge(v2, v3, 110);
		Edge<Integer> a3 = g.insertEdge(v3, v4, 120);
		Edge<Integer> a4 = g.insertEdge(v3, v6, 130);
		Edge<Integer> a5 = g.insertEdge(v5, v1, 140);
		Edge<Integer> a6 = g.insertEdge(v5, v2, 150);
		Edge<Integer> a7 = g.insertEdge(v5, v6, 160);
		Edge<Integer> a8 = g.insertEdge(v6, v4, 170);
		Edge<Integer> a9 = g.insertEdge(v7, v5, 180);
		Edge<Integer> a10 = g.insertEdge(v7, v6, 190);
		
		
		Map<Vertex<String>,Edge<Integer>> result2 = new ProbeHashMap<>();		 
		Set<Vertex<String>> set = new HashSet<>();
		
		GraphAlgorithms.DFS(g, v1, set, result2);
						
		System.out.println("Todos los vértices alcanzados desde v1");
		for (Vertex<String> ver : result2.keySet())
			System.out.println(ver.getElement()+"  "+result2.get(ver).getElement());		
		
		PositionalList<Edge<Integer>> camino = new LinkedPositionalList<>();		
		camino = GraphAlgorithms.constructPath(g, v1, v6, result2);
	
		System.out.println("Un camino para alcanzar dos vertices");
		for (Edge<Integer> arcos : camino)
			System.out.println(arcos.getElement());
    }
}
