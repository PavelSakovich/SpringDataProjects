package org.example.resource;

import org.example.entity.User;

import java.util.List;

public interface EntityService {
    void addUser(User user);

    void deleteUserById(int id);

    List<User> getAllUsers();

    User getUserById(int id) throws MyException;

    void updateUser(User user);

    void deleteAllUsers();
}
