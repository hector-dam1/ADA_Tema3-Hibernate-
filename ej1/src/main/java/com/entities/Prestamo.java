package com.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Embeddable 
class PrestamoId {
    @Column 
    int id;
    @Column 
    int id_usuario;

    
    public PrestamoId() {
    }

    
    public PrestamoId(int id, int id_usuario) {
        this.id = id;
        this.id_usuario = id_usuario;
    }


    public void setId(int id) {
        this.id = id;
    }
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    public int getId() {
        return id;
    }
    public int getId_usuario() {
        return id_usuario;
    }
}

@Entity 
@Table(name = "Prestamo")
public class Prestamo {
    
    @Id 
    @Embedded
    PrestamoId prestamoId;

    @Column(nullable = false, unique = true)
    LocalDateTime fecha_inicio;
    
    @Column
    LocalDateTime fecha_fin;

    
    public Prestamo() {
    }

    public Prestamo(PrestamoId prestamoId, LocalDateTime fecha_inicio, LocalDateTime fecha_fin) {
        this.prestamoId = prestamoId;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public PrestamoId getPrestamoId() {
        return prestamoId;
    }

    public LocalDateTime getFecha_inicio() {
        return fecha_inicio;
    }

    public LocalDateTime getFecha_fin() {
        return fecha_fin;
    }

    public void setPrestamoId(PrestamoId prestamoId) {
        this.prestamoId = prestamoId;
    }

    public void setFecha_inicio(LocalDateTime fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public void setFecha_fin(LocalDateTime fecha_fin) {
        this.fecha_fin = fecha_fin;
    }


}