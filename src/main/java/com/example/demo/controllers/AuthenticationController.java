package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.repositories.UserRepository;
import com.example.demo.entities.User;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
  @Autowired
  private UserRepository userRepository;

    @GetMapping("/users")
    public @ResponseBody Iterable<User> userList() {
        return userRepository.findAll();
    }
}
