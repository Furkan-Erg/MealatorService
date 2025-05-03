package com.furkanerguldurenler.services;

import com.furkanerguldurenler.dto.LoginDto;
import com.furkanerguldurenler.dto.RegisterDto;
import com.furkanerguldurenler.dto.RegisterResponse;

public interface IAuthService {
    public RegisterResponse register(RegisterDto registerDto);

    public RegisterResponse login(LoginDto loginDto);
}
