package com.veterinaria.veterinaraback.mgr;

import com.veterinaria.veterinaraback.exception.DaoException;
import com.veterinaria.veterinaraback.exception.MgrException;

import java.util.List;
import java.util.Map;

public interface EspecieMGR {

    List<Map<String,Object>> getAll() throws MgrException;
}
