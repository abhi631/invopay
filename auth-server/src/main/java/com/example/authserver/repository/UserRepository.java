package com.example.authserver.repository;

import com.example.authserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("select u from User u where u.user_name = ?1")
    User findByUsername(String username);
}
