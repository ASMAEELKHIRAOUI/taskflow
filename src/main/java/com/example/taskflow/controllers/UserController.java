package com.example.taskflow.controllers;

import com.example.taskflow.domain.Role;
import com.example.taskflow.domain.User;
import com.example.taskflow.dto.requests.RoleRequestDTO;
import com.example.taskflow.dto.responses.UserResponseDTO;
import com.example.taskflow.services.RoleService;
import com.example.taskflow.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    @PutMapping("/assign_role/{id}")
    public ResponseEntity<UserResponseDTO> assignRole(@RequestBody RoleRequestDTO request, @PathVariable Long id){
        Role role = roleService.getByName(request.name()).orElse(null);
        User user = userService.assignRole(id, role);
        if (user == null && role == null) return ResponseEntity.badRequest().build();
        else return new ResponseEntity<>(UserResponseDTO.fromUser(user), HttpStatus.OK);
    }

}
