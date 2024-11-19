package com.example.ui;

import com.example.dao.AlmacenDAO;
import com.example.dao.EmpleadoDao;
import com.example.dao.ProductoDAO;
import com.example.dao.UbicacionDAO;
import com.example.logic.Logica;
import org.hibernate.event.spi.SaveOrUpdateEvent;

import java.util.Scanner;

public class Interfaz {

    private final Logica logica;

    public Interfaz(Logica logica) {
        this.logica = logica;
    }

    public void menu() {
        Scanner teclado = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("======================\nGESTIÓN DE ALMACÉN\n======================");
            System.out.println("0.  SALIR DEL PROGRAMA");
            System.out.println("1.  ALTA EMPLEADO");
            System.out.println("2.  BAJA EMPLEADO");
            System.out.println("3.  BUSCAR EMPLEADO POR ID");
            System.out.println("4.  MOSTRAR EMPLEADOS DE UN ALMACEN CONCRETO");
            System.out.println("5.  MOSTRAR TODOS LOS EMPLEADOS");
            System.out.println("============================================");
            System.out.println("6.  MOSTRAR ALMACEN POR SU ID"); //AÚN NO FUNCIONA
            System.out.println("7.  MOSTRAR TODOS LOS ALMACENES");
            System.out.println("============================================");
            System.out.println("8.  AGREGAR PRODUCTO");
            System.out.println("9.  ELIMINAR PRODUCTO");
            System.out.println("10. MOSTRAR PRODUCTO POR ID");
            System.out.println("============================================");
            System.out.println("11. MOSTRAR UBICACION POR ID");
            System.out.println("12. MOSTRAR UBICACIONES POR ID ALMACEN");
            System.out.println("13. MOSTRAR TODAS LAS UBICACIONES");
            System.out.println("INTRODUCE UNA OPCION");

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Introduce ID del empleado:");
                    int idEmpleado = teclado.nextInt();
                    teclado.nextLine();
                    System.out.println("Introduce categoría:");
                    String categoria = teclado.nextLine();
                    System.out.println("Introduce puesto:");
                    String puesto = teclado.nextLine();
                    System.out.println("Introduce ID del almacén:");
                    int idAlmacen = teclado.nextInt();
                    teclado.nextLine();

                    logica.altaEmpleado(idEmpleado, categoria, puesto, idAlmacen);
                    break;

                case 2:
                    System.out.println("Introduce el ID del empleado a dar de baja:");
                    idEmpleado = teclado.nextInt();
                    teclado.nextLine();
                    logica.bajaEmpleado(idEmpleado);
                    break;

                case 3: //REVISAR NO FUNCIONA AÚN
                    System.out.println("Introduce el ID del empleado a buscar:");
                    idEmpleado = teclado.nextInt();
                    teclado.nextLine();
                    logica.mostrarEmpleadoPorId(idEmpleado);
                    break;

                case 4:
                    System.out.println("Introduce el ID del almacén");
                    idAlmacen = teclado.nextInt();
                    teclado.nextLine();
                    logica.mostrarEmpleadosAlmacen(idAlmacen);
                    break;

                case 5:
                    logica.mostrarTodosLosEmpleados();
                    break;

                case 6:
                    System.out.println("Introduce el ID del almacén");
                    idAlmacen = teclado.nextInt();
                    teclado.nextLine();
                    logica.mostrarAlmacenPorId(idAlmacen);
                    break;

                case 7:
                    logica.mostrarTotalAlmacenes();
                    break;

                case 8:
                    try {
                        System.out.println("Introduce ID del producto");
                        int idProducto = teclado.nextInt();
                        teclado.nextLine();
                        System.out.println("Introduce nombre del fabricante");
                        String fabricante = teclado.nextLine();
                        System.out.println("Introduce cantidad");
                        int cantidad = teclado.nextInt();
                        teclado.nextLine();
                        System.out.println("Introduce ID del empleado");
                        int empleado = teclado.nextInt();
                        teclado.nextLine();
                        System.out.println("Introduce ID del almacén");
                        int idAlmacen5 = teclado.nextInt();
                        teclado.nextLine();

                        logica.altaProducto(idProducto, fabricante, cantidad, empleado, idAlmacen5);
                        System.out.println("Producto agregado correctamente.");
                    } catch (RuntimeException e) {
                        System.out.println("Error al agregar el producto: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Error inesperado: " + e.getMessage());
                    }
                    break;



                case 9:
                    System.out.println("Introduce el ID del producto");
                    int idProducto2 = teclado.nextInt();
                    teclado.nextLine();
                    logica.bajaProducto(idProducto2);
                    break;

                case 10:
                    System.out.println("Introduce el ID del producto");
                    int idProducto3 = teclado.nextInt();
                    teclado.nextLine();
                    logica.mostrarProductoPorId(idProducto3);
                    break;

                case 11:
                    System.out.println("Introduce el ID de la ubicación"); //REVISAR
                    int idUbicacion = teclado.nextInt();
                    teclado.nextLine();
                    logica.mostrarUbicacionPorId(idUbicacion);

                case 12:
                    System.out.println("Introduce el ID del almacén");
                    int idAlmacen2 = teclado.nextInt();
                    teclado.nextLine();
                    logica.mostrarUbicacionPorId(idAlmacen2);
                    break;

                case 13:
                    logica.mostrarTodasLasUbicaciones();
                    break;

                case 0:
                    System.out.println("¡HASTA PRONTO!");

            }

        } while (opcion != 0);
        teclado.close();

    }
}
