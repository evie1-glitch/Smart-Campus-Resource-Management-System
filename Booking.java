package main.java.com.campus.management.model;

public class Booking {

    private int id;
    private int userId;
    private int resourceId;
    private String bookingDate;
    private String startTime;
    private String endTime;
    private String status;

    public Booking(int id, int userId, int resourceId,
                   String bookingDate, String startTime,
                   String endTime, String status) {

        this.id = id;
        this.userId = userId;
        this.resourceId = resourceId;
        this.bookingDate = bookingDate;
        this.startTime = startTime;
        this.endTime = endTime;
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

    public String getBookingDate() {
        return bookingDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}