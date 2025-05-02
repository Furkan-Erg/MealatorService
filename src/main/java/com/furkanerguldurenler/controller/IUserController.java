package com.furkanerguldurenler.controller;

import java.util.List;

import com.furkanerguldurenler.dto.ShoppingListDto;
import com.furkanerguldurenler.dto.UserDto;
import com.furkanerguldurenler.entities.RootEntity;

public interface IUserController {

    public RootEntity<List<UserDto>> getAllUsers();

    public RootEntity<UserDto> findUserById(Integer id);

    public void addUser(UserDto user);

    public RootEntity<ShoppingListDto> getShoppingListByUserId(Integer userId);
}
