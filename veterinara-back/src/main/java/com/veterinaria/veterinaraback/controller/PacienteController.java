package com.veterinaria.veterinaraback.controller;

import com.veterinaria.veterinaraback.dto.Paciente;
import com.veterinaria.veterinaraback.exception.ServicesException;
import com.veterinaria.veterinaraback.mensaje.Mensaje;
import com.veterinaria.veterinaraback.services.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Transactional
@Service
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost/80")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping("/paciente")
    public ResponseEntity<Mensaje> Create(@Valid @RequestBody Paciente paciente) throws RuntimeException{
            Mensaje mensaje = new Mensaje();
            try {
                pacienteService.InsertUpdate(paciente);
                mensaje.setCode("0");
                mensaje.setMensaje("Se creo el paciente");
            }catch (ServicesException ex){
                ex.printStackTrace();
                mensaje.setCode("1");
                mensaje.setMensaje("Error" + ex.getMessage());
                throw  new RuntimeException(ex);
            }
            return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/mostrarpaciente")
    public ResponseEntity<Mensaje> getPaciente() throws RuntimeException{
        Mensaje mensaje = new Mensaje();
        List<Map<String,Object>> list;
        try {
            list=pacienteService.getAll();
            mensaje.setCode("0");
            mensaje.setMensaje("Lista paciente");
            mensaje.setDato(list);
        }catch (ServicesException ex){
            mensaje.setCode("1");
            mensaje.setMensaje("Error" + ex.getMessage());
            throw new RuntimeException(ex);
        }
     return ResponseEntity.ok(mensaje);
    }
}
