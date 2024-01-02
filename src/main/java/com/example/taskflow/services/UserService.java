package com.example.taskflow.services;

import com.example.taskflow.domain.Role;
import com.example.taskflow.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UserService {

    List<User> getAll();

    Optional<User> getById(Long id);

    User assignRole(Long id, String role);

    User update(User user, Long id);

    void delete(Long id);

}
