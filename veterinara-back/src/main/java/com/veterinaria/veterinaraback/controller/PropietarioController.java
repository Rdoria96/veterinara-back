package com.veterinaria.veterinaraback.controller;

import com.veterinaria.veterinaraback.dto.Paciente;
import com.veterinaria.veterinaraback.dto.Propietario;
import com.veterinaria.veterinaraback.exception.ServicesException;
import com.veterinaria.veterinaraback.mensaje.Mensaje;
import com.veterinaria.veterinaraback.services.PropietarioServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Service
@Transactional
@RestController
@RequestMapping("/api")
public class PropietarioController {
    @Autowired
    private PropietarioServices propietarioServices;

    public PropietarioController(PropietarioServices propietarioServices) {
        this.propietarioServices = propietarioServices;
    }

    @PostMapping("/propietario")
    public ResponseEntity<Mensaje> Create(@Valid @RequestBody Propietario p) throws RuntimeException{
        Mensaje mensaje = new Mensaje();
        try {
            propietarioServices.InsertUpdate(p);
            mensaje.setCode("0");
            mensaje.setMensaje("Propietario creado correctamente");
        }catch (ServicesException ex){
            mensaje.setCode("1");
            mensaje.setMensaje("Error" + ex.getMessage());
            throw  new RuntimeException(ex);
        }
        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/mostrarpropietario")
    public ResponseEntity<Mensaje> getPropietario() throws RuntimeException{
        Mensaje mensaje = new Mensaje();
        List<Map<String,Object>> list;
        try {
            list=propietarioServices.getAll();
            mensaje.setCode("0");
            mensaje.setMensaje("Lista propietarios");
            mensaje.setDato(list);
        }catch (ServicesException ex){
            mensaje.setCode("1");
            mensaje.setMensaje("Error" + ex.getMessage());
            throw new RuntimeException(ex);
        }
        return ResponseEntity.ok(mensaje);
    }

}
