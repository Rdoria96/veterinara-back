package com.veterinaria.veterinaraback.controller;

import com.veterinaria.veterinaraback.dto.Especie;
import com.veterinaria.veterinaraback.dto.Paciente;
import com.veterinaria.veterinaraback.dto.Propietario;
import com.veterinaria.veterinaraback.exception.CtrlException;
import com.veterinaria.veterinaraback.exception.ServicesException;
import com.veterinaria.veterinaraback.mensaje.Mensaje;
import com.veterinaria.veterinaraback.services.PacienteService;
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
class PacienteControllerTest {

    @Autowired
    private PacienteService pacienteService;

    @Test
    @Transactional
    void create() throws ServicesException {
        PacienteController pacienteController = new PacienteController(pacienteService);
        Paciente paciente = new Paciente();
        Especie especie = new Especie();
        Propietario propietario = new Propietario();

        paciente.setNombre_paciente("Cual");
        LocalDate fechaNacimiento = LocalDate.of(2022, 1, 4);
        paciente.setF_nacimiento(valueOf(fechaNacimiento));
        especie.setNmid(1);
        paciente.setEspecie(especie);
        paciente.setRaza("Labrador");
        LocalDate fechaRegistro = LocalDate.now();
        paciente.setF_registro(valueOf(fechaRegistro));
        propietario.setNmid(1);
        paciente.setPropietario(propietario);
        pacienteService.InsertUpdate(paciente);

        Mensaje mensaje = new Mensaje();
        mensaje.setCode("0");
        mensaje.setMensaje("Se creo el paciente");

        ResponseEntity<Mensaje> response = pacienteController.Create(paciente);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(mensaje.getCode(), response.getBody().getCode());
        assertEquals(mensaje.getMensaje(), response.getBody().getMensaje());

    }

    @Test
    @Transactional
    void actualizar() throws ServicesException {
        PacienteController pacienteController = new PacienteController(pacienteService);
        Paciente paciente = new Paciente();
        Especie especie = new Especie();
        Propietario propietario = new Propietario();

        paciente.setNombre_paciente("Cual");
        LocalDate fechaNacimiento = LocalDate.of(2022, 1, 4);
        paciente.setF_nacimiento(valueOf(fechaNacimiento));
        especie.setNmid(1);
        paciente.setEspecie(especie);
        paciente.setRaza("Labrador");
        LocalDate fechaRegistro = LocalDate.now();
        paciente.setF_registro(valueOf(fechaRegistro));
        propietario.setNmid(1);
        paciente.setPropietario(propietario);
        paciente.setNmid(5);
        pacienteService.InsertUpdate(paciente);

        Mensaje mensaje = new Mensaje();
        mensaje.setCode("0");
        mensaje.setMensaje("Se creo el paciente");

        ResponseEntity<Mensaje> response = pacienteController.Create(paciente);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(mensaje.getCode(), response.getBody().getCode());
        assertEquals(mensaje.getMensaje(), response.getBody().getMensaje());

    }


    @Test
    void getPaciente()throws CtrlException {
        PacienteController pacienteController = new PacienteController(pacienteService);
        ResponseEntity<Mensaje> response = pacienteController.getPaciente();
        Mensaje mensaje = response.getBody();

        assertNotNull(response);
        assertNotNull(mensaje);
        assertEquals("0", mensaje.getCode());
        assertEquals("Lista paciente", mensaje.getMensaje());
        assertNotNull(mensaje.getDato());
    }

    @Test
    void PruebaNegativaLista() throws CtrlException{
        PacienteController pacienteController = new PacienteController(null);
        assertThrows(RuntimeException.class, pacienteController::getPaciente);

    }
}