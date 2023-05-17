package com.veterinaria.veterinaraback.mgr;

import com.veterinaria.veterinaraback.dao.PacienteDAO;
import com.veterinaria.veterinaraback.dto.Paciente;
import com.veterinaria.veterinaraback.exception.DaoException;
import com.veterinaria.veterinaraback.exception.MgrException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component
public class PacienteMGRImp implements PacienteMGR{

    private PacienteDAO pacienteDAO;

    public PacienteMGRImp(PacienteDAO pacienteDAO) {
        this.pacienteDAO = pacienteDAO;
    }

    public void InsertUpdate(Paciente paciente) throws MgrException{
        try {
            Paciente paciente1 = pacienteDAO.GetById(paciente.getNmid());
            if (paciente1 == null){
                pacienteDAO.Insert(paciente);
            }else {
                pacienteDAO.Update(paciente);
            }
        }catch (DaoException ex){
            throw new MgrException(ex);
        }
    }

    public List<Map<String,Object>> getAll() throws MgrException{
        List<Map<String,Object>> list;
        try {
            list = pacienteDAO.getAll();
        }catch (DaoException ex){
            throw new MgrException(ex);
        }
      return  list;
    }

}
