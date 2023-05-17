package com.veterinaria.veterinaraback.mapper;

import com.veterinaria.veterinaraback.dto.Especie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class EspcieMapper implements RowMapper<Especie> {
    @Override
    public Especie mapRow(ResultSet rs, int rowNum) throws SQLException {
        Especie especie = new Especie();
        especie.setNmid(rs.getInt("nmid"));
        especie.setNombre_especie(rs.getString("nombre_especie"));
        return especie;
    }
}
