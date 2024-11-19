package com.example.entity.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

/**
 * Mapping for DB view
 */
@Entity
@Immutable
@Table(name = "menos_100_unidades")
public class Menos100Unidade {
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "fabricante", nullable = false, length = 50)
    private String fabricante;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    public Integer getId() {
        return id;
    }

    public String getFabricante() {
        return fabricante;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    protected Menos100Unidade() {
    }
}