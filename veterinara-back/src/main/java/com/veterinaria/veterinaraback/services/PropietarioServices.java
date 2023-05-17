package com.veterinaria.veterinaraback.services;

import com.veterinaria.veterinaraback.dto.Propietario;
import com.veterinaria.veterinaraback.exception.ServicesException;

import java.util.List;
import java.util.Map;

public interface PropietarioServices {
    public void InsertUpdate(Propietario propietario) throws ServicesException;

    public List<Map<String,Object>> getAll() throws ServicesException;

}
