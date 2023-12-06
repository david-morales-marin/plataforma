package com.example.plataforma.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.example.plataforma.repositorys.CountryRowMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;

@JdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CountryServiceTest {

    @MockBean
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testGetAllCountries() {
        CountryService countryService = new CountryService(jdbcTemplate);

        Pageable pageable = PageRequest.of(0, 10, Sort.by("id").ascending());

        List<Map<String, Object>> countries = Arrays.asList(
                Collections.singletonMap("id", 1),
                Collections.singletonMap("id", 2),
                Collections.singletonMap("id", 3)
        );
        when(jdbcTemplate.query(anyString(), any(CountryRowMapper.class))).thenReturn(countries);

        Page<Map<String, Object>> result = countryService.getAllCountries(pageable);

        assertEquals(3, result.getTotalElements());
        assertEquals(3, result.getContent().size());
        assertEquals(1, result.getContent().get(0).get("id"));
        assertEquals(2, result.getContent().get(1).get("id"));
        assertEquals(3, result.getContent().get(2).get("id"));
    }
}
