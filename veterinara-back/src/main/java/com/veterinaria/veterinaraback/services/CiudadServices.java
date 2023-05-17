package com.veterinaria.veterinaraback.services;

import com.veterinaria.veterinaraback.exception.ServicesException;

import java.util.List;
import java.util.Map;

public interface CiudadServices {
    public List<Map<String, Object>> MostrarCiudad() throws ServicesException;
}
