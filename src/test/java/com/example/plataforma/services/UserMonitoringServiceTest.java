package com.example.plataforma.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.*;
import org.springframework.jdbc.core.JdbcTemplate;

@JdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserMonitoringServiceTest {

    @MockBean
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testGetUserMonitoringByEmailAndTimeRange() {
        UserMonitoringService userMonitoringService = new UserMonitoringService(jdbcTemplate);

        LocalDateTime startTime = LocalDateTime.of(2023, 1, 1, 0, 0);
        LocalDateTime endTime = LocalDateTime.of(2023, 12, 31, 23, 59);

        Pageable pageable = PageRequest.of(0, 10, Sort.by("createdAt").ascending());

        int expectedTotal = 20;
        List<Map<String, Object>> monitoringData = Arrays.asList(
                Collections.singletonMap("id", 1),
                Collections.singletonMap("id", 2),
                Collections.singletonMap("id", 3)
        );

        when(jdbcTemplate.queryForObject(anyString(), any(Object[].class), eq(Integer.class))).thenReturn(expectedTotal);
        when(jdbcTemplate.queryForList(anyString(), any(Object[].class))).thenReturn(monitoringData);

        Page<Map<String, Object>> result = userMonitoringService.getUserMonitoringByEmailAndFechas("john.hernandez@test.com", startTime, endTime, pageable);

        assertEquals(expectedTotal, result.getTotalElements());
        assertEquals(3, result.getContent().size());
        assertEquals(1, result.getContent().get(0).get("id"));
        assertEquals(2, result.getContent().get(1).get("id"));
        assertEquals(3, result.getContent().get(2).get("id"));
    }


    @Test
    public void testGetTopUsersByUsageTypeAndCountry() {
        UserMonitoringService userMonitoringService = new UserMonitoringService(jdbcTemplate);

        LocalDateTime startTime = LocalDateTime.of(2023, 1, 1, 0, 0);
        LocalDateTime endTime = LocalDateTime.of(2023, 12, 31, 23, 59);
        String usageType = "print";
        String countryId = "cl8x4en4f0033lk55q7awvrcy";

        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Order.asc("createdAt")));

        List<Map<String, Object>> simulatedResult = Arrays.asList(
                Collections.singletonMap("userId", 1),
                Collections.singletonMap("userId", 2),
                Collections.singletonMap("userId", 3)

        );

        when(jdbcTemplate.queryForList(anyString(), any(Object[].class))).thenReturn(simulatedResult);


        Page<Map<String, Object>> result = userMonitoringService.getTopUsersByUsageTypeAndCountry(
                usageType, countryId, startTime, endTime, pageable);

        assertEquals(3, result.getContent().size());
    }
}
