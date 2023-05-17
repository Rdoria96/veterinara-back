package com.veterinaria.veterinaraback.services;

import com.veterinaria.veterinaraback.dto.Paciente;
import com.veterinaria.veterinaraback.exception.MgrException;
import com.veterinaria.veterinaraback.exception.ServicesException;
import com.veterinaria.veterinaraback.mgr.PacienteMGR;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
@Service
@Transactional
public class PacienteServicesImp implements PacienteService{
    private PacienteMGR pacienteMGR;

    public PacienteServicesImp(PacienteMGR pacienteMGR) {
        this.pacienteMGR = pacienteMGR;
    }

    public void InsertUpdate(Paciente paciente) throws ServicesException {
        try {
          pacienteMGR.InsertUpdate(paciente);
        }catch (MgrException ex){
            throw new ServicesException(ex);
        }catch (Exception ex){
            throw new ServicesException(ex);
        }
    }

    public List<Map<String,Object>> getAll() throws ServicesException{
        List<Map<String,Object>> list;
        try {
            list = pacienteMGR.getAll();
        }catch (MgrException ex){
            throw new ServicesException(ex);
        }
        return  list;
    }
}
