package com.veterinaria.veterinaraback.services;

import com.veterinaria.veterinaraback.dto.Propietario;
import com.veterinaria.veterinaraback.exception.MgrException;
import com.veterinaria.veterinaraback.exception.ServicesException;
import com.veterinaria.veterinaraback.mgr.PropietarioMGR;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PropietarioServicesImp implements PropietarioServices{

    private PropietarioMGR propietarioMGR;

    public PropietarioServicesImp(PropietarioMGR propietarioMGR) {
        this.propietarioMGR = propietarioMGR;
    }

    public void InsertUpdate(Propietario propietario) throws ServicesException {
        try {
            propietarioMGR.InsertUpdate(propietario);
        }catch (MgrException ex){
            throw new ServicesException(ex);
        }catch (Exception ex){
            throw new ServicesException(ex);
        }
    }

    public List<Map<String,Object>> getAll() throws ServicesException{
        List<Map<String,Object>> list;
        try {
            list = propietarioMGR.getAll();
        }catch (MgrException ex){
            throw new ServicesException(ex);
        }
        return  list;
    }
}
