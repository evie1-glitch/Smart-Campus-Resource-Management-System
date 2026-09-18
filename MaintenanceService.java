package main.java.com.campus.management.service;

import java.util.ArrayList;
import java.util.List;

import main.java.com.campus.management.model.MaintenanceRequest;

public class MaintenanceService {

    private List<MaintenanceRequest> requests = new ArrayList<>();

    public void addRequest(MaintenanceRequest request) {
        requests.add(request);
    }

    public List<MaintenanceRequest> getAllRequests() {
        return requests;
    }

    public void showRequests() {

        if (requests.isEmpty()) {
            System.out.println("No maintenance requests found.");
            return;
        }

        for (MaintenanceRequest request : requests) {

            System.out.println(
                "Request ID: " + request.getId()
                + " | Resource ID: " + request.getResourceId()
                + " | Description: " + request.getDescription()
                + " | Priority: " + request.getPriority()
                + " | Status: " + request.getStatus()
            );
        }
    }
}
