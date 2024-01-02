package com.example.taskflow.services;

import com.example.taskflow.domain.Authority;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AuthorityService {
    List<Authority> getAllByName(List<String> authorities);
}
