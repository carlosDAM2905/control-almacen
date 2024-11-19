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
@Table(name = "inventario_por_fabricante")
public class InventarioPorFabricante {
    @Column(name = "fabricante", nullable = false, length = 50)
    private String fabricante;

    @Column(name = "total_cantidad", precision = 32)
    private BigDecimal totalCantidad;

    public String getFabricante() {
        return fabricante;
    }

    public BigDecimal getTotalCantidad() {
        return totalCantidad;
    }

    protected InventarioPorFabricante() {
    }
}