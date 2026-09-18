package main.java.com.campus.management.model;

public class MaintenanceRequest {

    private int id;
    private int userId;
    private int resourceId;
    private String description;
    private String priority;
    private String status;

    public MaintenanceRequest(int id, int userId, int resourceId,
                               String description, String priority,
                               String status) {

        this.id = id;
        this.userId = userId;
        this.resourceId = resourceId;
        this.description = description;
        this.priority = priority;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public String getDescription() {
        return description;
    }

    public String getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
