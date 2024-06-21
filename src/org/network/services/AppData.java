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
     * @return una lista con los datos del archivo CSV
     * @see AppConstants
     * @see List
     * @see ArrayList
     */
    public Map<Integer, List<String>> loadData(String key) {
        Map<Integer, List<String>> records = new ChainHashMap<>();
        String filepath = AppConstants.DATA_PATH + filepaths.getProperty(key);
        try (Scanner scanner = new Scanner(new File(filepath))) {
            while (scanner.hasNextLine()) {
                List<String> record = getRecordFromLine(scanner.nextLine());
                /**
                 * @todo Mejorar la validación de la cabecera del archivo CSV.
                 */
                if(record.get(0).equals("id")) {
                    continue;
                }
                records.put(Integer.parseInt(record.get(0)), record);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return records;
    }

    /**
     * Obtiene los datos de una línea del archivo CSV.
     * @param line
     * @return una lista con los datos de la línea
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
