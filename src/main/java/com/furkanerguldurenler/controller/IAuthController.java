package com.furkanerguldurenler.controller;

import com.furkanerguldurenler.dto.LoginDto;
import com.furkanerguldurenler.dto.RegisterDto;
import com.furkanerguldurenler.dto.RegisterResponse;
import com.furkanerguldurenler.entities.RootEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface IAuthController {
    public RootEntity<RegisterResponse> register(@RequestBody RegisterDto registerDto);

    public RootEntity<RegisterResponse> login(@RequestBody LoginDto loginDto);
}
