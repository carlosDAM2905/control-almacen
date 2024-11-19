package com.example.logic;

import com.example.dao.AlmacenDAO;
import com.example.dao.EmpleadoDao;
import com.example.dao.ProductoDAO;
import com.example.dao.UbicacionDAO;
import com.example.entity.Almacen;
import com.example.entity.Empleado;
import com.example.entity.Producto;
import com.example.entity.Ubicacion;

import java.time.LocalDate;

public class Logica {
    private final AlmacenDAO almacenDao;
    private final EmpleadoDao empleadoDao;
    private final ProductoDAO productoDao;
    private final UbicacionDAO ubicacionDao;

    public Logica(AlmacenDAO almacenDao, EmpleadoDao empleadoDao, ProductoDAO productoDao,  UbicacionDAO ubicacionDao) {
        this.almacenDao = almacenDao;
        this.empleadoDao = empleadoDao;
        this.productoDao = productoDao;
        this.ubicacionDao = ubicacionDao;
    }



    public void altaEmpleado(int id, String categoria, String puesto, int idAlmacen) {

        Almacen almacen = almacenDao.buscarAlmacenPorId(idAlmacen);
        if (almacen == null) {
            throw new RuntimeException("El almacén con ID " + idAlmacen + " no existe.");
        }


        Empleado empleado = new Empleado();
        empleado.setId(id);
        empleado.setCategoria(categoria);
        empleado.setPuesto(puesto);
        empleado.setAlmacen(almacen);

        empleadoDao.insertarEmpleado(empleado);
    }

    public void bajaEmpleado(int id) {
        Empleado empleado = empleadoDao.buscarEmpleadoPorId(id);
        if (empleado == null) {
            throw new RuntimeException("El empleado con ID " + id + " no existe.");
        }
        empleadoDao.eliminarEmpleado(id);
    }

    public void mostrarEmpleadoPorId(int idEmpleado) {
        empleadoDao.buscarEmpleadoPorId(idEmpleado);
    }

    public void mostrarEmpleadosAlmacen(int idAlmacen) {
        Almacen almacen = almacenDao.buscarAlmacenPorId(idAlmacen);
        if (almacen == null) {
            throw new RuntimeException("El empleado con ID " + idAlmacen + " no existe.");
        }
        empleadoDao.mostrarEmpleadosAlmacen(idAlmacen);
    }

    public void mostrarTodosLosEmpleados() {
        empleadoDao.mostrarEmpleados();
    }

    public void mostrarAlmacenPorId(int idAlmacen) {
        almacenDao.buscarAlmacenPorId(idAlmacen);
    }

    public void mostrarTotalAlmacenes() {
        almacenDao.mostrarAlmacenes();
    }

    public void altaProducto(int id, String fabricante, int cantidad, int idEmpleado, int idAlmacen) {

        // Verificar si el empleado existe
        Empleado empleado = empleadoDao.buscarEmpleadoPorId(idEmpleado);
        if (empleado == null) {
            throw new RuntimeException("El empleado con ID " + idEmpleado + " no existe.");
        }

        // Verificar si el almacén existe
        Almacen almacen = almacenDao.buscarAlmacenPorId(idAlmacen);
        if (almacen == null) {
            throw new RuntimeException("El almacén con ID " + idAlmacen + " no existe.");
        }

        // Crear el producto
        Producto producto = new Producto();
        producto.setId(id);
        producto.setFabricante(fabricante);
        producto.setCantidad(cantidad);
        producto.setEmpleado(empleado);

        // Agregar el producto utilizando ProductoDAO
        productoDao.agregarProducto(producto, almacen);
    }


    public void bajaProducto(int id) {
        Producto producto = productoDao.buscarProductoPorId(id);
        if (producto == null) {
            throw new RuntimeException("El producto con ID " + id + " no existe.");
        }
        productoDao.eliminarProducto(id);
    }

    public void mostrarProductoPorId(int id) {
        productoDao.mostrarProducto(id);
    }

    public void mostrarUbicacionPorId(int id) {
        ubicacionDao.mostrarUbicacion(id);
    }



    public void mostrarUbicacionesPorAlmacen(int idAlmacen) {
        Almacen almacen = almacenDao.buscarAlmacenPorId(idAlmacen);
        if (almacen == null) {
            throw new RuntimeException("El almacen con ID " + idAlmacen + " no existe.");
        }
        ubicacionDao.mostrarUbicacionesPorAlmacen(idAlmacen);
    }

    public void mostrarTodasLasUbicaciones() {
        ubicacionDao.mostrarTodasLasUbicaciones();
    }
}
