/*package com.example.plataforma.entitys;


import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "Role", schema = "public")
public class Role {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false)
    private Enum_RoleName name;

    @Column(name = "createdAt", nullable = false)
    private Timestamp createdAt;

    public Role() {
    }

    public Role(String id, Enum_RoleName name, Timestamp createdAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Enum_RoleName getName() {
        return name;
    }

    public void setName(Enum_RoleName name) {
        this.name = name;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}*/

