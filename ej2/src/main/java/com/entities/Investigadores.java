package com.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "Investigadores")
public class Investigadores {

    @Id 
    @Column (length = 9)
    private int DNI;

    @Embedded
    private NombreCompleto nombre;
    
    @Column 
    private String direccion;
    
    @Column (length = 9)
    private int telefono;
    
    @Column 
    private String ciudad;
    
    
    public Investigadores() {
    }

    public Investigadores(int dNI, NombreCompleto nombre, String direccion, int telefono, String ciudad) {
        DNI = dNI;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ciudad = ciudad;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int dNI) {
        DNI = dNI;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    
    
}
