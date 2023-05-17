package com.veterinaria.veterinaraback.mgr;

import com.veterinaria.veterinaraback.dao.PropietarioDAO;
import com.veterinaria.veterinaraback.dto.Propietario;
import com.veterinaria.veterinaraback.exception.DaoException;
import com.veterinaria.veterinaraback.exception.MgrException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class PropietarioMGRImp implements PropietarioMGR{
    private PropietarioDAO propietarioDAO;

    public PropietarioMGRImp(PropietarioDAO propietarioDAO) {
        this.propietarioDAO = propietarioDAO;
    }

    public void InsertUpdate(Propietario propietario) throws MgrException {
        try {
            Propietario p = propietarioDAO.getById(propietario.getNmid());
            if (p == null){
                propietarioDAO.Insert(propietario);
            }else {
                propietarioDAO.Update(propietario);
            }
        }catch (DaoException ex){
            throw new MgrException(ex);
        }
    }

    public List<Map<String,Object>> getAll() throws MgrException{
        List<Map<String,Object>> list;
        try {
            list = propietarioDAO.getAll();
        }catch (DaoException ex){
            throw new MgrException(ex);
        }
        return  list;
    }

}
