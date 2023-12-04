package com.example.plataforma.entitys;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "Session")
public class Session implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authToken;
    private Timestamp expirationTime;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Users user;

}
