package com.example;

import com.example.dao.EmpleadoDao;
import com.example.entity.Almacen;
import com.example.entity.Empleado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class EmpleadosTest {

    @Test
    public void testInsertarEmpleado() {

        EmpleadoDao empleadoDao = new EmpleadoDao();
        Empleado empleado = new Empleado();

        Almacen almacen = new Almacen();
        almacen.setCapacidad(200.0);
        almacen.setId(2);
        almacen.setResponsable("Carlos Gómez");
        almacen.setUbicacion("PLAST");

        empleado.setId(1001004);
        empleado.setCategoria("Capataz");
        empleado.setPuesto("Supervisor");
        empleado.setAlmacen(almacen);

        empleadoDao.insertarEmpleado(empleado);


        Empleado empleadoRecuperado = empleadoDao.buscarEmpleadoPorId(empleado.getId());
        System.out.println("Empleado recuperado: " + empleadoRecuperado);


        assertNotNull(empleadoRecuperado, "El empleado no fue insertado correctamente en la base de datos");

        assertEquals(empleado.getId(), empleadoRecuperado.getId(), "El ID del empleado no coincide");

        assertEquals(empleado.getCategoria(), empleadoRecuperado.getCategoria(), "La categoría del empleado no coincide");

        assertEquals(empleado.getPuesto(), empleadoRecuperado.getPuesto(), "El puesto del empleado no coincide");

        assertNotNull(empleadoRecuperado.getAlmacen(), "El almacén asociado no fue correctamente asignado");

        assertEquals(almacen.getId(), empleadoRecuperado.getAlmacen().getId(), "El ID del almacén no coincide");

    }

    @Test
    public void testEliminarEmpleado() {
        EmpleadoDao empleadoDao = new EmpleadoDao();
        Empleado empleado = new Empleado();

        Almacen almacen = new Almacen();
        almacen.setCapacidad(200.0);
        almacen.setId(2);
        almacen.setResponsable("Carlos Gómez");
        almacen.setUbicacion("PLAST");

        empleado.setId(1001004);
        empleado.setCategoria("Capataz");
        empleado.setPuesto("Supervisor");
        empleado.setAlmacen(almacen);

        empleadoDao.insertarEmpleado(empleado);
        empleadoDao.eliminarEmpleado(empleado.getId());


    }
    @Test
    public void testMostrarEmpleadosAlmacen() {
        EmpleadoDao empleadoDao = new EmpleadoDao();
        empleadoDao.mostrarEmpleadosAlmacen(2);
    }

    @Test
    public void testMostrarTodosEmpleados() {
        EmpleadoDao empleadoDao = new EmpleadoDao();
        empleadoDao.mostrarEmpleados();
    }
}
