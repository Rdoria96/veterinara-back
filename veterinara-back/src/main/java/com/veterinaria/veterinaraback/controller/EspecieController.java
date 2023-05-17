package com.veterinaria.veterinaraback.controller;

import com.veterinaria.veterinaraback.exception.CtrlException;
import com.veterinaria.veterinaraback.exception.ServicesException;
import com.veterinaria.veterinaraback.mensaje.Mensaje;
import com.veterinaria.veterinaraback.services.EspecieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Service
@Transactional
@RequestMapping("/api")
@RestController
public class EspecieController {
    @Autowired
    private EspecieServices especieServices;

    public EspecieController(EspecieServices especieServices) {
        this.especieServices = especieServices;
    }

    @GetMapping("especie")
    public ResponseEntity<Mensaje> getEspecie() throws RuntimeException {
        Mensaje mensaje = new Mensaje();
        List<Map<String,Object>> especie;
        try {
            especie = especieServices.getAll();
            mensaje.setCode("0");
            mensaje.setMensaje("Lista especies");
            mensaje.setDato(especie);
        }catch (ServicesException ex){
            mensaje.setDato("1");
            mensaje.setMensaje("Error" + ex.getMessage());
            throw new RuntimeException(ex);
        }
        return ResponseEntity.ok(mensaje);
    }
}
