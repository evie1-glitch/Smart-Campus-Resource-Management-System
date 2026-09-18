package main.java.com.campus.management.repository;

import java.util.ArrayList;
import java.util.List;

import main.java.com.campus.management.model.Resource;

public class ResourceRepository {

    private List<Resource> resources = new ArrayList<>();

    public void addResource(Resource resource) {
        resources.add(resource);
    }

    public List<Resource> getAllResources() {
        return resources;
    }

    public Resource findById(int id) {
        for (Resource resource : resources) {
            if (resource.getId() == id) {
                return resource;
            }
        }

        return null;
    }
}
