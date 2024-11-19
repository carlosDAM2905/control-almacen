package com.example.dao;

import com.example.entity.Almacen;
import com.example.entity.Empleado;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class AlmacenDAO {
    private static final Logger logger = LoggerFactory.getLogger(AlmacenDAO.class);

    public Almacen buscarAlmacenPorId(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Almacen.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar el almacén con ID: " + id, e);
        }
    }

    public void mostrarAlmacenes() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Almacen> almacenes = session.createQuery("from Almacen").list();

            if (almacenes.isEmpty()) {
                logger.info("No hay almacenes registrados");
            } else {
                logger.info("Almacenes registrados: {}", almacenes.size());

                almacenes.forEach(almacen ->
                        logger.info("ID: {} Responsable: {} Ubicacion: {} Capacidad: {}" , almacen.getId(), almacen.getResponsable(), almacen.getUbicacion(), almacen.getCapacidad()));
            }


        } catch (Exception e) {
            logger.error("Error al mostrar almacenes", e);
        }
    }


}
