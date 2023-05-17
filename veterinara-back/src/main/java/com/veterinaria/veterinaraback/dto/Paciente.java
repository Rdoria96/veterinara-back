package com.veterinaria.veterinaraback.dto;

import lombok.Data;

import java.util.Date;
@Data
public class Paciente  {
    private int nmid;
    private String nombre_paciente;
    private Date f_nacimiento;
    private Especie especie;
    private String raza;
    private Date f_registro;
    private Propietario propietario;
}
