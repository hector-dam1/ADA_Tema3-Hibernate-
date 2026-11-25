package com.entities;

import jakarta.persistence.Embeddable;

@Embeddable 
public class PrestamoId { 
    int id_libro;
    int id_usuario;

    
    public PrestamoId() {
    }

    
    public PrestamoId(int id_libro, int id_usuario) {
        this.id_libro = id_libro;
        this.id_usuario = id_usuario;
    }


    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    public int getId_libro() {
        return id_libro;
    }
    public int getId_usuario() {
        return id_usuario;
    }
}