package com.example.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "productos", indexes = {
        @Index(name = "id_empleado", columnList = "id_empleado")
})
public class Producto {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "fabricante", nullable = false, length = 50)
    private String fabricante;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    public Producto() {
    }

    public Producto(Integer id, String fabricante, Integer cantidad, Empleado empleado) {
        this.id = id;
        this.fabricante = fabricante;
        this.cantidad = cantidad;
        this.empleado = empleado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", fabricante='" + fabricante + '\'' +
                ", cantidad=" + cantidad +
                ", empleadoId=" + (empleado != null ? empleado.getId() : "null") +
                '}';
    }
}