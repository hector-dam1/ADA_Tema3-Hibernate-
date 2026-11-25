package com.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;


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