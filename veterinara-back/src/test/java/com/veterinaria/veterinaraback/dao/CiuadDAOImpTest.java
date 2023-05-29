package com.veterinaria.veterinaraback.dao;

import com.veterinaria.veterinaraback.exception.DaoException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CiuadDAOImpTest {

    @Autowired
    private CiudadDAO ciudadDAO;

    @Test
    void getAll() throws DaoException {
        List<Map<String, Object>> lista = ciudadDAO.getAll();
        assertNotNull(lista);
        assertFalse(lista.isEmpty());

        for (Map<String, Object> item: lista){
            assertTrue(item.containsKey("nmid"));
            assertTrue(item.containsKey("nombre_ciudad"));

            assertNotNull(item.get("nmid"));
            assertNotNull(item.get("nombre_ciudad"));

            assertTrue(item.get("nmid") instanceof Integer);
            assertTrue(item.get("nombre_ciudad") instanceof String);
        }

    }
    @Test
    void PruebaNegativa() throws DaoException {
        // Caso 1: Debe existir registros en la base de datos
        List<Map<String, Object>> lista = ciudadDAO.getAll();
        assertFalse("La lista debe tener registro  en la base de datos", lista.isEmpty());

    }

}