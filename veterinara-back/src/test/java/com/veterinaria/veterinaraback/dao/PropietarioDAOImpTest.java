package com.veterinaria.veterinaraback.dao;

import com.veterinaria.veterinaraback.dto.Ciudad;
import com.veterinaria.veterinaraback.dto.Propietario;
import com.veterinaria.veterinaraback.exception.DaoException;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.relational.core.sql.In;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import static org.apache.maven.shared.utils.StringUtils.equalsIgnoreCase;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PropietarioDAOImpTest {

    @Autowired
    private PropietarioDAO propietarioDAO;


    @Test
    @Transactional
    void insert() throws DaoException {
        Propietario propietario = new Propietario();
        Ciudad ciudad = new Ciudad();
        propietario.setTipo_documento("Cedula ciudadania");
                propietario.setIdent_p("1067945746");
                propietario.setNombre_p("Jhon");
                propietario.setApellido_p("Doria");
                ciudad.setNmid(1);
                propietario.setCiudad(ciudad);
                propietario.setTelefono_p("3005801454");
                propietarioDAO.Insert(propietario);

    }

    @Test
    @Transactional
    void update() throws DaoException{
        Propietario propietario = new Propietario();
        Ciudad ciudad = new Ciudad();
        propietario.setTipo_documento("Cedula ciudadania");
        propietario.setIdent_p("1067945746");
        propietario.setNombre_p("Richard David");
        propietario.setApellido_p("Montalvo");
        ciudad.setNmid(1);
        propietario.setCiudad(ciudad);
        propietario.setTelefono_p("3005801454");
        propietario.setNmid(13);
        propietarioDAO.Update(propietario);

      Propietario pro= propietarioDAO.getById(propietario.getNmid());
        assertNotNull(pro);

        assertEquals("Cedula ciudadania", pro.getTipo_documento());
        assertEquals("1067945746", pro.getIdent_p());
        assertEquals("Richard David", pro.getNombre_p());
        assertEquals("Montalvo", pro.getApellido_p());
        assertEquals(1, pro.getCiudad().getNmid());
        assertEquals("3005801454", pro.getTelefono_p());

    }

    @Test
    void getById() throws DaoException {
        int nmid =47;
      Propietario pro =  propietarioDAO.getById(nmid);
      assertNotNull(pro);
      assertEquals(0,pro.getNmid());
      assertEquals("Cedula ciudadania", pro.getTipo_documento());
      assertEquals("1067945746", pro.getIdent_p());
      assertEquals("Richard", pro.getNombre_p());
      assertEquals("Montalvo", pro.getApellido_p());
      assertNotNull(pro.getCiudad());
      assertEquals(1,pro.getCiudad().getNmid());
      assertEquals("3005801454", pro.getTelefono_p());
    }

    @Test
    void getAll() throws DaoException {
        List<Map<String, Object>> lista = propietarioDAO.getAll();
        assertNotNull(lista);
        assertFalse(lista.isEmpty());

        for (Map<String, Object> item: lista){
            assertTrue(item.containsKey("nmid"));
            assertTrue(item.containsKey("tipo_documento"));
            assertTrue(item.containsKey("ident_p"));
            assertTrue(item.containsKey("nombre_p"));
            assertTrue(item.containsKey("apellido_p"));
            assertTrue(item.containsKey("nmid_ciudad_p"));
            assertTrue(item.containsKey("telefono_p"));

            assertNotNull(item.get("nmid"));
            assertNotNull(item.get("tipo_documento"));
            assertNotNull(item.get("ident_p"));
            assertNotNull(item.get("nombre_p"));
            assertNotNull(item.get("apellido_p"));
            assertNotNull(item.get("nmid_ciudad_p"));
            assertNotNull(item.get("telefono_p"));

            assertTrue(item.get("nmid") instanceof Integer);
            assertTrue(item.get("tipo_documento") instanceof String);
            assertTrue(item.get("ident_p") instanceof String);
            assertTrue(item.get("nombre_p") instanceof String);
            assertTrue(item.get("apellido_p") instanceof String);
            assertTrue(item.get("nmid_ciudad_p") instanceof Integer);
            assertTrue(item.get("telefono_p") instanceof String);


        }
    }

    @Test
    void PruebaNegativaLista() throws DaoException{
        //Caso 1: Debe existir registro en la base de datos
        List<Map<String, Object>> lista = propietarioDAO.getAll();
        assertFalse(lista.isEmpty(),"La lista debe tener registro en la base de datos");
    }
}