package com.furkanerguldurenler.services;

import java.util.List;

import com.furkanerguldurenler.dto.ShoppingListDto;
import com.furkanerguldurenler.dto.UserDto;

public interface IUserService {

	public List<UserDto> getAllUsers();
	
	public UserDto findUserById(Integer id);
	
	public void addUser(UserDto user);
	
	public ShoppingListDto getShoppingListByUserId(Integer userId);
}
