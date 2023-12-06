package com.example.plataforma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;

@Service
public class SessionService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SessionService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean isTokenValid(String token) {
        String query = "SELECT COUNT(*) FROM public.\"Session\" WHERE \"sessionToken\" = ?";
        int count = jdbcTemplate.queryForObject(query, Integer.class, token);
        return count > 0;
    }

   /* public SessionService validateToken(String token) {
        String query = "SELECT u.id, u.username, u.role FROM Session s " +
                "INNER JOIN User u ON s.userId = u.id " +
                "WHERE s.sessionToken = ?";

        String resultSet = jdbcTemplate.queryForObject(query, String.class, token);

        if (resultSet != null) {
            String userId = resultSet.getUserId("id");
            String username = resultSet.getUsername("username");
            String role = resultSet.getRole("role");


            return null;
        }
    } */

}
