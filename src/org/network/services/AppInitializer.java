package org.network.services;

import java.io.FileNotFoundException;

import org.network.interfaces.Device;
import org.network.models.Computer;
import org.network.models.Connection;
import org.network.models.Location;
import org.network.models.Router;
import org.network.storage.Connections;
import org.network.storage.Devices;
import org.network.storage.Locations;

import net.datastructures.ChainHashMap;
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
    /**
     * Indica si la aplicación está lista.
     */
    private static Boolean IS_READY = false;
    
    private AppInitializer() {
        throw new UnsupportedOperationException("Esta clase no puede ser instanciada.");
    }

    /**
     * Inicializa la aplicación.
     * Carga las ubicaciones y los dispositivos.
     * @see Locations
     * @see Devices
     */
    public static void init() {
        try {
            if(!IS_READY) {
                storeLocations();
                storeDevices();
                storeConnections();
                IS_READY = true;
            }
        } catch (Exception e) {
            System.out.println("Error al inicializar la aplicación. \n" + e.getMessage());
            System.exit(-1);
        }	
    }
    
    /**
     * Guarda las ubicaciones en el mapa de ubicaciones.
     * @throws RuntimeException 
     */
    private static void storeLocations() throws RuntimeException {
        try {
            Map<String, Map<String, String>> locationsData = appData.loadData(AppConstants.LOCATIONS);
            for(Entry<String, Map<String, String>> location : locationsData.entrySet()) {
                Locations.addLocation(new Location(location.getValue().get("id"), location.getValue().get("building"), location.getValue().get("floor"), location.getValue().get("room")));
            }    
        } catch (Exception e) {
            throw new RuntimeException("Error al cargar las ubicaciones: '" + AppConstants.LOCATIONS + "''.\n" + e.getMessage());
        }
    }

    /**
     * Guarda los dispositivos en el mapa de dispositivos.
     */
    private static void storeDevices() {
        try {
            for(Entry<String, Device> device : getDevices().entrySet()) {
                Devices.addDevice(device.getValue());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("No se pudo cargar: " + e.getMessage());
        }
    }

    private static void storeConnections() {
        try {
            for(Entry<String, Connection> connection : getConnections().entrySet()) {
                Connections.addConnection(connection.getValue());
            }
        } catch (Exception e) {
            throw new RuntimeException("No se pudo cargar las conexiones: " + e.getMessage());
        }
        
    }

    /**
     * Devuelve los dispositivos.
     * @return ChainHashMap<String, Device>
     * @throws FileNotFoundException 
     */
    public static ChainHashMap<String, Device> getDevices() throws FileNotFoundException {
        ChainHashMap<String, Device> devices = new ChainHashMap<>();
        try {
            Map<String, Map<String, String>> data = appData.loadData(AppConstants.COMPUTERS);
            for(Entry<String, Map<String, String>> device : data.entrySet()) {
                
                    devices.put(
                        device.getValue().get("id"), 
                        new Computer(
                            device.getValue().get("id"), 
                            device.getValue().get("ip"), 
                            device.getValue().get("macaddress"), 
                            Boolean.parseBoolean(device.getValue().get("status")), 
                            Locations.getLocation(device.getValue().get("location"))));
            }
        } catch (Exception e) {
            throw new FileNotFoundException("Error al cargar los dispositivos: " + AppConstants.COMPUTERS + "\n" + e.getMessage());
        }
        try {

            Map<String, Map<String, String>> data = appData.loadData(AppConstants.ROUTERS);
            for(Entry<String, Map<String, String>> device : data.entrySet()) {
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
        } catch (Exception e) {
            throw new FileNotFoundException("Error al cargar los dispositivos: " + AppConstants.ROUTERS + "\n" + e.getMessage());
        }
        return devices;
    }

    /**
     * Devuelve los dispositivos de un tipo específico.
     * @param type el tipo de dispositivo
     * @return ChainHashMap<String, Device>
     * @throws FileNotFoundException 
     */
    public static ChainHashMap<String, Device> getDevicesByType(String type) throws FileNotFoundException {
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

    public static ChainHashMap<String, Connection> getConnections() throws NumberFormatException, FileNotFoundException {
        Map<String, Map<String, String>> data = appData.loadData(AppConstants.CONNECTIONS);
        ChainHashMap<String, Connection> connections = new ChainHashMap<>();
        for(Entry<String, Map<String, String>> connection : data.entrySet()) {            
            connections.put(
                connection.getValue().get("id"), 
                new Connection(
                    connection.getValue().get("id"), 
                    getDevices().get(connection.getValue().get("source")), 
                    getDevices().get(connection.getValue().get("target")),
                    connection.getValue().get("type"), 
                    Integer.parseInt(connection.getValue().get("bandwidth")), 
                    Integer.parseInt(connection.getValue().get("latency")), 
                    Double.parseDouble(connection.getValue().get("error_rate"))));
        }
        return connections;
    }
}
