package org.network.services;

import java.io.File;
import java.util.Scanner;

import net.datastructures.ArrayList;
import net.datastructures.List;
import net.datastructures.Map;
import net.datastructures.ChainHashMap;  

/**
* Clase que carga los datos de un archivo CSV.
* @version 1.0
* @since 2024-06-14
* @autor sdebernardez
 */
public class AppData {
    
    /**
     * Propiedades de la aplicación.
     * @see AppProperties
     * @see AppConstants
     */
    private static AppProperties filepaths = new AppProperties(AppConstants.PROPERTIES_FILE);

    /**
     * Carga los datos de un archivo CSV.
     * @param key
     * @return Map<String, Map<String, String>>
     * @see AppConstants
     * @see List
     * @see ChainHashMap
     */
    public Map<String, Map<String, String>> loadData(String key) {
        Map<String, Map<String, String>> records = new ChainHashMap<>();
        String filepath = AppConstants.DATA_PATH + filepaths.getProperty(key);
        try (Scanner scanner = new Scanner(new File(filepath))) {
            /**
             * Obtiene los encabezados del archivo CSV.
             */
            List<String> header = getRecordFromLine(scanner.nextLine());
            /**
             * Obtiene los datos línea por línea.
             */
            while (scanner.hasNextLine()) {
                List<String> record = getRecordFromLine(scanner.nextLine());
                records.put(record.get(0), createMap(header, record));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return records;
    }

    /**
     * Crea un mapa con los encabezados y los datos de una línea del archivo CSV.
     * @param header
     * @param record
     * @return Map<String, String>
     */
    private Map<String, String> createMap(List<String> header, List<String> record) {
        Map<String, String> map = new ChainHashMap<>();
        for(int i = 0; i < header.size(); i++) {
            map.put(header.get(i), record.get(i));
        }
        return map;
    }

    /**
     * Obtiene los datos de una línea del archivo CSV.
     * @param line
     * @return List<String>
     * @see List
     * @see ArrayList
     */
    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(AppConstants.COMMA_DELIMITER);
            while (rowScanner.hasNext()) {
                values.add(values.size(), rowScanner.next());
            }
        }
        return values;
    }
}
