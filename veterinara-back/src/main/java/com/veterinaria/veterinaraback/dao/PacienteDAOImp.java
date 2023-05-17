package com.veterinaria.veterinaraback.dao;

import com.veterinaria.veterinaraback.dto.Paciente;
import com.veterinaria.veterinaraback.exception.DaoException;
import com.veterinaria.veterinaraback.mapper.PacienteMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class PacienteDAOImp implements PacienteDAO{
    private JdbcTemplate jdbcTemplate;

    public PacienteDAOImp(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final String INSERT="INSERT INTO paciente(nombre_paciente, f_nacimiento, nmid_especie, raza, f_registro, nmid_propietario) " +
            "VALUES (?, ?, ?, ?, ?, ?)";

    private static final String UPDATE="UPDATE paciente\n" +
            "\tSET nombre_paciente=?, f_nacimiento=?, nmid_especie=?, raza=?, f_registro=?, nmid_propietario=?\n" +
            "\tWHERE nmid=?";

    private static  final String SELECT ="SELECT p.nmid,p.nombre_paciente,p.f_nacimiento,p.nmid_especie,p.raza,p.f_registro,p.nmid_propietario,e.nombre_especie,pr.ident_p FROM \n" +
            "paciente p INNER JOIN especie e ON p.nmid_especie = e.nmid\n" +
            "INNER JOIN propietario pr ON p.nmid_propietario = pr.nmid ORDER BY nmid ASC ";

    private static final String SELECTBYID = "SELECT nmid,nombre_paciente,f_nacimiento,nmid_especie,raza,f_registro,nmid_propietario FROM paciente WHERE nmid=?";

    public void Insert(Paciente paciente) throws DaoException{
        jdbcTemplate.update(INSERT,
                  paciente.getNombre_paciente(),
                  paciente.getF_nacimiento(),
                  paciente.getEspecie().getNmid(),
                  paciente.getRaza(),
                  paciente.getF_registro(),
                  paciente.getPropietario().getNmid());
    }

    public void Update(Paciente paciente) throws DaoException{
        jdbcTemplate.update(UPDATE,
                paciente.getNombre_paciente(),
                paciente.getF_nacimiento(),
                paciente.getEspecie().getNmid(),
                paciente.getRaza(),
                paciente.getF_registro(),
                paciente.getPropietario().getNmid(),
                paciente.getNmid());
    }

    public Paciente GetById(int nmid) throws DaoException{
        Paciente paciente = null;
        try {
            paciente = jdbcTemplate.queryForObject(SELECTBYID,new PacienteMapper(), nmid);
        }catch (EmptyResultDataAccessException ex){
        }catch (Exception ex){
            throw new DaoException(ex);
        }
        return paciente;
    }

    public List<Map<String, Object>> getAll() throws DaoException{
        List<Map<String, Object>> Lista;
        try {
            Lista = jdbcTemplate.queryForList(SELECT);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
        return Lista;
    }

}
