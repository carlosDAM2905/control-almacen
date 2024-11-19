package com.example.app;

import com.example.dao.AlmacenDAO;
import com.example.dao.EmpleadoDao;
import com.example.dao.ProductoDAO;
import com.example.dao.UbicacionDAO;
import com.example.logic.Logica;
import com.example.ui.Interfaz;

public class App {
    public static void main( String[] args ) {

        AlmacenDAO almacenDAO = new AlmacenDAO();
        EmpleadoDao empleadoDao = new EmpleadoDao();
        ProductoDAO productoDAO = new ProductoDAO();
        UbicacionDAO ubicacionDAO = new UbicacionDAO();

        Logica logica = new Logica(almacenDAO, empleadoDao, productoDAO, ubicacionDAO);
        Interfaz interfaz = new Interfaz(logica);
        interfaz.menu();
    }
}
