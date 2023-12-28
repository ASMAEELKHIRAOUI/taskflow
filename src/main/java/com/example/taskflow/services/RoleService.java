package com.example.taskflow.services;

import com.example.taskflow.domain.Role;
import com.example.taskflow.domain.enums.AuthorityEnum;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface RoleService {

    Role save(Role role);

    Optional<Role> findDefaultRole();

    Role update(Role role, Long id);

    Optional<Role> getById(Long id);

    void delete(Long id);

    List<Role> getAll();

    Role grantAuthorities(List<AuthorityEnum> authorities, Long id);

    Role revokeAuthorities(List<AuthorityEnum> authorities, Long id);

}