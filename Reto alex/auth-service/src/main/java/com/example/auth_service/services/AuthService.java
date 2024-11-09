package com.example.auth_service.services;

import com.example.auth_service.common.dto.TokenResponse;
import com.example.auth_service.common.dto.UserRequest;

public interface AuthService {
    TokenResponse createUser(UserRequest userRequest);
}