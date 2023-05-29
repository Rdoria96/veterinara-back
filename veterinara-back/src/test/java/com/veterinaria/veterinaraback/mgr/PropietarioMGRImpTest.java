package com.veterinaria.veterinaraback.mgr;

import com.veterinaria.veterinaraback.dao.PropietarioDAO;
import com.veterinaria.veterinaraback.dto.Ciudad;
import com.veterinaria.veterinaraback.dto.Propietario;
import com.veterinaria.veterinaraback.exception.DaoException;
import com.veterinaria.veterinaraback.exception.MgrException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PropietarioMGRImpTest {
    @Autowired
    private PropietarioMGR propietarioMGR;
    @Autowired
    private PropietarioDAO propietarioDAO;

    @Test
    @Transactional
    void insert() throws MgrException,DaoException{
        Propietario propietario = new Propietario();
        Ciudad ciudad = new Ciudad();

        propietario.setTipo_documento("Cedula ciudadania");
        propietario.setIdent_p("78716184");
        propietario.setNombre_p("Samuel");
        propietario.setApellido_p("Doria");
        ciudad.setNmid(1);
        propietario.setCiudad(ciudad);
        propietario.setTelefono_p("7810939");
        propietarioMGR.InsertUpdate(propietario);


        Propietario p = propietarioDAO.getById(propietario.getNmid());

        if (p == null) {
            propietarioDAO.Insert(propietario);
        } else {
            propietarioDAO.Update(propietario);
        }


    }

    @Test
    @Transactional
    void update() throws MgrException,DaoException{
        Propietario propietario = new Propietario();
        Ciudad ciudad = new Ciudad();

        propietario.setTipo_documento("Cedula ciudadania");
        propietario.setIdent_p("78716184");
        propietario.setNombre_p("Samuel");
        propietario.setApellido_p("Doria");
        ciudad.setNmid(1);
        propietario.setCiudad(ciudad);
        propietario.setTelefono_p("7810939");
        propietario.setNmid(1);
        propietarioMGR.InsertUpdate(propietario);


        Propietario p = propietarioDAO.getById(propietario.getNmid());

        if (p == null) {
            propietarioDAO.Insert(propietario);
        } else {
            propietarioDAO.Update(propietario);
        }


    }

    @Test
    void getAll() throws MgrException {
        List<Map<String, Object>> lista = propietarioMGR.getAll();
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
    void PruebaNegativaLista() throws MgrException{
        //Caso 1: Debe existir registro en la base de datos
        List<Map<String, Object>> lista = propietarioMGR.getAll();
        assertFalse(lista.isEmpty(),"La lista debe tener registro en la base de datos");

    }
}