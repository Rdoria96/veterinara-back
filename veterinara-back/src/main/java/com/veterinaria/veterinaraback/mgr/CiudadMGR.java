package com.veterinaria.veterinaraback.mgr;

import com.veterinaria.veterinaraback.exception.MgrException;

import java.util.List;
import java.util.Map;

public interface CiudadMGR  {
    public List<Map<String, Object>> getAll() throws MgrException;
}
