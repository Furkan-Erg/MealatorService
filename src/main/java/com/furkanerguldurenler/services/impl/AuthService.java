package com.furkanerguldurenler.services.impl;

import com.furkanerguldurenler.dto.LoginDto;
import com.furkanerguldurenler.dto.RegisterDto;
import com.furkanerguldurenler.dto.RegisterResponse;
import com.furkanerguldurenler.entities.User;
import com.furkanerguldurenler.enums.Role;
import com.furkanerguldurenler.repository.UserRepository;
import com.furkanerguldurenler.services.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public RegisterResponse register(RegisterDto registerDto) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(registerDto.getPassword());
        User user = User.builder().username(registerDto.getUsername())
                .password(encodedPassword).name(registerDto.getName()).surname(registerDto.getSurname())
                .role(Role.USER).build();
        userRepository.save(user);

        var token = jwtService.generateToken(user);
        return RegisterResponse.builder().token(token).build();
    }

    @Override
    public RegisterResponse login(LoginDto loginDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        User user = userRepository.findByUsername(loginDto.getUsername()).orElseThrow();
        String token = jwtService.generateToken(user);
        return RegisterResponse.builder().token(token).build();
    }
}
