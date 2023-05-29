package com.veterinaria.veterinaraback.controller;

import com.veterinaria.veterinaraback.dto.Ciudad;
import com.veterinaria.veterinaraback.dto.Especie;
import com.veterinaria.veterinaraback.dto.Paciente;
import com.veterinaria.veterinaraback.dto.Propietario;
import com.veterinaria.veterinaraback.exception.ServicesException;
import com.veterinaria.veterinaraback.mensaje.Mensaje;
import com.veterinaria.veterinaraback.services.PropietarioServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static java.sql.Date.valueOf;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PropietarioControllerTest {
    @Autowired
    private PropietarioServices propietarioServices;

    @Test
    @Transactional
    void create() throws ServicesException {
        PropietarioController propietarioController = new PropietarioController(propietarioServices);
         Propietario propietario = new Propietario();
          Ciudad ciudad = new Ciudad();

          propietario.setTipo_documento("Cedula ciudadania");
          propietario.setIdent_p("78716184");
          propietario.setNombre_p("Samuel");
          propietario.setApellido_p("Doria");
          ciudad.setNmid(1);
          propietario.setCiudad(ciudad);
          propietario.setTelefono_p("7810939");
          propietarioServices.InsertUpdate(propietario);

          Mensaje mensaje = new Mensaje();
          mensaje.setCode("0");
          mensaje.setMensaje("Propietario creado correctamente");

        ResponseEntity<Mensaje> response = propietarioController.Create(propietario);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(mensaje.getCode(), response.getBody().getCode());
        assertEquals(mensaje.getMensaje(), response.getBody().getMensaje());

    }

    @Test
    @Transactional
    void Actulizar() throws ServicesException {
        PropietarioController propietarioController = new PropietarioController(propietarioServices);
        Propietario propietario = new Propietario();
        Ciudad ciudad = new Ciudad();

        propietario.setTipo_documento("Cedula ciudadania");
        propietario.setIdent_p("78716184");
        propietario.setNombre_p("Santiago");
        propietario.setApellido_p("Doria");
        ciudad.setNmid(1);
        propietario.setCiudad(ciudad);
        propietario.setTelefono_p("7810939");
        propietario.setNmid(10);
        propietarioServices.InsertUpdate(propietario);

        Mensaje mensaje = new Mensaje();
        mensaje.setCode("0");
        mensaje.setMensaje("Propietario creado correctamente");

        ResponseEntity<Mensaje> response = propietarioController.Create(propietario);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(mensaje.getCode(), response.getBody().getCode());
        assertEquals(mensaje.getMensaje(), response.getBody().getMensaje());

    }




    @Test
    void getPropietario() throws ServicesException {
        PropietarioController propietarioController = new PropietarioController(propietarioServices);
        ResponseEntity<Mensaje> response = propietarioController.getPropietario();
        Mensaje mensaje = response.getBody();

        assertNotNull(response);
        assertNotNull(mensaje);
        assertEquals("0", mensaje.getCode());
        assertEquals("Lista propietarios", mensaje.getMensaje());
        assertNotNull(mensaje.getDato());

    }

    @Test
    void PruebaNegativa() throws ServicesException{
        PropietarioController propietarioController = new PropietarioController(null);
        assertThrows(RuntimeException.class, propietarioController::getPropietario);

    }
}