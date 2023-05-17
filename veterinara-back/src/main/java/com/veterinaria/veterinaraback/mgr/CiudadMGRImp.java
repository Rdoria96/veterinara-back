package com.veterinaria.veterinaraback.mgr;

import com.veterinaria.veterinaraback.dao.CiudadDAO;
import com.veterinaria.veterinaraback.exception.DaoException;
import com.veterinaria.veterinaraback.exception.MgrException;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;
@Component
public class CiudadMGRImp implements CiudadMGR{

    private CiudadDAO ciudadDAO;
    public CiudadMGRImp(CiudadDAO ciudadDAO){
        this.ciudadDAO = ciudadDAO;
    }

    public List<Map<String, Object>> getAll() throws MgrException {
        List<Map<String, Object>> lista;
        try {
            lista = ciudadDAO.getAll();
        }catch (DaoException ex){
            throw new MgrException(ex);
        }
        return lista;
    }
}
