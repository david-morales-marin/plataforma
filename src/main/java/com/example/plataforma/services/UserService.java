package com.example.plataforma.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private final JdbcTemplate jdbcTemplate;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Page<List<Map<String, Object>>> getAllProjects(Pageable pageable) {

        int pageNumber = pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        int offset = pageNumber * pageSize;

        String sql = "SELECT * FROM public.\"User\" OFFSET ? LIMIT ?";
         try{
        List<Map<String, Object>> userList = jdbcTemplate.queryForList(sql, offset, pageSize);
        int totalUsers = getTotalUserCount();

        return new PageImpl<>(Collections.singletonList(userList), pageable, totalUsers);
           } catch (Exception e) {
                 logger.error("Error al obtener todos los proyectos", e);
    return new PageImpl<>(Collections.emptyList(), pageable, 0);
           }
    }

    public int getTotalUserCount() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM public.\"User\"", Integer.class);
    }

    public Page<Map<String, Object>> getUserByEmail(String email, Pageable pageable) {

        try{
        String countSql = "SELECT COUNT(*) FROM public.\"User\" WHERE email = ?";
        String dataSql = "SELECT * FROM public.\"User\" WHERE email = ? LIMIT ? OFFSET ?";

        int offset = pageable.getPageNumber() * pageable.getPageSize();
        int pageSize = pageable.getPageSize();

        long total = jdbcTemplate.queryForObject(countSql, Long.class, email);
        List<Map<String, Object>> users = jdbcTemplate.queryForList(dataSql, email, pageSize, offset);

        return new PageImpl<>(users, pageable, total);
        } catch (Exception e) {
            logger.error("Error al obtener la informacion de un usuario por email", e);
            return new PageImpl<>(Collections.emptyList(), pageable, 0);
        }
    }

}