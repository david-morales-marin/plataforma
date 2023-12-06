/*package com.example.plataforma.entitys;


import jakarta.persistence.*;

@Entity
@Table(name = "_CountryToUser", schema = "public")
public class _CountryToUser {

    @Id
    @Column(name = "A", nullable = false)
    private String a;

    @Id
    @Column(name = "B", nullable = false)
    private String b;

    @ManyToOne
    @JoinColumn(name = "A", referencedColumnName = "id", insertable = false, updatable = false)
    private Country country;

    @ManyToOne
    @JoinColumn(name = "B", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}*/