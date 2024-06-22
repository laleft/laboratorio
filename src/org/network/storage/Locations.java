package org.network.storage;

import net.datastructures.ChainHashMap;
import net.datastructures.Map;

import org.network.models.Location;

/**
 * Clase que almacena las ubicaciones de los nodos.
* @version 1.0
* @since 2024-06-14
* @autor sdebernardez
* @see Location
 */
public class Locations {

    private Locations() {
        throw new UnsupportedOperationException("Esta clase no puede ser instanciada.");
    }
    
    /**
     * Mapa que almacena las ubicaciones.
     */
    private static Map<String, Location> locations = new ChainHashMap<>();

    /**
     * Agrega una ubicación al mapa.
     * @param location la ubicación a agregar
     */
    public static void addLocation(Location location) {
        locations.put(location.getId(), location);
    }

    /**
     * Devuelve la ubicación con el identificador especificado.
     * @param id
     * @return Location
     */
    public static Location getLocation(String id) {
        return locations.get(id);
    }

    /**
     * Elimina la ubicación con el identificador especificado.
     * @param id
     */
    public static void removeLocation(String id) {
        locations.remove(id);
    }

    /**
     * Devuelve las ubicaciones.
     * @return Map<String, Location>
     */
    public static Map<String, Location> getLocations() {
        return locations;
    }    
}
