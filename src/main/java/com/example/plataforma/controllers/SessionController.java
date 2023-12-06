package com.example.plataforma.controllers;

import com.example.plataforma.services.CountryService;
import com.example.plataforma.services.SessionService;
import com.example.plataforma.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/v1/session")
public class SessionController {

    @Autowired
    private SessionService sessionService;
     @Autowired
     public SessionController(SessionService sessionService) {
            this.sessionService = sessionService;
        }

    /*
    @GetMapping("/validateToken")
    public ResponseEntity<UserService> validateToken(@RequestHeader("Authorization") String token) {

        UserService userService = sessionService.validateToken(token);

        if (userService != null) {
            return ResponseEntity.ok(userService);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
     }
    */

}
