package com.example;

import com.example.dao.AlmacenDAO;
import com.example.dao.EmpleadoDao;
import com.example.dao.ProductoDAO;
import com.example.entity.Almacen;
import com.example.entity.Empleado;
import com.example.entity.Producto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ProductosTest {

    @Test
    public void testAgregarProducto() {
        EmpleadoDao empleadoDao = new EmpleadoDao();
        Empleado empleado = empleadoDao.buscarEmpleadoPorId(1001004);

        AlmacenDAO almacenDAO = new AlmacenDAO();
        Almacen almacen = almacenDAO.buscarAlmacenPorId(1);

        if (empleado == null || almacen == null) {
            throw new RuntimeException("Empleado o Almacén no encontrado");
        }

        Producto producto = new Producto();
        producto.setId(1007);
        producto.setFabricante("Bosch");
        producto.setCantidad(200);
        producto.setEmpleado(empleado);

        ProductoDAO productoDAO = new ProductoDAO();
        productoDAO.agregarProducto(producto, almacen);

        Producto productoGuardado = productoDAO.buscarProductoPorId(1007);
        assertNotNull(productoGuardado, "El producto debería haberse guardado correctamente");
    }


    @Test
    public void testEliminarProducto() {
        EmpleadoDao empleadoDao = new EmpleadoDao();
        Empleado empleado = empleadoDao.buscarEmpleadoPorId(1001004);

        AlmacenDAO almacenDAO = new AlmacenDAO();
        Almacen almacen = almacenDAO.buscarAlmacenPorId(1);

        if (empleado == null || almacen == null) {
            throw new RuntimeException("Empleado o Almacén no encontrado");
        }

        Producto producto = new Producto();
        producto.setId(1007);
        producto.setFabricante("Bosch");
        producto.setCantidad(200);
        producto.setEmpleado(empleado);

        ProductoDAO productoDAO = new ProductoDAO();
        productoDAO.agregarProducto(producto, almacen);

        Producto productoGuardado = productoDAO.buscarProductoPorId(1007);
        assertNotNull(productoGuardado, "El producto debería existir antes de eliminarlo");

        productoDAO.eliminarProducto(1007);

        Producto productoEliminado = productoDAO.buscarProductoPorId(1007);
        assertNull(productoEliminado, "El producto debería haber sido eliminado");
    }


    @Test
    public void testMostrarProducto() {
        EmpleadoDao empleadoDao = new EmpleadoDao();
        Empleado empleado = empleadoDao.buscarEmpleadoPorId(1001004);

        AlmacenDAO almacenDAO = new AlmacenDAO();
        Almacen almacen = almacenDAO.buscarAlmacenPorId(1);

        if (empleado == null || almacen == null) {
            throw new RuntimeException("Empleado o Almacén no encontrado");
        }

        Producto producto = new Producto();
        producto.setId(1007);
        producto.setFabricante("Bosch");
        producto.setCantidad(200);
        producto.setEmpleado(empleado);

        ProductoDAO productoDAO = new ProductoDAO();
        productoDAO.agregarProducto(producto, almacen);

        productoDAO.mostrarProducto(1007);

        Producto productoGuardado = productoDAO.buscarProductoPorId(1007);
        assertNotNull(productoGuardado, "El producto debería haberse mostrado correctamente");
    }

}
