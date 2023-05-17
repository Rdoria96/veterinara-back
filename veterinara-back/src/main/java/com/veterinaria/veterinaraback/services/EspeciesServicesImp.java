package com.veterinaria.veterinaraback.services;

import com.veterinaria.veterinaraback.exception.MgrException;
import com.veterinaria.veterinaraback.exception.ServicesException;
import com.veterinaria.veterinaraback.mgr.EspecieMGR;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
@Service
@Transactional
public class EspeciesServicesImp implements EspecieServices{
    private EspecieMGR especieMGR;

    public EspeciesServicesImp(EspecieMGR especieMGR) {
        this.especieMGR = especieMGR;
    }

    public List<Map<String,Object>> getAll() throws ServicesException{
        List<Map<String,Object>> lista;
        try {
            lista = especieMGR.getAll();
        }catch (MgrException ex){
            throw  new ServicesException(ex);
        }
        return lista;
    }
}
