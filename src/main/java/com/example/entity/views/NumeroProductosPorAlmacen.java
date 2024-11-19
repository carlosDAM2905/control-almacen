package com.example.entity.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

import java.math.BigDecimal;

/**
 * Mapping for DB view
 */
@Entity
@Immutable
@Table(name = "numero_productos_por_almacen")
public class NumeroProductosPorAlmacen {
    @Column(name = "id_almacen", nullable = false)
    private Integer idAlmacen;

    @Column(name = "ubicacion", nullable = false, length = 50)
    private String ubicacion;

    @Column(name = "total_productos", precision = 32)
    private BigDecimal totalProductos;

    public Integer getIdAlmacen() {
        return idAlmacen;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public BigDecimal getTotalProductos() {
        return totalProductos;
    }

    protected NumeroProductosPorAlmacen() {
    }
}