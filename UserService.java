package main.java.com.campus.management.service;

import main.java.com.campus.management.model.User;

public class UserService {

    public User registerUser(int id, String name, String email, String password) {

        return new User(id, name, email, password, "STUDENT");
    }

    public boolean loginUser(User user, String email, String password) {

        return user.getEmail().equals(email)
                && user.getPassword().equals(password);
    }
}
