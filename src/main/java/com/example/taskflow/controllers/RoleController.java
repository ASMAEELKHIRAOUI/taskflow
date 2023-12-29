package com.example.taskflow.controllers;

import com.example.taskflow.domain.Authority;
import com.example.taskflow.domain.Role;
import com.example.taskflow.handler.response.ResponseMessage;
import com.example.taskflow.mapper.RoleMapper;
import com.example.taskflow.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;
    //private final RoleMapper roleMapper;

    @GetMapping
    public ResponseEntity getAll(){
        List<Role> roles = roleService.getAll();
        if (roles.isEmpty()) return ResponseMessage.notFound("No roles were found");
        else return ResponseMessage.ok("Roles fetched successfully", roles);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Role roleToSave){
        Role role = roleService.save(roleToSave);
        if (role == null) return ResponseMessage.badRequest("bad request");
        else return ResponseMessage.created("Role saved successfully", role);
    }

    @PutMapping("/grant_authorities/{id}")
    public ResponseEntity grantAuthorities(@RequestBody List<Authority> authorities, @PathVariable Long id){
        Role role = roleService.grantAuthorities(authorities, id);
        if (role == null) return ResponseMessage.badRequest("bad request");
        else return ResponseMessage.created("Authorities granted successfully", role);
    }

    @PutMapping("/revoke_authorities/{id}")
    public ResponseEntity<Role> revokeAuthorities(@RequestBody List<String> authorities, @PathVariable Long id){
        Role role = roleService.revokeAuthorities(authorities, id);
        if (role == null) return ResponseEntity.badRequest().build();
        else return new ResponseEntity<>(role, HttpStatus.OK);
    }

}
