package com.veterinaria.veterinaraback.dao;


import com.veterinaria.veterinaraback.exception.DaoException;

import java.util.List;
import java.util.Map;

public interface CiudadDAO {
     List<Map<String, Object>> getAll() throws DaoException;
}
