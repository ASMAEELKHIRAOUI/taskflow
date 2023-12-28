package com.example.taskflow.mapper;

import com.example.taskflow.domain.Role;
import com.example.taskflow.dto.RoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    Role toEntity(RoleDTO roleDto);
    RoleDTO toDto(Role role);
    List<RoleDTO> rolesToDTOs(List<Role> roles);
}
