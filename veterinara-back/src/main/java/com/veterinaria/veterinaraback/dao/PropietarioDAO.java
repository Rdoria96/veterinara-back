package com.veterinaria.veterinaraback.dao;

import com.veterinaria.veterinaraback.dto.Propietario;
import com.veterinaria.veterinaraback.exception.DaoException;

import java.util.List;
import java.util.Map;

public interface PropietarioDAO {
    public void Insert(Propietario propietario) throws DaoException;
    public void Update(Propietario propietario) throws DaoException;
    public Propietario getById(int nmid) throws DaoException;
    public List<Map<String,Object>> getAll() throws DaoException;


}
