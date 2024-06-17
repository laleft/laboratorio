package models;


public class Computer {
    private String id;
    private String ipAddress;
    private String macAddress;
    private boolean status; // true: activo, false: inactivo
    private String location;

    /**
     * Crea una nueva instancia de la clase Computer.
     * 
     * @param id el identificador de la computadora
     * @param ipAddress la dirección IP de la computadora
     * @param macAddress la dirección MAC de la computadora
     * @param status el estado de la computadora (true: activo, false: inactivo)
     * @param location la ubicación de la computadora
     */
    public Computer(String id, String ipAddress, String macAddress, boolean status, String location) {
        this.id = id;
        this.ipAddress = ipAddress;
        this.macAddress = macAddress;
        this.status = status;
        this.location = location;
    }

    // Getters y setters para los atributos de Computer

    /**
     * Devuelve una representación en forma de cadena de la computadora.
     * 
     * @return una cadena que representa la computadora
     */
    @Override
    public String toString() {
        return "Computer{id='" + id + "', ipAddress='" + ipAddress + "', macAddress='" + macAddress + 
               "', status=" + (status ? "activo" : "inactivo") + ", location='" + location + "'}";
    }
}

