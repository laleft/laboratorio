package org.network.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.HashMap;

/**
 * Clase que carga las propiedades de la aplicación.
 * @version 1.0
 * @since 2024-06-14
 * @author sdebernardez
 */
public class AppProperties {

    private static final HashMap<String, String> properties = new HashMap<>();
    
    /**
     * Crea una nueva instancia de la clase AppProperties.
     * @param filename el nombre del archivo de propiedades
     */
    public AppProperties(String filename) {
        
        Properties props = new Properties();

        String appPropertiesPath = AppConstants.CONFIG_PATH + filename;
        try {
            props.load(new FileInputStream(new File(appPropertiesPath)));
            for (String key : props.stringPropertyNames()) {
                properties.put(key, props.getProperty(key));
            }
        } catch (FileNotFoundException fileerror) {
            fileerror.printStackTrace();
        } catch (IOException ioerror) {
            ioerror.printStackTrace();
        }
    }

    /**
     * Devuelve las propiedades de la aplicación.
     * @return las propiedades de la aplicación
     */
    public HashMap<String, String> getProperties() {
        return properties;
    }

    /**
     * Devuelve la propiedad con la clave especificada.
     * @param key la clave de la propiedad
     * @return la propiedad con la clave especificada
     */
    public String getProperty(String key) {
        return properties.get(key);
    }
}
