package org.example.service;

import lombok.extern.java.Log;
import org.example.exceptionsProject.UserOutputException;
import lombok.RequiredArgsConstructor;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service
@RequiredArgsConstructor
@Log
public class UserServiceImpl implements UserService {

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
    public User getUserById(int id) throws UserOutputException {
        return userRepository.findById(id).orElseThrow(() -> new UserOutputException("User with index " + id + "does not exist"));
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
}