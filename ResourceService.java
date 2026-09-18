package main.java.com.campus.management.service;

import java.util.List;

import main.java.com.campus.management.model.Resource;
import main.java.com.campus.management.repository.ResourceRepository;

public class ResourceService {

    private ResourceRepository repository;

    public ResourceService() {
        repository = new ResourceRepository();
    }

    public void addResource(Resource resource) {
        repository.addResource(resource);
    }

    public List<Resource> getAllResources() {
        return repository.getAllResources();
    }

    public Resource findResource(int id) {
        return repository.findById(id);
    }
}