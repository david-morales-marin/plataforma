package com.example.plataforma.entitys;

import jakarta.persistence.*;

import java.io.Serializable;
import java.security.Timestamp;

@Entity
@Table(name = "UserMonitoring")
public class UserMonitoring implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String action;
        private Timestamp timestamp;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private Users user;



}

