package com.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity 
@Table(name = "Prestamo")
public class Prestamo {
    
    @EmbeddedId 
    PrestamoId prestamoId;

    @Column(nullable = false, unique = true)
    Date fecha_inicio;
    
    @Column
    Date fecha_fin;

    
    public Prestamo() {
    }

    public Prestamo(PrestamoId prestamoId, Date fecha_inicio, Date fecha_fin) {
        this.prestamoId = prestamoId;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public PrestamoId getPrestamoId() {
        return prestamoId;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setPrestamoId(PrestamoId prestamoId) {
        this.prestamoId = prestamoId;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }


}