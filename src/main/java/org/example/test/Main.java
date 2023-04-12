package org.example.test;

import org.example.configuration.Configuration;
import org.example.entity.User;
import org.example.resource.EntityService;
import org.example.resource.MyException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws MyException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Configuration.class);
//        User user = new User("Павел", "Иванович", 20);
        EntityService service = applicationContext.getBean(EntityService.class);
//       service.getAllUsers().forEach(System.out::println);
//        service.updateUser(new User(2, "Нафранович", "Эдуард", 50));
        System.out.println(service.getUserById(2));
    }
}
