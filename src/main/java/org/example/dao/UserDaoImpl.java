package org.example.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.configuration.ConnectionManager;
import org.example.entity.User;
import jakarta.transaction.Transactional;
import org.example.repository.UserRepository;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


@Transactional
@Service
@RequiredArgsConstructor
@Slf4j
public class UserDaoImpl implements UserDao {

    private final UserRepository userRepository;

    @Override
    public void addUser(User user) {
        try {
            userRepository.saveAndFlush(user);
            log.info("Users added in database");
        } catch (HibernateException e) {
            log.error("Error" + e);
        }
    }

    @Override
    public void deleteUserById(int id) {
        try {
            userRepository.deleteById(id);
            log.info("User deleted with index " + id);
        } catch (HibernateException e) {
            log.error("Error" + e);
        }
    }
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        try {
            log.info("List  was got users");
            return userRepository.findAll();
        } catch (HibernateException e) {
            log.error("Error" + e);
            return new ArrayList<>();
        }
    }
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @Override
    public User getUSerById(int id) throws MyException {
        return userRepository.findById(id).orElseThrow(() -> new MyException("User with index " + id + "does not exist"));
    }

    @Override
    public void updateUser(int id, String firstName, String lastName) {
        try {
            userRepository.updateUser(id, firstName, lastName);
            log.info("User update");
        } catch (HibernateException e) {
            log.error("Error" + e);
        }
    }

    @Override
    public void deleteAllUsers() {
        try {
            userRepository.deleteAll();
            log.info("Users deleted");
        } catch (HibernateException e) {
            log.error("Error" + e);
        }
    }
}
