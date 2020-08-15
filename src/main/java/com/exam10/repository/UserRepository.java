package com.exam10.repository;


import com.exam10.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByEmail(String email);
    List<User> findAllById(int id);
    User findById(int id);
    boolean existsById(int id);
    boolean existsByEmail(String email);
}
