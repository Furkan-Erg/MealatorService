package com.furkanerguldurenler.services;

import com.furkanerguldurenler.dto.ShoppingListDto;
import com.furkanerguldurenler.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface IUserService {

    public List<UserDto> getAllUsers();

    public UserDto findUserById(Long id);


    public ShoppingListDto getShoppingListByUserId(Long userId);


    public UserDto getUserInfo(String username);
}
