package com.example.plataforma.controllers;

import com.example.plataforma.services.UserMonitoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/v1/userMonitoring")
public class UserMonitoringController {

    @Autowired
    private UserMonitoringService userMonitoringService;

}