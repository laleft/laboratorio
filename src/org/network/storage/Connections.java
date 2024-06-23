package org.network.storage;

import org.network.models.Connection;

import net.datastructures.ChainHashMap;
import net.datastructures.Map;

/**
 * Clase que almacena las conexiones entre los nodos.
 * @version 1.0
 * @since 2024-06-14
 * @author sdebernardez
 * @see Connection
 * @see org.network.services.AppInitializer
 */
public class Connections {
        
        /**
         * Mapa que almacena las conexiones.
         * @see AppInitializer.storeConnections()
         */
        private static Map<String, Connection> connections = new ChainHashMap<>();
    
        private Connections() {
            throw new UnsupportedOperationException("Esta clase no puede ser instanciada.");
        }
    
        /**
         * Agrega una conexión al mapa.
         * @param connection la conexión a agregar
         */
        public static void addConnection(Connection connection) {
            connections.put(connection.getId(), connection);
        }
    
        /**
         * Devuelve la conexión con el identificador especificado.
         * @param id el identificador de la conexión
         * @return Connection
         */
        public static Connection getConnection(String id) {
            return connections.get(id);
        }
    
        /**
         * Elimina la conexión con el identificador especificado.
         * @param id el identificador de la conexión
         */
        public static void removeConnection(String id) {
            connections.remove(id);
        }
    
        /**
         * Devuelve las conexiones.
         * @return Map<String, Connection>
         */
        public static Map<String, Connection> getConnections() {
            return connections;
        }
}
