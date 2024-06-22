package org.network.services;

import org.network.interfaces.Device;
import org.network.models.Computer;
import org.network.models.Connection;
import org.network.models.Location;
import org.network.models.Router;
import org.network.storage.Locations;

import net.datastructures.ChainHashMap;
import net.datastructures.Edge;
import net.datastructures.Entry;
import net.datastructures.Map;

/**
 * Clase que inicializa la aplicación.
 * @version 1.0
 * @since 2024-06-14
 * @autor sdebernardez
* @see AppData
 */
public class AppInitializer {
    
    private static AppData appData = new AppData();
    
    private AppInitializer() {
        throw new UnsupportedOperationException("Esta clase no puede ser instanciada.");
    }
    
    /**
     * Guarda las ubicaciones en el mapa de ubicaciones.
     */
    public static void storeLocations() {
        Map<String, Map<String, String>> locationsData = appData.loadData("locations");
        for(Entry<String, Map<String, String>> location : locationsData.entrySet()) {
            Locations.addLocation(new Location(location.getValue().get("id"), location.getValue().get("building"), location.getValue().get("floor"), location.getValue().get("room")));
        }
    }

    /**
     * Devuelve los dispositivos de un tipo específico.
     * @param type el tipo de dispositivo
     * @return ChainHashMap<String, Device>
     */
    public static ChainHashMap<String, Device> getDevices(String type) {
        Map<String, Map<String, String>> data = appData.loadData(type);
        ChainHashMap<String, Device> devices = new ChainHashMap<>();
        for(Entry<String, Map<String, String>> device : data.entrySet()) {
            if(type.equals(AppConstants.COMPUTERS)) {
                devices.put(
                    device.getValue().get("id"), 
                    new Computer(
                        device.getValue().get("id"), 
                        device.getValue().get("ip"), 
                        device.getValue().get("macaddress"), 
                        Boolean.parseBoolean(device.getValue().get("status")), 
                        Locations.getLocation(device.getValue().get("location"))));
            } else if (type.equals(AppConstants.ROUTERS)) {
                devices.put(
                    device.getValue().get("id"), 
                    new Router(
                        device.getValue().get("id"), 
                        device.getValue().get("ip"), 
                        device.getValue().get("macaddress"), 
                        device.getValue().get("model"), 
                        device.getValue().get("firmware"), 
                        true, 
                        Integer.parseInt(device.getValue().get("throughput")),
                        Locations.getLocation(device.getValue().get("location"))));
            }
        }
        return devices;
    }

    // public static ChainHashMap<String, Connection> getConnections() {
    //     Map<String, Map<String, String>> data = appData.loadData(AppConstants.CONNECTIONS);
    //     ChainHashMap<String, Connection> connections = new ChainHashMap<>();
    //     for(Entry<String, Map<String, String>> connection : data.entrySet()) {            
    //         connections.put(
    //             connection.getValue().get("id"), 
    //             new Connection(
    //                 connection.getValue().get("id"), 
    //                 connection.getValue().get("source"), 
    //                 connection.getValue().get("target"), 
    //                 connection.getValue().get("type"), 
    //                 Integer.parseInt(connection.getValue().get("bandwidth")), 
    //                 Integer.parseInt(connection.getValue().get("latency")), 
    //                 Double.parseDouble(connection.getValue().get("error_rate"))));
    //     }
    //     return connections;
    // }
}
