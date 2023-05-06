package com.veterinaria.veterinaraback.mapper;

import com.veterinaria.veterinaraback.dto.Ciudad;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CiudadMapper implements RowMapper<Ciudad> {
    @Override
    public Ciudad mapRow(ResultSet rs, int rowNum) throws SQLException {
       Ciudad ciudad = new Ciudad();
       ciudad.setNmid(rs.getInt("nmid"));
       ciudad.setNombre_ciudad(rs.getString("nombre_ciudad"));
        return ciudad;
    }
}
