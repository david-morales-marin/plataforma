/* package com.example.plataforma.entitys;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "UserMonitoring", schema = "public")
public class UserMonitoring {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "usage", nullable = false)
    private int usage;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "userId", nullable = false)
    private String userId;

    @Column(name = "createdAt", nullable = false)
    private Timestamp createdAt;

    public UserMonitoring() {
    }

    public UserMonitoring(String id, int usage, String description, String userId, Timestamp createdAt) {
        this.id = id;
        this.usage = usage;
        this.description = description;
        this.userId = userId;
        this.createdAt = createdAt;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUsage() {
        return usage;
    }

    public void setUsage(int usage) {
        this.usage = usage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}*/

