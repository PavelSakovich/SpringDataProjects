package org.example.dao;

import org.example.entity.User;

import java.util.List;

public interface UserDao {
   void addUser (User user);
   void deleteUserById (int id) ;
   List<User> getAllUsers () ;
   User getUSerById (int id) throws MyException;
   void updateUser (int id, String firstName, String lastName);
   void deleteAllUsers();
}
