package com.veterinaria.veterinaraback.dao;

import com.veterinaria.veterinaraback.dto.Paciente;
import com.veterinaria.veterinaraback.exception.DaoException;

import java.util.List;
import java.util.Map;

public interface PacienteDAO {

    public void Insert(Paciente paciente) throws DaoException;

    public void Update(Paciente paciente) throws DaoException;

    public Paciente GetById(int nmid) throws DaoException;

    public List<Map<String, Object>> getAll() throws DaoException;
}
