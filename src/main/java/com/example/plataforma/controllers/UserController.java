package com.example.plataforma.controllers;

import com.example.plataforma.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

}
