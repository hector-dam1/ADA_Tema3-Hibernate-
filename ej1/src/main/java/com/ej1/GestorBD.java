package com.ej1;

import com.entities.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class GestorBD {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("miBD");
    EntityManager em;

    public GestorBD() {
        em = emf.createEntityManager();
    }

    public void crear() {
        em.getTransaction().begin();
        Libro libro = new Libro(1, "Autor1", "Titulo1", "Disponible", 100);
        Libro libro2 = new Libro(2, "Autor2", "Titulo2", "Prestado", 200);
        Libro libro3 = new Libro(3, "Autor3", "Titulo3", "Disponible", 300);
        Libro libro4 = new Libro(4, "Autor4", "Titulo4", "Prestado", 400);
        Libro libro5 = new Libro(5, "Autor5", "Titulo5", "Disponible", 500);
        
        em.persist(libro);
        em.persist(libro2);
        em.persist(libro3);
        em.persist(libro4);
        em.persist(libro5);
        

        em.getTransaction().commit();
    }

    public void cerrar(){
        em.close();
    }

}
