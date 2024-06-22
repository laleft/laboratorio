package org.network.models;

public class Location {
    private String id;
    private String building;
    private String floor;
    private String room;

    public Location(String id, String building, String floor, String room) {
        this.id = id;
        this.building = building;
        this.floor = floor;
        this.room = room;
    }

    public String getId() {
        return id;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Location [id=" + id + ", building=" + building + ", floor=" + floor + ", room=" + room + "]";
    }
}
