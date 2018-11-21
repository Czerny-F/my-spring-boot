package com.example.demo.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.services.UserService;
import com.example.demo.entities.User;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

  @Autowired
  private UserService userService;

  @GetMapping("/users")
  public Iterable<User> userList() {
    return userService.selectAll();
  }

  @PostMapping("/register")
  public User register(@RequestParam String username, @RequestParam String password) {
    return userService.registerUser(username, password);
  }
}
