package com.veterinaria.veterinaraback.controller;

import com.veterinaria.veterinaraback.exception.ServicesException;
import com.veterinaria.veterinaraback.mensaje.Mensaje;
import com.veterinaria.veterinaraback.services.EspecieServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EspecieControllerTest {

    @Autowired
    private EspecieServices especieServices;

    @Test
    void getEspecie() throws ServicesException {
        EspecieController especieController = new EspecieController(especieServices);
        ResponseEntity<Mensaje> response = especieController.getEspecie();
        Mensaje mensaje = response.getBody();

        assertNotNull(response);
        assertNotNull(mensaje);
        assertEquals("0", mensaje.getCode());
        assertEquals("Lista especies", mensaje.getMensaje());
        assertNotNull(mensaje.getDato());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void PruebaNegativa() throws ServicesException {
        EspecieController especieController = new EspecieController(null);
        assertThrows(RuntimeException.class, especieController::getEspecie);
    }

}