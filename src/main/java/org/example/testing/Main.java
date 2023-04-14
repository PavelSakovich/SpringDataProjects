package org.example.testing;

import org.example.configuration.PersistenceConfig;
import org.example.service.UserService;
import org.example.exceptionProject.UserOutputException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws UserOutputException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersistenceConfig.class);
//        User user = new User("Павел", "Иванович", 20);
        UserService service = applicationContext.getBean(UserService.class);
//       service.addUser(new User("Кудрин", "Валентин", 55, new UserAddress("ЛИда", "Кооперативная", 20)));
//       service.getAllUsers().forEach(System.out::println);
//        service.updateUser(new User(2, "Нафранович", "Эдуард", 50));
//        System.out.println(service.getUserById(2));
service.getUsersByNumberHouse(22).forEach(x -> System.out.println(x));
//    service.addUser(new User("NON", "NON", 4));
//        System.out.println(user.get(0).getFirstName());
//        System.out.println(service.getUserById(1));
    }
}
