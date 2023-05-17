package com.veterinaria.veterinaraback.services;

import com.veterinaria.veterinaraback.dto.Paciente;
import com.veterinaria.veterinaraback.exception.ServicesException;

import java.util.List;
import java.util.Map;

public interface PacienteService {
    public void InsertUpdate(Paciente paciente) throws ServicesException;
    public List<Map<String,Object>> getAll() throws ServicesException;
}
