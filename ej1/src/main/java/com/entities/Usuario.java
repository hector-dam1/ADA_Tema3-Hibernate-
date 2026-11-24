package com.entities;

import jakarta.persistence.*;

@Entity 
@Table(name = "Usuario")
public class Usuario {
    //datos del usuario
    @Id 
    @Column 
    int id;

    @Id 
    @Column 
    String nombre;
    

}
