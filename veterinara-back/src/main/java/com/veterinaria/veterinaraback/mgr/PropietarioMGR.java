package com.veterinaria.veterinaraback.mgr;

import com.veterinaria.veterinaraback.dto.Propietario;
import com.veterinaria.veterinaraback.exception.MgrException;

import java.util.List;
import java.util.Map;

public interface PropietarioMGR {

    public void InsertUpdate(Propietario propietario) throws MgrException;

    public List<Map<String,Object>> getAll() throws MgrException;

}
