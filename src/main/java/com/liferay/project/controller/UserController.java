package com.liferay.project.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liferay.project.model.User;
import com.liferay.project.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Reference
    private UserService _userService;

	@GetMapping()
    public List<User> getUsers() {
        List<User> response = _userService.findAll();

        return response;
    }

	@GetMapping("{id}")
    public User getUser(@PathVariable("id") Long id) {
        return _userService.fetchUser(id);
    }
    
	@PostMapping()
    public User addUser(@RequestBody User user) {
        return _userService.addUser(user);
    }

    @PutMapping("{id}")
    public User updateUser(@PathParam("id") Long id, @RequestBody User user) {
        return _userService.updateUser(id, user);
    }

}
