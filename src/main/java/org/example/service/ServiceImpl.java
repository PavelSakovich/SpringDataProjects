package org.example.service;

import lombok.extern.java.Log;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Transactional
@Service
@RequiredArgsConstructor
@Log
public class ServiceImpl implements EntityService {

    private final UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
        log.info("Users added in database");

    }

    @Override
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
        log.info("User deleted with index " + id);
    }

    @Override
    public List<User> getAllUsers() {
        log.info("List  was got users");
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) throws MyException {
        return userRepository.findById(id).orElseThrow(() -> new MyException("User with index " + id + "does not exist"));
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
        log.info("User update");
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
        log.info("Users deleted");
    }
    public List<User> getUsersByNumberHouse(int house){
        log.info("List  was got users");
        return userRepository.getUsersByNumberHouse(house);
    }
}
