package com.example.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Entity
@Table(name = "ubicaciones", indexes = {
        @Index(name = "idx_producto", columnList = "id_producto"),
        @Index(name = "idx_almacen", columnList = "id_almacen")
})
public class Ubicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_almacen", nullable = false)
    private Almacen almacen;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Ubicacion() {
    }

    public Ubicacion(Producto producto, Almacen almacen, LocalDate fecha) {
        this.producto = producto;
        this.almacen = almacen;
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Ubicaciones{" +
                "id=" + id +
                ", productoId=" + (producto != null ? producto.getId() : "null") +
                ", almacenId=" + (almacen != null ? almacen.getId() : "null") +
                ", fecha=" + fecha +
                '}';
    }
}