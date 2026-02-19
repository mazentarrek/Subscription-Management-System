package com.mazen.subscriptionmanager.services.Impl;

import com.mazen.subscriptionmanager.dto.Request.LoginRequest;
import com.mazen.subscriptionmanager.dto.Request.RegisterRequest;
import com.mazen.subscriptionmanager.dto.Response.AuthResponse;
import com.mazen.subscriptionmanager.entity.User;
import com.mazen.subscriptionmanager.mappers.UserMapper;
import com.mazen.subscriptionmanager.repositories.UserRepository;
import com.mazen.subscriptionmanager.security.JWTTokenProvider;
import com.mazen.subscriptionmanager.services.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JWTTokenProvider jwtService; // Your utility for generating tokens

    public AuthServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder, JWTTokenProvider jwtService) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public AuthResponse register(RegisterRequest registerRequest) {
        if(userRepository.existsByEmail(registerRequest.email())){
            throw new RuntimeException("Email Already Exists");
        }

        //Map DTO to Entity
        User user = userMapper.toEntity(registerRequest);

        //Encrypt the password before saving
        user.setPassword(passwordEncoder.encode(registerRequest.password()));

        //save user entity to database
        User savedUser = userRepository.save(user);

        //Generate the JWT
        String token = jwtService.generateToken(savedUser.getEmail());

        return userMapper.toResponse(savedUser, token);
    }

    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        if(!userRepository.existsByEmail(loginRequest.email())){
            throw new RuntimeException("Non registered user");
        }

        User user = userRepository.findByEmail(loginRequest.email());

        if (!passwordEncoder.matches(loginRequest.password(), user.getPassword())){
            throw new RuntimeException("Incorrect email or password");
        }

        //Generate the JWT
        String token = jwtService.generateToken(loginRequest.email());

        return userMapper.toResponse(user, token);
    }
}
