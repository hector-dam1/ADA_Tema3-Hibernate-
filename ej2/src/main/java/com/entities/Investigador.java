package com.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "Investigador")
public class Investigador {

    @Id 
    @Column (length = 9)
    private String DNI;

    @Embedded
    private NombreCompleto nombre;
    
    @Column 
    private String direccion;
    
    @Column
    private int telefono;
    
    @Column 
    private String localidad;
    
    @ManyToOne 
    @JoinColumn (name = "nombreProyecto", nullable = false)
    private Proyecto proyecto;
    

    @ManyToMany (fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Conferencia> conferencias = new ArrayList<>();
    
    public Investigador() {
    } 

    public Investigador(String dNI, NombreCompleto nombre, String direccion, int telefono, String localidad,
            Proyecto proyecto) {
        DNI = dNI;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.localidad = localidad;
        this.proyecto = proyecto;
    }



    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        DNI = DNI;
    }

    public NombreCompleto getNombre() {
        return nombre;
    }

    public void setNombre(NombreCompleto nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public List<Conferencia> getConferencias() {
        return conferencias;
    }

    public void setConferencias(List<Conferencia> conferencias) {
        this.conferencias = conferencias;
    }

    
    
    
}
