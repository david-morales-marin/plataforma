package com.example.plataforma.services;


import com.example.plataforma.constantes.Constantes;
import com.example.plataforma.repositorys.CountryRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class CountryService {

    private final JdbcTemplate jdbcTemplate;

    private static final Logger logger = LoggerFactory.getLogger(CountryService.class);


    @Autowired
    public CountryService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Page<Map<String, Object>> getAllCountries(Pageable pageable) {
        try {
            String sql = "SELECT * FROM public.\"Country\"";
            List<Map<String, Object>> countries = jdbcTemplate.query(sql, new CountryRowMapper());

            if (!countries.isEmpty()) {
                int start = (int) pageable.getOffset();
                int end = Math.min((start + pageable.getPageSize()), countries.size());

                return new PageImpl<>(countries.subList(start, end), pageable, countries.size());
            } else {
                return new PageImpl<>(Collections.emptyList(), pageable, 0);
            }

        } catch (Exception e) {
            logger.error("Error al obtener los países, por favor verifique de nuevo", e);
            return new PageImpl<>(Collections.emptyList(), pageable, 0);
        }
    }




}