package com.furkanerguldurenler.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.furkanerguldurenler.controller.IUserController;
import com.furkanerguldurenler.dto.ShoppingListDto;
import com.furkanerguldurenler.dto.UserDto;
import com.furkanerguldurenler.services.IUserService;

@RestController
@RequestMapping("/rest/api/user")
public class UserControllerImpl implements IUserController {

	@Autowired
	private IUserService userService;

	@GetMapping("/list")
	@Override
	public List<UserDto> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/{id}")
	@Override
	public UserDto findUserById(@PathVariable Integer id) {
		return userService.findUserById(id);
	}

	@PostMapping("/add")
	@Override
	public void addUser(@RequestBody UserDto user) {
		userService.addUser(user);

	}

	@GetMapping("/shoppinglist")
	@Override
	public ShoppingListDto getShoppingListByUserId(@RequestParam Integer userId) {
		return userService.getShoppingListByUserId(userId);

	}

}
