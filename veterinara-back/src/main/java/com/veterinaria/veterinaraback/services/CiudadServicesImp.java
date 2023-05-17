package com.veterinaria.veterinaraback.services;

import com.veterinaria.veterinaraback.exception.MgrException;
import com.veterinaria.veterinaraback.exception.ServicesException;
import com.veterinaria.veterinaraback.mgr.CiudadMGR;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CiudadServicesImp implements CiudadServices{
    private CiudadMGR ciudadMGR;

    public CiudadServicesImp(CiudadMGR ciudadMGR) {
        this.ciudadMGR = ciudadMGR;
    }

    public List<Map<String, Object>> MostrarCiudad() throws ServicesException{
        List<Map<String, Object>> lista;
        try {
             lista = ciudadMGR.getAll();
        }catch (MgrException ex){
            throw new ServicesException(ex);
        }
        return lista;
    }
}
