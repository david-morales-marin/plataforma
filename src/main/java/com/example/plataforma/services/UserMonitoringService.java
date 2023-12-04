package com.example.plataforma.services;

import com.example.plataforma.repositorys.UserMonitoringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMonitoringService {

    @Autowired
    private UserMonitoringRepository userMonitoringRepository;

    public UserMonitoringService(UserMonitoringRepository userMonitoringRepository){
        this.userMonitoringRepository = userMonitoringRepository;
    }

}
