package com.example.taskflow.controllers;

import com.example.taskflow.domain.Role;
import com.example.taskflow.domain.User;
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

    @PutMapping("/assign_role/{id}")
    public ResponseEntity<User> assignRole(@RequestBody String role, @PathVariable Long id){
        User user = userService.assignRole(id, role);
        if (user == null) return ResponseEntity.badRequest().build();
        else return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
