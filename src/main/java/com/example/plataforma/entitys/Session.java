/*package com.example.plataforma.entitys;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "Session", schema = "public")
public class Session {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "sessionToken", nullable = false)
    private String sessionToken;

    @Column(name = "userId", nullable = false)
    private String userId;

    @Column(name = "expiresAt", nullable = false)
    private Timestamp expiresAt;

    @Column(name = "createdAt", nullable = false)
    private Timestamp createdAt;

    public Session() {
    }

    public Session(String id, String sessionToken, String userId, Timestamp expiresAt, Timestamp createdAt) {
        this.id = id;
        this.sessionToken = sessionToken;
        this.userId = userId;
        this.expiresAt = expiresAt;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Timestamp getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Timestamp expiresAt) {
        this.expiresAt = expiresAt;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
*/