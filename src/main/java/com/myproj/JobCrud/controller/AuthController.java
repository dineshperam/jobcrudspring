package com.myproj.JobCrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproj.JobCrud.model.User;
import com.myproj.JobCrud.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {
   @Autowired
   private UserService userService;

   @PostMapping("/register")
   public ResponseEntity<String> registerUser(@RequestBody User user) {
      userService.registerUser(user);
      return ResponseEntity.ok("User registered successfully");
   }
}

