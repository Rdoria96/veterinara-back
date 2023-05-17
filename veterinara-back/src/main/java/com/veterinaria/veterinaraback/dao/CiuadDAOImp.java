package com.veterinaria.veterinaraback.dao;
import com.veterinaria.veterinaraback.exception.DaoException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class CiuadDAOImp implements CiudadDAO{
    private JdbcTemplate jdbcTemplate;

    public CiuadDAOImp(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final String SELECT="SELECT nmid, nombre_ciudad\n" +
            "\tFROM ciudad";

    public List<Map<String, Object>> getAll() throws DaoException{
        List<Map<String, Object>> lista;
        try {
            lista = jdbcTemplate.queryForList(SELECT);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
        return lista;
    }
}
