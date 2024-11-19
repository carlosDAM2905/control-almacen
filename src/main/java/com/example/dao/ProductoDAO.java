package com.example.dao;

import com.example.entity.Almacen;
import com.example.entity.Empleado;
import com.example.entity.Producto;
import com.example.entity.Ubicacion;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class ProductoDAO {

    private static final Logger logger = LoggerFactory.getLogger(ProductoDAO.class);

    public void agregarProducto(Producto producto, Almacen almacen) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();


            session.persist(producto);


            Ubicacion ubicacion = new Ubicacion(producto, almacen, LocalDate.now());
            session.persist(ubicacion);

            transaction.commit();
            logger.info("Producto insertado con éxito: {}", producto);
            logger.info("Ubicación registrada con éxito: Producto ID: {}, Almacén ID: {}, Fecha: {}",
                    producto.getId(), almacen.getId(), LocalDate.now());

        } catch (Exception e) {
            logger.error("Error al insertar producto o registrar ubicación", e);
        }
    }

    public void eliminarProducto(int idProducto) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            Producto producto = session.get(Producto.class, idProducto);

            if (producto != null) {
                session.remove(producto);
                transaction.commit();
                logger.info("Producto eliminado con éxito: {}", producto);
            } else {
                logger.info("No se puede eliminar el producto: {}", idProducto);
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error al eliminar producto", e);
        }
    }

    public Producto buscarProductoPorId(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Producto.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar el producto con ID: " + id, e);
        }
    }

    public void mostrarProducto(int idProducto) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Producto producto = session.get(Producto.class, idProducto);

            if (producto != null) {
                logger.info("Producto encontrado: ID: {}, Fabricante: {}, Cantidad: {} ", producto.getId(), producto.getFabricante(), producto.getCantidad());
            } else {
                logger.info("No se encontró el producto: {}", idProducto);
            }
        } catch (Exception e) {
            logger.error("Error al mostrar producto ", e);
        }
    }


}
