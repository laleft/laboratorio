package org.network.storage;

import org.network.interfaces.Device;

import net.datastructures.ChainHashMap;
import net.datastructures.Map;

/**
 * Clase que almacena los dispositivos.
 * @version 1.0
 * @since 2024-06-14
 * @author sdebernardez
 * @see Device
 * @see org.network.services.AppInitializer
 */
public class Devices {
    
    /**
     * Mapa que almacena los dispositivos.
     */
    private static Map<String, Device> devices = new ChainHashMap<>();

    private Devices() {
        throw new UnsupportedOperationException("Esta clase no puede ser instanciada.");
    }

    /**
     * Agrega un dispositivo al mapa.
     * @param device el dispositivo a agregar
     */
    public static void addDevice(Device device) {
        devices.put(device.getId(), device);
    }

    /**
     * Devuelve el dispositivo con el identificador especificado.
     * @param id el identificador del dispositivo
     * @return Device
     */
    public static Device getDevice(String id) {
        return devices.get(id);
    }

    /**
     * Elimina el dispositivo con el identificador especificado.
     * @param id el identificador del dispositivo
     */
    public static void removeDevice(String id) {
        devices.remove(id);
    }

    /**
     * Devuelve los dispositivos.
     * @return Map<String, Device>
     */
    public static Map<String, Device> getDevices() {
        return devices;
    }

}
