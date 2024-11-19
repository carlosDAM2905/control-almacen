package com.example.dao;

import com.example.entity.Empleado;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Stream;

public class EmpleadoDao {

    private static final Logger logger = LoggerFactory.getLogger(EmpleadoDao.class);

    public void insertarEmpleado(Empleado empleado) {


        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();

            session.persist(empleado);
            transaction.commit();
            logger.info("Empleado insertado con éxito: {}", empleado);

        } catch (Exception e) {
            logger.error("Error al insertar el empleado ", e);
        }
    }

    public void eliminarEmpleado(int idEmpleado) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            Empleado empleado = session.get(Empleado.class, idEmpleado);

            if (empleado != null) {
                session.remove(empleado);
                transaction.commit();
                logger.info("Empleado eliminado con exito: {}", empleado);
            } else {
                logger.info("No existe el empleado: {}", idEmpleado);
                System.out.println("El empleado con ID " + idEmpleado + " no existe");
            }

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            logger.error("Error al eliminar el empleado ", e);
        }
    }

    public Empleado buscarEmpleadoPorId(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Empleado.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar el empleado con ID: " + id, e);
        }
    }

    public void mostrarEmpleadosAlmacen(int idAlmacen) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            List<Empleado> empleados = session.createQuery("FROM Empleado e WHERE e.almacen.id = :idAlmacen", Empleado.class).setParameter("idAlmacen", idAlmacen).list();

            if (empleados.isEmpty()) {
                logger.info("No existe hay empleados registrados");
            } else {
                logger.info("Número de empleados almacén {}: {}", idAlmacen, empleados.size());
                empleados.forEach(empleado -> System.out.println(empleado));
            }
        } catch (Exception e) {
            logger.error("Error al mostrar el empleado ", e);

        }
    }


    public void mostrarEmpleados() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            List<Empleado> empleados = session.createQuery("from Empleado", Empleado.class).list();

            if (empleados.isEmpty()) {
                logger.info("No hay empleados registrados");
                return;
            }

            logger.info("número de empleados registrados: {}", empleados.size());

            empleados.forEach(empleado -> {
                System.out.println("ID: " + empleado.getId());
                System.out.println("Categoría: " + empleado.getCategoria());
                System.out.println("Puesto: " + empleado.getPuesto());
                System.out.println("Almacén ID: " + (empleado.getAlmacen() != null ? empleado.getAlmacen().getId() : "Sin asignar"));
                System.out.println("\n\n");
            });

        }catch (Exception e) {
            logger.error("Error al mostrar el empleado ", e);
        }
    }
}
