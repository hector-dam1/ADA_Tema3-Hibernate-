package com.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity 
@Table (name = "Conferencia")
public class Conferencia {
    @Id 
    @Column (length = 30)
    private String nombre;

    @Column (nullable = false)
    private Date FechaHoraInicio;

    @Column 
    private String lugar;

    @Column (nullable = false)
    private double numeroHoras;

    @ManyToMany (mappedBy = "conferencias")
    private List<Investigador> investigadores = new ArrayList<>();
    
    public Conferencia() {
    }

    

    public Conferencia(String nombre, Date fechaHoraInicio, String lugar, double numeroHoras) {
        this.nombre = nombre;
        FechaHoraInicio = fechaHoraInicio;
        this.lugar = lugar;
        this.numeroHoras = numeroHoras;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaHoraInicio() {
        return FechaHoraInicio;
    }

    public void setFechaHoraInicio(Date fechaHoraInicio) {
        FechaHoraInicio = fechaHoraInicio;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public double getNumeroHoras() {
        return numeroHoras;
    }

    public void setNumeroHoras(double numeroHoras) {
        this.numeroHoras = numeroHoras;
    }



    public List<Investigador> getInvestigadores() {
        return investigadores;
    }



    public void setInvestigadores(List<Investigador> investigadores) {
        this.investigadores = investigadores;
    }

    
    
}
