package com.example.plataforma.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
public class Users implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String username;
        private String email;

        private int cel;

        @OneToMany(mappedBy = "user")
        @JsonIgnore
        private List<UserMonitoring> userMonitorings;

        @ManyToMany
        @JoinTable(name = "Country",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "country_id"))
        private List<Country> countries;

        @Enumerated(EnumType.STRING)
        private Role role;

        @OneToOne(mappedBy = "user")
        private Session session;



    }


