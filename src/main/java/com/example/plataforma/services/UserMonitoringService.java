package com.example.plataforma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class UserMonitoringService {
    private final JdbcTemplate jdbcTemplate;

    private static final Logger logger = LoggerFactory.getLogger(UserMonitoringService.class);

    @Autowired
    public UserMonitoringService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Page<Map<String, Object>> getUserMonitoringByEmailAndFechas(
            String email, LocalDateTime startTime, LocalDateTime endTime, Pageable pageable) {

        try {
            String countQuery = "SELECT COUNT(*) FROM public.\"UserMonitoring\" " +
                    "WHERE \"userId\" = (SELECT id FROM public.\"User\" WHERE email = ?) " +
                    "AND \"createdAt\" >= ? " +
                    "AND \"createdAt\" <= ?";

            int total = jdbcTemplate.queryForObject(
                    countQuery,
                    new Object[]{email, Timestamp.valueOf(startTime), Timestamp.valueOf(endTime)},
                    Integer.class
            );

            String dataQuery = "SELECT * FROM public.\"UserMonitoring\" " +
                    "WHERE \"userId\" = (SELECT id FROM public.\"User\" WHERE email = ?) " +
                    "AND \"createdAt\" >= ? " +
                    "AND \"createdAt\" <= ? " +
                    "LIMIT ? OFFSET ?";

            List<Map<String, Object>> userMonitoringData = jdbcTemplate.queryForList(
                    dataQuery,
                    email,
                    Timestamp.valueOf(startTime),
                    Timestamp.valueOf(endTime),
                    pageable.getPageSize(),
                    pageable.getOffset()
            );

            return new PageImpl<>(userMonitoringData, pageable, total);
        } catch (Exception e) {
            logger.error("Error al obtener datos de monitoreo del usuario por correo y rango de tiempo", e);
            return new PageImpl<>(Collections.emptyList(), pageable, 0);
        }

    }

    public Page<Map<String, Object>> getTopThreeUsersXActivity(
            LocalDateTime startTime,
            LocalDateTime endTime,
            Pageable pageable) {

        int pageNumber = pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        int offset = pageNumber * pageSize;
        try{
           String sql = "SELECT \"userId\", COUNT(*) as activityCount FROM public.\"UserMonitoring\" " +
                "WHERE \"createdAt\" >= ? AND \"createdAt\" <= ? " +
                "GROUP BY \"userId\" ORDER BY activityCount DESC LIMIT ? OFFSET ?";

           List<Map<String, Object>> users = jdbcTemplate.queryForList(
                sql, Timestamp.valueOf(startTime), Timestamp.valueOf(endTime), pageSize, offset);

        String countSql = "SELECT COUNT(DISTINCT \"userId\") FROM public.\"UserMonitoring\" " +
                "WHERE \"createdAt\" >= ? AND \"createdAt\" <= ?";
        int totalUsers = jdbcTemplate.queryForObject(countSql, Integer.class, startTime, endTime);

        return new PageImpl<>(users, pageable, totalUsers);
  } catch (Exception e) {
      logger.error("Error al llamar la peticion, por favor intente de nuevo", e);
      return new PageImpl<>(Collections.emptyList(), pageable, 0);
         }
    }

    public Page<Map<String, Object>> getTopUsersByUsageTypeAndCountry(
            String usageType,
            String countryId,
            LocalDateTime startTime,
            LocalDateTime endTime,
            Pageable pageable) {
         try{
        String sql = "SELECT um.*, c.* " +
                "FROM UserMonitoring um " +
                "INNER JOIN Country c ON um.country_id = c.id " +
                "WHERE um.description = ? AND um.country_id = ? AND um.created_at BETWEEN ? AND ?";

        List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql, usageType, countryId, startTime, endTime);

        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;

        List<Map<String, Object>> paginatedList;
        if (resultList.size() < startItem) {
            paginatedList = List.of();
        } else {
            int toIndex = Math.min(startItem + pageSize, resultList.size());
            paginatedList = resultList.subList(startItem, toIndex);
        }

        return new PageImpl<>(paginatedList, pageable, resultList.size());
          } catch (Exception e) {
             logger.error("Error al obtener datos de monitoreo del usuario por correo y rango de tiempo", e);
               return new PageImpl<>(Collections.emptyList(), pageable, 0);
             }
          }

}
