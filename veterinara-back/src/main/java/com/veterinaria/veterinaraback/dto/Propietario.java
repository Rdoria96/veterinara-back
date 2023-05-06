package com.veterinaria.veterinaraback.dto;

import lombok.Data;

@Data
public class Propietario {
    private int nmid;
    private String tipo_documento;
    private String ident_p;
    private String nombre_p;
    private String apellido_p;
    private int nmid_ciudad;
    private String telefono;
}
