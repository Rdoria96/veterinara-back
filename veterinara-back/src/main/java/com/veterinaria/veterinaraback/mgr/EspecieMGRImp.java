package com.veterinaria.veterinaraback.mgr;

import com.veterinaria.veterinaraback.dao.EspecieDAO;
import com.veterinaria.veterinaraback.exception.DaoException;
import com.veterinaria.veterinaraback.exception.MgrException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component
public class EspecieMGRImp implements EspecieMGR {
    private EspecieDAO especieDAO;

    public EspecieMGRImp(EspecieDAO especieDAO) {
        this.especieDAO = especieDAO;
    }

    public List<Map<String,Object>> getAll() throws MgrException {
        List<Map<String,Object>> lista;
        try {
            lista= especieDAO.getAll();
        }catch (DaoException ex){
            throw new MgrException(ex);
        }
        return lista;
    }
}
