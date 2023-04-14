package org.example.testing;

import org.example.configuration.PersistenceConfig;
import org.example.service.UserService;
import org.example.exceptionsProject.UserOutputException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws UserOutputException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersistenceConfig.class);
        UserService service = applicationContext.getBean(UserService.class);
        System.out.println(service.getUserById(2));
    }
}
