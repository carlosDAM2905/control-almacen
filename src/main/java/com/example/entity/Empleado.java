package com.example.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

//HECHO

@Entity
@Table(name = "empleados", indexes = {
        @Index(name = "id_almacen", columnList = "id_almacen")
})
public class Empleado {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "categoria", nullable = false, length = 50)
    private String categoria;

    @Column(name = "puesto", nullable = false, length = 50)
    private String puesto;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_almacen")
    private Almacen almacen;

    public Empleado() {
    }

    public Empleado(Integer id, String categoria, String puesto, Almacen almacen) {
        this.id = id;
        this.categoria = categoria;
        this.puesto = puesto;
        this.almacen = almacen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", categoria='" + categoria + '\'' +
                ", puesto='" + puesto + '\'' +
                ", almacenId=" + (almacen != null ? almacen.getId() : "null") +
                '}';
    }
}