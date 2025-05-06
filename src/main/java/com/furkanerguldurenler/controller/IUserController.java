package com.furkanerguldurenler.controller;

import java.util.List;

import com.furkanerguldurenler.dto.ShoppingListDto;
import com.furkanerguldurenler.dto.UserDto;
import com.furkanerguldurenler.entities.RootEntity;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUserController {

    public RootEntity<List<UserDto>> getAllUsers();

    public RootEntity<UserDto> findUserById(Integer id);


    public RootEntity<UserDto> getUserInfo(UserDetails userDetails);
}
