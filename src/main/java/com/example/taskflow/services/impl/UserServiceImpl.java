package com.example.taskflow.services.impl;

import com.example.taskflow.domain.Role;
import com.example.taskflow.domain.User;
import com.example.taskflow.repositories.UserRepository;
import com.example.taskflow.services.RoleService;
import com.example.taskflow.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User assignRole(Long id, String name) {
        Role role = roleService.getByName(name).orElse(null);
        User user = getById(id).orElse(null);
        if (user != null && role != null){
            user.setRole(role);
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public User update(User user, Long id) {
        User existingUser = getById(id).orElse(null);
        if (existingUser != null){
            existingUser.setEmail(user.getEmail());
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        getById(id).ifPresent(userRepository::delete);
    }
}
