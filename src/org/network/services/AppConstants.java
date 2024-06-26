package org.network.services;

/**
 * Clase que contiene las constantes de la aplicación.
 * @version 1.0
 * @since 2024-06-14
 * @author sdebernardez
 */
public final class AppConstants {

    /**
     * Ruta del directorio raíz.
     */
    public static String ROOT_PATH = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    /**
     * Ruta del directorio de configuración.
     */
    public static String CONFIG_PATH = ROOT_PATH + "org/network/config/";
    /**
     * Ruta del directorio de datos.
     */
    public static String DATA_PATH = ROOT_PATH + "org/network/data/";
    /**
     * Nombre del archivo de propiedades.
     */
    public static String PROPERTIES_FILE = "datafiles.properties";
    /**
     * Delimitador de coma.
     */
    public static String COMMA_DELIMITER = ",";
    /**
     * Tipo de dispositivo 'computer'
     */
    public static String COMPUTERS = "computers";
    /**
     * Tipo de dispositivo 'router'
     */
    public static String ROUTERS = "routers";
    /**
     * Tipo 'location'
     */
    public static String LOCATIONS = "locations";
    /**
     * Tipo 'connection'
     */
    public static String CONNECTIONS = "connections";
    /**
     * Tipos de dispositivos.
     * @todo Implementar factory pattern para crear dispositivos.
     */
    public static String[] DEVICES = {COMPUTERS, ROUTERS};

    /**
     * Constructor privado para evitar la instanciación de la clase.
     */
    private AppConstants() {
        throw new UnsupportedOperationException("Esta es una clase no puede ser instanciada.");
    }
}
