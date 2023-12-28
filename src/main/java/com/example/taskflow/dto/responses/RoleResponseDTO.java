package com.example.taskflow.dto.responses;

import com.example.taskflow.domain.enums.AuthorityEnum;

import java.util.Set;

public record RoleResponseDTO(
        String name,
        Set<AuthorityEnum> authorities,
        boolean default_role
) {
}
