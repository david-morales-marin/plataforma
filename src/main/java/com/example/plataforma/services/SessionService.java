package com.example.plataforma.services;

import com.example.plataforma.repositorys.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository){
        this.sessionRepository = sessionRepository;
    }

}
