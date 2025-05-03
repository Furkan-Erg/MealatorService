package com.furkanerguldurenler.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.furkanerguldurenler.dto.*;
import com.furkanerguldurenler.enums.Role;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.furkanerguldurenler.entities.ShoppingList;
import com.furkanerguldurenler.entities.User;
import com.furkanerguldurenler.exception.BaseException;
import com.furkanerguldurenler.exception.ErrorMessage;
import com.furkanerguldurenler.exception.MessageType;
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
    public UserDto findUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString()));
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
    public ShoppingListDto getShoppingListByUserId(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.get() == null) {
            return null;
        }
        ShoppingListDto shoppingListDto = new ShoppingListDto();
        BeanUtils.copyProperties(user.get().getShoppingList(), shoppingListDto);
        return shoppingListDto;
    }


}
