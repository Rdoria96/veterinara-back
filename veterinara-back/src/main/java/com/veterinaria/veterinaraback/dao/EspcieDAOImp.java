package com.veterinaria.veterinaraback.dao;

import com.veterinaria.veterinaraback.exception.DaoException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class EspcieDAOImp implements EspecieDAO{
    private JdbcTemplate jdbcTemplate;

    public EspcieDAOImp(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final String SELECT = "SELECT nmid,nombre_especie from especie";

    public List<Map<String,Object>> getAll() throws DaoException{
        List<Map<String,Object>> lista;
        try {
            lista= jdbcTemplate.queryForList(SELECT);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
        return lista;
    }
}
