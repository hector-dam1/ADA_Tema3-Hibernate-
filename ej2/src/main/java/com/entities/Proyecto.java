package com.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity 
@Table (name = "Proyecto")
public class Proyecto {

    @Id 
    @Column (length = 30)
    private String nombre;

    @Column (nullable = false)
    private Date fecha_inicio;

    @OneToMany (mappedBy = "proyecto", cascade = CascadeType.PERSIST)
    private List<Investigador> investigadores = new ArrayList<>();


    public Proyecto() {
    }
    
    public Proyecto(String nombre, Date fecha_inicio) {
        this.nombre = nombre;
        this.fecha_inicio = fecha_inicio;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Date getFecha_inicio() {
        return fecha_inicio;
    }
    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public List<Investigador> getInvestigadores() {
        return investigadores;
    }
    public void setInvestigador(List<Investigador> investigadores) {
        this.investigadores = investigadores;
    }
}
