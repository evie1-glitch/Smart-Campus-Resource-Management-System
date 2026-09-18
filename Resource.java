package main.java.com.campus.management.model;

public class Resource {

    private int id;
    private String name;
    private String type;
    private String location;
    private boolean available;

    public Resource(int id, String name, String type, String location, boolean available) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.location = location;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    public boolean isAvailable() {
        return available;
    }
}
