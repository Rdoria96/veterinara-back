package com.veterinaria.veterinaraback.mapper;

import com.veterinaria.veterinaraback.dto.Especie;
import com.veterinaria.veterinaraback.dto.Paciente;
import com.veterinaria.veterinaraback.dto.Propietario;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PacienteMapper implements RowMapper<Paciente> {
    @Override
    public Paciente mapRow(ResultSet rs, int rowNum) throws SQLException {
        Paciente paciente = new Paciente();
        paciente.setNmid(rs.getInt("nmid"));
        paciente.setNombre_paciente(rs.getString("nombre_paciente"));
        paciente.setF_nacimiento(rs.getDate("f_nacimiento"));
        paciente.setRaza(rs.getString("raza"));
        paciente.setF_registro(rs.getDate("f_registro"));
        Especie especie = new Especie();
        especie.setNmid(rs.getInt("nmid_especie"));
        paciente.setEspecie(especie);
        Propietario propietario = new Propietario();
        propietario.setNmid(rs.getInt("nmid_propietario"));
        paciente.setPropietario(propietario);

        return paciente;
    }
}
