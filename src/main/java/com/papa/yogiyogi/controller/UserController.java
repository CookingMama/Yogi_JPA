package com.papa.yogiyogi.controller;

import com.papa.yogiyogi.Exception.IdCheckException;
import com.papa.yogiyogi.Exception.LoginException;
import com.papa.yogiyogi.domain.request.LoginRequest;
import com.papa.yogiyogi.domain.request.SignupRequest;
import com.papa.yogiyogi.domain.response.UserResponse;
import com.papa.yogiyogi.repository.UserRepository;
import com.papa.yogiyogi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping("/login")
    public UserResponse login(@RequestBody @Valid LoginRequest request) throws LoginException {
        return userService.loginService(request);
    }
    @PostMapping("/signup")
    public UserResponse signUp(@RequestBody @Valid SignupRequest request) throws IdCheckException, LoginException {
        return userService.signupService(request);
    }
}
