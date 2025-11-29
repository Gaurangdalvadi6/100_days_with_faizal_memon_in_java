package com.gaurang.first.app.repository;

import com.gaurang.first.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    List<User> findByNameIgnoreCase(String name);

    List<User> findByEmailIgnoreCase(String email);

    List<User> findByNameIgnoreCaseAndEmailIgnoreCase(String name, String email);
}
