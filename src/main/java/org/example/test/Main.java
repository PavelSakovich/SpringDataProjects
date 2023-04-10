package org.example.test;

import org.example.configuration.ConnectionManager;
import org.example.dao.UserDao;
import org.example.dao.UserDaoImpl;
import org.example.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConnectionManager.class);
        User user1 = new User("Nikolaev", "Nikolay", 40);
        UserDao userDao = applicationContext.getBean(UserDao.class);
        List<User> userList = userDao.getAllUsers();
        userList
                .stream()
                .forEach(System.out::println);

    }
}
