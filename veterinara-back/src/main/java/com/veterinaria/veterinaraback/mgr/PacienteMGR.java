package com.veterinaria.veterinaraback.mgr;

import com.veterinaria.veterinaraback.dto.Paciente;
import com.veterinaria.veterinaraback.exception.MgrException;

import java.util.List;
import java.util.Map;

public interface PacienteMGR {
    public void InsertUpdate(Paciente paciente) throws MgrException;
    public List<Map<String,Object>> getAll() throws MgrException;
}
