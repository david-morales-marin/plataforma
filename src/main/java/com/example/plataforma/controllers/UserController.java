package com.example.plataforma.controllers;

import com.example.plataforma.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/v1/user")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<Page<List<Map<String, Object>>>> getAllUsers(
            @RequestParam(defaultValue = "0")
            int page, @RequestParam(defaultValue = "5") int size){
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<List<Map<String, Object>>> userRequest = userService.getAllProjects(pageRequest);

        return ResponseEntity.ok(userRequest);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Page<Map<String, Object>>> getUserByEmail(
            @PathVariable String email,
            @PageableDefault(size = 10) Pageable pageable) {

        Page<Map<String, Object>> users = userService.getUserByEmail(email, pageable);
        return ResponseEntity.ok(users);
    }

}
