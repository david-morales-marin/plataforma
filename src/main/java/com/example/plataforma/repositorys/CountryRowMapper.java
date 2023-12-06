package com.example.plataforma.repositorys;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CountryRowMapper implements RowMapper<Map<String, Object>> {
    @Override
    public Map<String, Object> mapRow(ResultSet resultSet, int i) throws SQLException {
        Map<String, Object> country = new HashMap<>();
        country.put("id", resultSet.getString("id"));
        country.put("name", resultSet.getString("name"));
        country.put("createdAt", resultSet.getTimestamp("createdAt"));
        country.put("updatedAt", resultSet.getTimestamp("updatedAt"));
        return country;
    }
}
