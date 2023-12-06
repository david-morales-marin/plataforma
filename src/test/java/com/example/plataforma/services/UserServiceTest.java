package com.example.plataforma.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
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
public class UserServiceTest {

    @MockBean
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testGetUserByEmail() {
        UserService userService = new UserService(jdbcTemplate);

        String email = "john.hernandez@test.com";
        Pageable pageable = PageRequest.of(0, 10, Sort.by("id").ascending());

        when(jdbcTemplate.queryForObject(anyString(), eq(Long.class), anyString())).thenReturn(1L);
        when(jdbcTemplate.queryForList(anyString(), eq(email), anyInt(), anyInt()))
                .thenReturn(Collections.singletonList(Collections.singletonMap("id", 1)));

        Page<Map<String, Object>> result = userService.getUserByEmail(email, pageable);

        assertEquals(1, result.getTotalElements());
        assertEquals(1, result.getContent().size());
        assertEquals(1, result.getContent().get(0).get("id"));
    }
}
