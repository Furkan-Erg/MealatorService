package com.furkanerguldurenler.controller.impl;

import java.util.List;

import com.furkanerguldurenler.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.furkanerguldurenler.controller.IUserController;
import com.furkanerguldurenler.entities.RootEntity;
import com.furkanerguldurenler.services.IUserService;

@RestController
@RequestMapping("/rest/api/user")
public class UserControllerImpl extends RestBaseController implements IUserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/list")
    @Override
    public RootEntity<List<UserDto>> getAllUsers() {
        return ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    @Override
    public RootEntity<UserDto> findUserById(@PathVariable Integer id) {
        return ok(userService.findUserById(Long.valueOf(id)));
    }

    @GetMapping("/info")
    @Override
    public RootEntity<UserDto> getUserInfo(@AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
        return ok(userService.getUserInfo(username));
    }


}
