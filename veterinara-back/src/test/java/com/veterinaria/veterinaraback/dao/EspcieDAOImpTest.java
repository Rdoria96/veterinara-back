package com.veterinaria.veterinaraback.dao;

import com.veterinaria.veterinaraback.exception.DaoException;
import com.veterinaria.veterinaraback.mensaje.Mensaje;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EspcieDAOImpTest {

    @Autowired
    private EspecieDAO especieDAO;

    @Test
    void getAll() throws DaoException {
        List<Map<String, Object>> listaEspecie = especieDAO.getAll();
        assertNotNull(listaEspecie);
        assertFalse(listaEspecie.isEmpty());

        for(Map<String, Object> item: listaEspecie){
            assertTrue(item.containsKey("nmid"));
            assertTrue(item.containsKey("nombre_especie"));

            assertNotNull(item.get("nmid"));
            assertNotNull(item.get("nombre_especie"));

            assertTrue(item.get("nmid") instanceof  Integer);
            assertTrue(item.get("nombre_especie") instanceof String);
        }
    }

    @Test
    void PruebaNegativa() throws DaoException{
        //Caso 1: Verificamos que exista registro en la base de datos
        List<Map<String, Object>> listaEspecie = especieDAO.getAll();
        assertFalse(listaEspecie.isEmpty(), "La lista debe contener registro en la base de datos");
    }
}