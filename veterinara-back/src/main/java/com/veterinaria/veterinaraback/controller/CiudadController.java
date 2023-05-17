package com.veterinaria.veterinaraback.controller;

import com.veterinaria.veterinaraback.exception.ServicesException;
import com.veterinaria.veterinaraback.mensaje.Mensaje;
import com.veterinaria.veterinaraback.services.CiudadServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@Service
@Transactional
@RequestMapping("/api")
public class CiudadController {
    @Autowired
    private CiudadServices ciudadServices;

    public CiudadController(CiudadServices ciudadServices) {
        this.ciudadServices = ciudadServices;
    }

    @GetMapping("ciudad")
    public ResponseEntity<Mensaje> getCiudad() throws RuntimeException{
        Mensaje mensaje = new Mensaje();
        List<Map<String,Object>> ciudad;
        try {
            ciudad = ciudadServices.MostrarCiudad();
            mensaje.setCode("0");
            mensaje.setMensaje("Lista de ciudades");
            mensaje.setDato(ciudad);
        }catch (ServicesException ex){
            mensaje.setDato("1");
            mensaje.setMensaje("Fallo" + ex.getMessage());
            throw new RuntimeException(ex);
        }
        return ResponseEntity.ok(mensaje);
    }

}
