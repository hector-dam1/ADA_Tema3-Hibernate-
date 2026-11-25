package com.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;

@Embeddable 
class NombreCompleto {

    @Column(length = 30)
    String nombre;
    
    @Column(length = 20)
    String apellido1;

    @Column(length = 20)
    String apellido2;

    

    public NombreCompleto(String nombre, String apellido1, String apellido2) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    public NombreCompleto() {
    }


    public String getNombre() {
        return nombre;
    }
    public String getApellido1() {
        return apellido1;
    }
    public String getApellido2() {
        return apellido2;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    
}

@Entity 
@Table (name = "Usuario")
public class Usuario{
    
    @Id
    @Column
    int id;

    @Embedded 
    private NombreCompleto nombreCompleto;

    @Column(length = 20)
    String ciudad;

    @Column
    double categoria;

    @Column
    Date fecha_ingreso;

    
    public Usuario() {
    }

    public Usuario(int id, NombreCompleto nombreCompleto, String ciudad, double categoria, Date fecha_ingreso) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.ciudad = ciudad;
        this.categoria = categoria;
        this.fecha_ingreso = fecha_ingreso;
    }

    public int getId() {
        return id;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public String getCiudad() {
        return ciudad;
    }

    public double getCategoria() {
        return categoria;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombreCompleto(NombreCompleto nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setCategoria(double categoria) {
        this.categoria = categoria;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }


    
}