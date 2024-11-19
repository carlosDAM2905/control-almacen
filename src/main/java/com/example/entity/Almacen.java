package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//HECHO
@Entity
@Table(name = "almacenes")
public class Almacen {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "responsable", nullable = false, length = 50)
    private String responsable;

    @Column(name = "ubicacion", nullable = false, length = 50)
    private String ubicacion;

    @Column(name = "capacidad", nullable = false)
    private Double capacidad;

    public Almacen() {
    }

    public Almacen(Integer id, String responsable, String ubicacion, Double capacidad) {
        this.id = id;
        this.responsable = responsable;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Double capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Almacen{" +
                "id=" + id +
                ", responsable='" + responsable + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", capacidad=" + capacidad +
                '}';
    }
}