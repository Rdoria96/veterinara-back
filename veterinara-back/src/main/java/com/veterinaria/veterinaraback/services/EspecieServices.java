package com.veterinaria.veterinaraback.services;

import com.veterinaria.veterinaraback.exception.ServicesException;

import java.util.List;
import java.util.Map;

public interface EspecieServices {
    List<Map<String,Object>> getAll() throws ServicesException;
}
