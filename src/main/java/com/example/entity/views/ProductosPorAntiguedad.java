package com.example.entity.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

import java.time.LocalDate;

/**
 * Mapping for DB view
 */
@Entity
@Immutable
@Table(name = "productos_por_antiguedad")
public class ProductosPorAntiguedad {
    @Column(name = "fabricante", nullable = false, length = 50)
    private String fabricante;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    public String getFabricante() {
        return fabricante;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    protected ProductosPorAntiguedad() {
    }
}