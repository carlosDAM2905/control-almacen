package com.example.dao;

import com.example.entity.Ubicacion;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class UbicacionDAO {
    private static final Logger logger = LoggerFactory.getLogger(UbicacionDAO.class);

    public void mostrarUbicacion(int idUbicacion) {

        if (idUbicacion < 0) {
            logger.warn("El id del ubicacion no puede ser negativo: {}", idUbicacion);
        }

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Ubicacion ubicacion = session.get(Ubicacion.class, idUbicacion);

            if (ubicacion != null) {
                logger.info("Ubicación encontrada: ID ubicación: {}, ID Producto: {}, ID almacén: {}, Fecha: {}", idUbicacion, ubicacion.getProducto(), ubicacion.getAlmacen(), ubicacion.getFecha());
            } else {
                logger.info("No se encontró la ubicación: {}", idUbicacion);
            }

        } catch (Exception e) {
            logger.error("Error al mostrar ubicación con ID: {}", idUbicacion, e);
        }

    }

    public void mostrarUbicacionesPorAlmacen(int idAlmacen) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Ubicacion> ubicaciones = session.createQuery(
                            "FROM Ubicacion u WHERE u.almacen.id = :idAlmacen", Ubicacion.class)
                    .setParameter("idAlmacen", idAlmacen)
                    .list();

            if (ubicaciones.isEmpty()) {
                logger.info("No se encontraron ubicaciones para el almacén con ID: {}", idAlmacen);
            } else {
                logger.info("Ubicaciones encontradas para el almacén con ID: {}", idAlmacen);
                ubicaciones.forEach(ubicacion ->
                        logger.info("Ubicación: ID: {}, ID Producto: {}, Fecha: {}",
                                ubicacion.getId(),
                                ubicacion.getProducto().getId(),
                                ubicacion.getFecha()));
            }
        } catch (Exception e) {
            logger.error("Error al buscar ubicaciones para el almacén con ID: {}", idAlmacen, e);
        }
    }

    public void eliminarUbicacion(int idUbicacion) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Ubicacion ubicacion = session.get(Ubicacion.class, idUbicacion);

            if (ubicacion == null) {
                logger.info("No se encontró la ubicación con ID: {}", idUbicacion);
                return;
            }

            Transaction transaction = session.beginTransaction();
            session.remove(ubicacion);
            transaction.commit();
            logger.info("Ubicación con ID: {} eliminada con éxito", idUbicacion);
        } catch (Exception e) {
            logger.error("Error al eliminar la ubicación con ID: {}", idUbicacion, e);
        }
    }

    public void mostrarTodasLasUbicaciones() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Ubicacion> ubicaciones = session.createQuery("FROM Ubicacion", Ubicacion.class).list();

            if (ubicaciones.isEmpty()) {
                logger.info("No hay ubicaciones registradas");
            } else {
                logger.info("Total de ubicaciones: {}", ubicaciones.size());
                ubicaciones.forEach(ubicacion ->
                        logger.info("Ubicación: ID: {}, ID Producto: {}, ID Almacén: {}, Fecha: {}",
                                ubicacion.getId(),
                                ubicacion.getProducto().getId(),
                                ubicacion.getAlmacen().getId(),
                                ubicacion.getFecha()));
            }
        } catch (Exception e) {
            logger.error("Error al mostrar todas las ubicaciones", e);
        }
    }

}
