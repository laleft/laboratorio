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
    static String ROOT_PATH = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    /**
     * Ruta del directorio de configuración.
     */
    static String CONFIG_PATH = ROOT_PATH + "org/network/config/";
    /**
     * Ruta del directorio de datos.
     */
    static String DATA_PATH = ROOT_PATH + "org/network/data/";
    /**
     * Nombre del archivo de propiedades.
     */
    static String PROPERTIES_FILE = "datafiles.properties";
    /**
     * Delimitador de coma.
     */
    static String COMMA_DELIMITER = ",";

    /**
     * Constructor privado para evitar la instanciación de la clase.
     */
    private AppConstants() {
        throw new UnsupportedOperationException("Esta es una clase no puede ser instanciada.");
    }
}
