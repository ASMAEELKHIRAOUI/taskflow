package com.example.taskflow.dto;

import com.example.taskflow.domain.enums.AuthorityEnum;

import java.util.Set;

public record RoleDTO(
         String name,
         Set<AuthorityEnum> authorities,
         boolean default_role
){

}
