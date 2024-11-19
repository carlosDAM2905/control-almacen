package com.example;

import com.example.dao.AlmacenDAO;
import com.example.entity.Almacen;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AlmacenesTest {
    @Test
    public void testBuscarAlmacenPorId() {
        AlmacenDAO almacenDAO = new AlmacenDAO();
        int idAlmacen = 1;
        Almacen almacen = almacenDAO.buscarAlmacenPorId(idAlmacen);
        assertNotNull(almacen, "El almacen exite");
        assertEquals(idAlmacen, almacen.getId(), "El id del almacen no coincide");
        assertNotNull(almacen.getResponsable(), "El responsable del almacén no debe ser nulo");

    }
}
