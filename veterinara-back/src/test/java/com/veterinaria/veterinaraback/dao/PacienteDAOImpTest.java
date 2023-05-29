package com.veterinaria.veterinaraback.dao;

import com.veterinaria.veterinaraback.dto.Especie;
import com.veterinaria.veterinaraback.dto.Paciente;
import com.veterinaria.veterinaraback.dto.Propietario;
import com.veterinaria.veterinaraback.exception.DaoException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static java.sql.Date.valueOf;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PacienteDAOImpTest {

    @Autowired
    private PacienteDAO pacienteDAO;

    @Test
    @Transactional
    void insert() throws DaoException {
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
        pacienteDAO.Insert(paciente);

    }

    @Test
    @Transactional
    void update() throws DaoException{
        Paciente paciente = new Paciente();
        Especie especie = new Especie();
        Propietario propietario = new Propietario();

        paciente.setNombre_paciente("Guardian");
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
        pacienteDAO.Update(paciente);


        Paciente p= pacienteDAO.GetById(paciente.getNmid());
        assertNotNull(p);

        assertEquals("Guardian", p.getNombre_paciente());
        assertEquals("2022-01-04", p.getF_nacimiento().toString());
        assertEquals(1, p.getEspecie().getNmid());
        assertEquals("Labrador", p.getRaza());
        assertEquals(LocalDate.now().toString(), p.getF_registro().toString());
        assertEquals(1, p.getPropietario().getNmid());
    }

    @Test
    void getById() throws DaoException{
        int nmid =25;
        Paciente paciente =  pacienteDAO.GetById(nmid);
        assertNotNull(paciente);
        assertEquals(25,paciente.getNmid());
        assertEquals("as", paciente.getNombre_paciente());
        assertEquals("2023-05-04", paciente.getF_nacimiento().toString());
        assertEquals(1, paciente.getEspecie().getNmid());
        assertNotNull(paciente.getEspecie());
        assertEquals("Labrador", paciente.getRaza());
        assertNotNull(paciente.getRaza());
        assertEquals("2023-05-16", paciente.getF_registro().toString());
        assertEquals(24,paciente.getPropietario().getNmid());
        assertNotNull(paciente.getPropietario());
    }

    @Test
    void getAll() throws DaoException {
        List<Map<String, Object>> lista = pacienteDAO.getAll();
        assertNotNull(lista);
        assertFalse(lista.isEmpty());

        for (Map<String, Object> item: lista){
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
    void PruebaNegativaLista() throws DaoException{
        //Caso 1: Debe existir registro en la base de datos
        List<Map<String, Object>> lista = pacienteDAO.getAll();
        assertFalse(lista.isEmpty(),"La lista debe tener registro en la base de datos");
    }
}