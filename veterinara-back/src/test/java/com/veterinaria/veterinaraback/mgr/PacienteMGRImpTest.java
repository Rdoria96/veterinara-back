package com.veterinaria.veterinaraback.mgr;

import com.veterinaria.veterinaraback.dao.PacienteDAO;
import com.veterinaria.veterinaraback.dto.Especie;
import com.veterinaria.veterinaraback.dto.Paciente;
import com.veterinaria.veterinaraback.dto.Propietario;
import com.veterinaria.veterinaraback.exception.DaoException;
import com.veterinaria.veterinaraback.exception.MgrException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static java.sql.Date.valueOf;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PacienteMGRImpTest {

    @Autowired
    private PacienteMGR pacienteMGR;

    @Autowired
    private PacienteDAO pacienteDAO;

    @Test
    @Transactional
    void insert() throws MgrException, DaoException {
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
        pacienteMGR.InsertUpdate(paciente);

        Paciente p = pacienteDAO.GetById(propietario.getNmid());

        if (p == null) {
            pacienteDAO.Insert(paciente);
        } else {
            pacienteDAO.Update(paciente);
        }

    }

    @Test
    @Transactional
    void update() throws MgrException, DaoException {
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
        paciente.setNmid(1);
        pacienteMGR.InsertUpdate(paciente);

        Paciente p = pacienteDAO.GetById(propietario.getNmid());

        if (p == null) {
            pacienteDAO.Insert(paciente);
        } else {
            pacienteDAO.Update(paciente);
        }

    }

    @Test
    void getAll() throws MgrException {
        List<Map<String, Object>> lista = pacienteMGR.getAll();
        assertNotNull(lista);
        assertFalse(lista.isEmpty());

        for (Map<String, Object> item : lista) {
            assertTrue(item.containsKey("nmid"));
            assertTrue(item.containsKey("nombre_paciente"));
            assertTrue(item.containsKey("f_nacimiento"));
            assertTrue(item.containsKey("nmid_especie"));
            assertTrue(item.containsKey("raza"));
            assertTrue(item.containsKey("f_registro"));
            assertTrue(item.containsKey("nmid_propietario"));

            assertNotNull(item.get("nmid"));
            assertNotNull(item.get("nombre_paciente"));
            assertNotNull(item.get("f_nacimiento"));
            assertNotNull(item.get("nmid_especie"));
            assertNotNull(item.get("raza"));
            assertNotNull(item.get("f_registro"));
            assertNotNull(item.get("nmid_propietario"));

            assertTrue(item.get("nmid") instanceof Integer);
            assertTrue(item.get("nombre_paciente") instanceof String);
            assertTrue(item.get("f_nacimiento") instanceof Date);
            assertTrue(item.get("nmid_especie") instanceof Integer);
            assertTrue(item.get("raza") instanceof String);
            assertTrue(item.get("f_registro") instanceof Date);
            assertTrue(item.get("nmid_propietario") instanceof Integer);
        }
    }

    @Test
    void PruebaNegativaLista() throws MgrException{
        //Caso 1: Debe existir registro en la base de datos
        List<Map<String, Object>> lista = pacienteMGR.getAll();
        assertFalse(lista.isEmpty(),"La lista debe tener registro en la base de datos");

    }
}
