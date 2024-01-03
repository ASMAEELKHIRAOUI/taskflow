package com.example.taskflow.dto.responses;

import com.example.taskflow.domain.Authority;
import com.example.taskflow.domain.Role;
import com.example.taskflow.domain.enums.AuthorityEnum;

import java.util.List;

public record RoleResponseDTO(
        String name,
        List<AuthorityEnum> authorities,
        boolean isDefault
) {
    public static RoleResponseDTO fromRole(Role role){
        return new RoleResponseDTO(
                role.getName(),
                role.getAuthorities().stream().map(Authority::getName).toList(),
                role.isDefault()
        );
    }
}
