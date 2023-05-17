package com.veterinaria.veterinaraback.mapper;

import com.veterinaria.veterinaraback.dto.Ciudad;
import com.veterinaria.veterinaraback.dto.Propietario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PropietarioMapper implements RowMapper<Propietario> {
    @Override
    public Propietario mapRow(ResultSet rs, int rowNum) throws SQLException {
        Propietario propietario = new Propietario();
        Ciudad ciudad = new Ciudad();
        propietario.setTipo_documento(rs.getString("tipo_documento"));
        propietario.setIdent_p(rs.getString("ident_p"));
        propietario.setNombre_p(rs.getString("nombre_p"));
        propietario.setApellido_p(rs.getString("apellido_p"));
        ciudad.setNmid(rs.getInt("nmid_ciudad_p"));
        propietario.setCiudad(ciudad);
        propietario.setTelefono_p(rs.getString("telefono_p"));
        return propietario;
    }
}
