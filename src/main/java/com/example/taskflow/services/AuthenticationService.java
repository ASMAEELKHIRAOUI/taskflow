package com.example.taskflow.services;

import com.example.taskflow.dto.requests.AuthenticationRequest;
import com.example.taskflow.dto.requests.RegisterRequest;
import com.example.taskflow.dto.responses.AuthenticationResponse;
import org.springframework.stereotype.Component;

@Component
public interface AuthenticationService {

    AuthenticationResponse register(RegisterRequest user);

    AuthenticationResponse authenticate(AuthenticationRequest user);

}
