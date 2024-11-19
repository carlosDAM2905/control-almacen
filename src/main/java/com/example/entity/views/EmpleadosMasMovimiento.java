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
@Table(name = "empleados_mas_movimientos")
public class EmpleadosMasMovimiento {
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "categoria", nullable = false, length = 50)
    private String categoria;

    @Column(name = "puesto", nullable = false, length = 50)
    private String puesto;

    @Column(name = "total_productos", precision = 32)
    private BigDecimal totalProductos;

    public Integer getId() {
        return id;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getPuesto() {
        return puesto;
    }

    public BigDecimal getTotalProductos() {
        return totalProductos;
    }

    protected EmpleadosMasMovimiento() {
    }
}