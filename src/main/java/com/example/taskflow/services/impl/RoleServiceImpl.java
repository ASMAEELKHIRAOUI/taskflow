package com.example.taskflow.services.impl;

import com.example.taskflow.domain.Authority;
import com.example.taskflow.domain.Role;
import com.example.taskflow.domain.enums.AuthorityEnum;
import com.example.taskflow.handler.exception.CustomException;
import com.example.taskflow.repositories.RoleRepository;
import com.example.taskflow.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;

    @Override
    public List<Role> getAll(){
        return roleRepository.findAll();
    }

    @Override
    public Role save(Role role){
        if (findDefaultRole().isPresent() && role.isDefault()) throw new CustomException("There is already a default role", HttpStatus.UNAUTHORIZED);
        return roleRepository.save(role);
    }

    @Override
    public Optional<Role> findDefaultRole(){
        return roleRepository.findByIsDefaultTrue();
    }

    @Override
    public Role grantAuthorities(List<Authority> authoritiesToGrant, Long id){
        Role role = roleRepository.findById(id).orElse(null);
        if (role != null){
            Set<Authority> authorities = new HashSet<>(role.getAuthorities());
            authorities.addAll(authoritiesToGrant);
            List<Authority> authorityList = new ArrayList<>(authorities);
            role.setAuthorities(authorityList);
            return roleRepository.save(role);
        }
        return null;
    }

    @Override
    public Role revokeAuthorities(List<Authority> authoritiesToRevoke, Long id){
//        Role role = roleRepository.findById(id).orElse(null);
//        if (role != null){
//            List<AuthorityEnum> currentAuthorities = new ArrayList<>(role.getAuthorities());
//            currentAuthorities.removeAll(authoritiesToRevoke);
//            role.setAuthorities(new HashSet<>(currentAuthorities));
//            return roleRepository.save(role);
//        }
        return null;
    }

    @Override
    public Role update(Role role, Long id){
        Role existingRole = getById(id).orElse(null);
        if (existingRole != null){
            existingRole.setName(role.getName());
            existingRole.setAuthorities(role.getAuthorities());
            if (role.isDefault() && findDefaultRole().isPresent()) throw new CustomException("There is already a default role", HttpStatus.UNAUTHORIZED);
            existingRole.setDefault(role.isDefault());
            return roleRepository.save(existingRole);
        }
        return null;
    }

    @Override
    public Optional<Role> getById(Long id){
        return roleRepository.findById(id);
    }

    @Override
    public void delete(Long id){
        getById(id).ifPresent(roleRepository::delete);
    }

}
