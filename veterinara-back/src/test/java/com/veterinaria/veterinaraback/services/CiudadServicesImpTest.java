package com.veterinaria.veterinaraback.services;


import com.veterinaria.veterinaraback.exception.ServicesException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CiudadServicesImpTest {

    @Autowired
    private CiudadServices ciudadServices;
    @Test
    void mostrarCiudad() throws ServicesException {
        List<Map<String,Object>> lista = ciudadServices.MostrarCiudad();
        assertNotNull(lista);
        assertFalse(lista.isEmpty());

        for (Map<String, Object> item : lista) {
            assertTrue(item.containsKey("nmid"));
            assertTrue(item.containsKey("nombre_ciudad"));

            assertNotNull(item.get("nmid"));
            assertNotNull(item.get("nombre_ciudad"));

            assertTrue(item.get("nmid") instanceof Integer);
            assertTrue(item.get("nombre_ciudad") instanceof String);
        }

    }

    @Test
    void PruebaNegativa() throws ServicesException {
        //Caso 1: Debe existir registro en la base de datos
        List<Map<String, Object>> Lista= ciudadServices.MostrarCiudad();
        assertFalse(Lista.isEmpty(),"La lista debe tener registro en la base de datos");

    }

}