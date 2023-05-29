package com.veterinaria.veterinaraback.controller;

import com.veterinaria.veterinaraback.exception.ServicesException;
import com.veterinaria.veterinaraback.mensaje.Mensaje;
import com.veterinaria.veterinaraback.services.CiudadServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CiudadControllerTest {

    @Autowired
    private CiudadServices ciudadServices;

    @Test
    void getCiudad() throws ServicesException {
        CiudadController ciudadController = new CiudadController(ciudadServices);
        ResponseEntity<Mensaje> response = ciudadController.getCiudad();
        Mensaje mensaje = response.getBody();

        assertNotNull(response);
        assertNotNull(mensaje);
        assertEquals("0", mensaje.getCode());
        assertEquals("Lista de ciudades", mensaje.getMensaje());
        assertNotNull(mensaje.getDato());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void PruebaNegativa() throws ServicesException{
        CiudadController ciudadController = new CiudadController(null);
        assertThrows(RuntimeException.class, ciudadController::getCiudad);

    }
}