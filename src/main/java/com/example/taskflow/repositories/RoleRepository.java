package com.example.taskflow.repositories;

import com.example.taskflow.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByIsDefaultTrue();


    Optional<Role> findByName(String name);
}
