package org.network.models;

/**
 * Clase que representa una ubicación física.
 * @version 1.0
 * @since 2024-06-14
 * @author sdebernardez
 */
public class Location {
    private String id;
    private String building;
    private String floor;
    private String room;

    /**
     * Crea una nueva instancia de la clase Location.
     * @param id el identificador de la ubicación
     * @param building el edificio
     * @param floor el piso
     * @param room la sala
     */
    public Location(String id, String building, String floor, String room) {
        this.id = id;
        this.building = building;
        this.floor = floor;
        this.room = room;
    }

    /**
     * Devuelve el identificador de la ubicación.
     * @return String
     */
    public String getId() {
        return id;
    }

    /**
     * Devuelve el edificio.
     * @return String
     */
    public String getBuilding() {
        return building;
    }

    /**
     * Establece el edificio.
     * @param building nombre del edificio
     */
    public void setBuilding(String building) {
        this.building = building;
    }

    /**
     * Devuelve el piso.
     * @return String
     */
    public String getFloor() {
        return floor;
    }

    /**
     * Establece el piso.
     * @param floor el nombre o número de piso
     */
    public void setFloor(String floor) {
        this.floor = floor;
    }

    /**
     * Devuelve la sala.
     * @return String
     */
    public String getRoom() {
        return room;
    }

    /**
     * Establece la sala.
     * @param room el nombre o número de sala
     */
    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Location [id=" + id + ", building=" + building + ", floor=" + floor + ", room=" + room + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Location other = (Location) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
}
