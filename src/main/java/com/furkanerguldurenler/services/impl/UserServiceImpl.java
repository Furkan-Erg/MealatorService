package com.furkanerguldurenler.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furkanerguldurenler.dto.ShoppingListDto;
import com.furkanerguldurenler.dto.UserDto;
import com.furkanerguldurenler.entities.ShoppingList;
import com.furkanerguldurenler.entities.User;
import com.furkanerguldurenler.repository.UserRepository;
import com.furkanerguldurenler.services.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserDto> getAllUsers() {
		List<User> userList = userRepository.findAll();
		List<UserDto> userListDto = new ArrayList<>();

		for (User user : userList) {
			UserDto tempUser = new UserDto();
			BeanUtils.copyProperties(user, tempUser);
			userListDto.add(tempUser);
		}

		return userListDto;
	}

	@Override
	public UserDto findUserById(Integer id) {
		Optional<User> user = userRepository.findById(id);
		if (user.get() == null) {
			return null;
		}
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(user.get(), userDto);
		return userDto;
	}

	@Override
	public void addUser(UserDto user) {
		User tempUser = new User();
		tempUser.setName(user.getName());
		tempUser.setSurname(user.getSurname());
		ShoppingList shoppingList = new ShoppingList();
		shoppingList.setName("shopping list");
		tempUser.setShoppingList(shoppingList);

		userRepository.save(tempUser);
	}

	@Override
	public ShoppingListDto getShoppingListByUserId(Integer userId) {
		Optional<User> user = userRepository.findById(userId);
		if (user.get() == null) {
			return null;
		}
		ShoppingListDto shoppingListDto = new ShoppingListDto();
		BeanUtils.copyProperties(user.get().getShoppingList(), shoppingListDto);
		return shoppingListDto;
	}

}
