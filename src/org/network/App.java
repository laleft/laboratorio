package org.network;

import net.datastructures.AdjacencyMapGraph;
import net.datastructures.ChainHashMap;
import net.datastructures.Entry;
import net.datastructures.Graph;
import net.datastructures.Map;

import org.network.interfaces.Device;
import org.network.models.Connection;
import org.network.services.AppConstants;
import org.network.services.AppData;
import org.network.services.AppInitializer;

public class App {
    public static void main(String[] args) throws Exception {
        
        Graph<Device, Connection> network = new AdjacencyMapGraph<>(false);

        AppInitializer.storeLocations();

        Map<String, Device> computers = AppInitializer.getDevices(AppConstants.COMPUTERS);
        Map<String, Device> routers = AppInitializer.getDevices(AppConstants.ROUTERS);        

        Map<String, Map<String, String>> data = new AppData().loadData(AppConstants.CONNECTIONS);
        ChainHashMap<String, Connection> connections = new ChainHashMap<>();
        for(Entry<String, Map<String, String>> connection : data.entrySet()) {
            connections.put(
                connection.getValue().get("id"), 
                new Connection(
                    connection.getValue().get("id"), 
                    computers.get(connection.getValue().get("source")), 
                    routers.get(connection.getValue().get("target")),
                    connection.getValue().get("type"), 
                    Integer.parseInt(connection.getValue().get("bandwidth")), 
                    Integer.parseInt(connection.getValue().get("latency")), 
                    Double.parseDouble(connection.getValue().get("error_rate"))));
        }

        for(Entry<String, Connection> connection : connections.entrySet()) {
            network.insertEdge(
                network.insertVertex(connection.getValue().getSource()), 
                network.insertVertex(connection.getValue().getTarget()), 
                connection.getValue());
        }
        
        System.out.println(network);
    }
    
}
