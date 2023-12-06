package com.example.plataforma.controllers;

import com.example.plataforma.services.UserMonitoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;

@RestController()
@RequestMapping("/v1/userMonitoring")
public class UserMonitoringController {

    private final UserMonitoringService userMonitoringService;

    @Autowired
    public UserMonitoringController(UserMonitoringService userMonitoringService) {
        this.userMonitoringService = userMonitoringService;
    }

    @GetMapping("/user/{email}/{iniFech}/{finfech}")
    public ResponseEntity<Page<Map<String, Object>>>  getUserMonitoringByEmailAndFechas(
            @PathVariable String email,
            @DateTimeFormat(pattern = "dd-MM-yyyy") @PathVariable LocalDate iniFech,
            @DateTimeFormat(pattern = "dd-MM-yyyy") @PathVariable LocalDate finfech,
            Pageable pageable) {

        LocalDateTime FechaInicio = iniFech.atStartOfDay();
        LocalDateTime FechaFin = finfech.atStartOfDay().plusDays(1);

        Page<Map<String, Object>> userMonitoring = userMonitoringService
                .getUserMonitoringByEmailAndFechas(email, FechaInicio, FechaFin, pageable);

        return ResponseEntity.ok(userMonitoring);
    }

    @GetMapping("/topUsers/{iniFech}/{finFech}")
    public ResponseEntity<Page<Map<String, Object>>> getTopUsersXActivity(
            @DateTimeFormat(pattern = "dd-MM-yyyy") @PathVariable LocalDate iniFech,
            @DateTimeFormat(pattern = "dd-MM-yyyy") @PathVariable LocalDate finFech,
            @PageableDefault(size = 10, page = 0) Pageable pageable) {

        LocalDateTime FechaInicio = iniFech.atStartOfDay();
        LocalDateTime FechaFin = finFech.atStartOfDay().plusDays(1);

        Page<Map<String, Object>> topUsersPage = userMonitoringService.getTopThreeUsersXActivity(FechaInicio, FechaFin, pageable);

        return ResponseEntity.ok(topUsersPage);
    }

    @GetMapping("/topUsersByUsageType/{usageType}/{country_Id}/{iniFech}/{finFech}")
    public ResponseEntity<Page<Map<String, Object>>> getTopUsersByUsageTypeAndCountry(
            @PathVariable String usageType,
            @PathVariable String country_Id,
            @DateTimeFormat(pattern = "dd-MM-yyyy") @PathVariable LocalDate iniFech,
            @DateTimeFormat(pattern = "dd-MM-yyyy") @PathVariable LocalDate finFech,
            @PageableDefault(size = 10, page = 0) Pageable pageable) {

        LocalDateTime FechaInicio = iniFech.atStartOfDay();
        LocalDateTime FechaFin = finFech.atStartOfDay().plusDays(1);

        Page<Map<String, Object>> topUsersPage = userMonitoringService.getTopUsersByUsageTypeAndCountry(
                usageType, country_Id, FechaInicio, FechaFin, pageable);

        return ResponseEntity.ok(topUsersPage);
    }

}