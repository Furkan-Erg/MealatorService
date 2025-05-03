package com.furkanerguldurenler.controller.impl;

import com.furkanerguldurenler.controller.IAuthController;
import com.furkanerguldurenler.dto.LoginDto;
import com.furkanerguldurenler.dto.RegisterDto;
import com.furkanerguldurenler.dto.RegisterResponse;
import com.furkanerguldurenler.entities.RootEntity;
import com.furkanerguldurenler.services.impl.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.furkanerguldurenler.entities.RootEntity.ok;

@RestController
@RequestMapping("/rest/api/auth")
public class AuthController implements IAuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public RootEntity<RegisterResponse> register(@RequestBody RegisterDto registerDto) {
        return ok(authService.register(registerDto));
    }

    @PostMapping("/login")
    public RootEntity<RegisterResponse> login(@RequestBody LoginDto loginDto) {
        return ok(authService.login(loginDto));
    }
}
