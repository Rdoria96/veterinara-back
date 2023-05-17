package com.veterinaria.veterinaraback.dao;

import com.veterinaria.veterinaraback.dto.Propietario;
import com.veterinaria.veterinaraback.exception.DaoException;
import com.veterinaria.veterinaraback.mapper.PropietarioMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class PropietarioDAOImp implements PropietarioDAO {

    private JdbcTemplate jdbcTemplate;

    public PropietarioDAOImp(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final String INSERT ="INSERT INTO propietario (tipo_documento, ident_p, nombre_p,\n" +
            "       apellido_p, nmid_ciudad_p, telefono_p)\n" +
            "\t   VALUES (?,?,?,?,?,?)";

    private static final String UPDATE ="UPDATE propietario\n" +
            "\tSET tipo_documento=?, ident_p=?, nombre_p=?, apellido_p=?, nmid_ciudad_p=?, telefono_p=?\n" +
            "\t WHERE nmid=?";

    private static final String SELECT = "SELECT p.nmid, p.tipo_documento, p.ident_p, p.nombre_p,\n" +
            "       p.apellido_p, p.nmid_ciudad_p, p.telefono_p,c.nombre_ciudad\n" +
            "\t   FROM propietario p INNER JOIN ciudad c ON p.nmid_ciudad_p = c.nmid ORDER BY nmid ASC";

    private static final String SELECTBYID = "SELECT nmid,tipo_documento,ident_p,nombre_p,apellido_p,nmid_ciudad_p, telefono_p FROM propietario WHERE nmid=? ";

    public void Insert(Propietario propietario) throws DaoException{
        try {
            jdbcTemplate.update(INSERT,
                    propietario.getTipo_documento(),
                    propietario.getIdent_p(),
                    propietario.getNombre_p(),
                    propietario.getApellido_p(),
                    propietario.getCiudad().getNmid(),
                    propietario.getTelefono_p());
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }

    public void Update(Propietario propietario) throws DaoException{
        try {
             jdbcTemplate.update(UPDATE,
                     propietario.getTipo_documento(),
                     propietario.getIdent_p(),
                     propietario.getNombre_p(),
                     propietario.getApellido_p(),
                     propietario.getCiudad().getNmid(),
                     propietario.getTelefono_p(),
                     propietario.getNmid());
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }

    public Propietario getById(int nmid) throws DaoException{
        Propietario propietario = null;
        try {
           propietario = jdbcTemplate.queryForObject(SELECTBYID, new PropietarioMapper(), nmid);
        }catch (EmptyResultDataAccessException ex){
        }catch (Exception ex){
            throw new DaoException(ex);
        }
        return propietario;
    }

    public List<Map<String,Object>> getAll() throws DaoException{
        List<Map<String,Object>> Lista;
        try {
            Lista = jdbcTemplate.queryForList(SELECT);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
        return Lista;
    }
}
