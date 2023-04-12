package org.example.repository;

import org.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Integer> {
//    @Modifying
//    @Query ("update User u set u.lastName = :lastName, u.firstName = :firstName where u.id = :id")
//    void updateUser (@Param("id") int id, @Param("firstName") String firstName, @Param("lastName") String lastName);
}
