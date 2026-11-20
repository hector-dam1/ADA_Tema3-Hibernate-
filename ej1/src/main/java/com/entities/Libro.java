package com.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "libros")
public class Libro {

    @Id 
    @Column 
    int id;

    @Column(length = 20, unique = true)
    String autor;
    
    @Column(length = 30)
    String titulo;
    
    @Column(length = 20, nullable = false)
    String estado;
    
    @Column(nullable = false)
    int n_paginas;

    public int getId() {
        return id;
    }
    public String getAutor() {
        return autor;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getEstado() {
        return estado;
    }
    public int getN_paginas() {
        return n_paginas;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setN_paginas(int n_paginas) {
        this.n_paginas = n_paginas;
    }

    public Libro() {
    }

    public Libro(int id, String autor, String titulo, String estado, int n_paginas) {
        this.id = id;
        this.autor = autor;
        this.titulo = titulo;
        this.estado = estado;
        this.n_paginas = n_paginas;
    }

}

