package com.veterinaria.veterinaraback.dao;

import com.veterinaria.veterinaraback.dto.Ciudad;
import com.veterinaria.veterinaraback.exception.DaoException;

import java.util.List;
import java.util.Map;

public interface CiudadDAO {
    public Ciudad getByID(int nmid) throws DaoException;
    public List<Map<String, Object>> getAll() throws DaoException;
}
