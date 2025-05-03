package com.furkanerguldurenler.services;

import java.util.List;

import com.furkanerguldurenler.dto.*;

public interface IUserService {

    public List<UserDto> getAllUsers();

    public UserDto findUserById(Long id);

    public void addUser(UserDto user);

    public ShoppingListDto getShoppingListByUserId(Long userId);


}
