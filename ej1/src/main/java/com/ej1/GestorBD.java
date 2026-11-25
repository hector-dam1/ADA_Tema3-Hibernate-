package com.ej1;

import static java.sql.Date.valueOf;

import java.sql.Date;

import com.entities.Libro;
import com.entities.NombreCompleto;
import com.entities.Prestamo;
import com.entities.PrestamoId;
import com.entities.Usuario;

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

        Usuario usuario = new Usuario(1, new NombreCompleto("Nombre1", "Apellido1", "Apellido2"), "Ciudad1", 1.0, valueOf("2020-01-01"));
        Usuario usuario2 = new Usuario(2, new NombreCompleto("Nombre2", "Apellido1", "Apellido2"), "Ciudad2", 2.0, valueOf("2020-02-01"));
        Usuario usuario3 = new Usuario(3, new NombreCompleto("Nombre3", "Apellido1", "Apellido2"), "Ciudad3", 3.0, valueOf("2020-03-01"));
        Usuario usuario4 = new Usuario(4, new NombreCompleto("Nombre4", "Apellido1", "Apellido2"), "Ciudad4", 4.0, valueOf("2020-04-01"));
        Usuario usuario5 = new Usuario(5, new NombreCompleto("Nombre5", "Apellido1", "Apellido2"), "Ciudad5", 5.0, valueOf("2020-05-01"));
        
        em.persist(usuario);
        em.persist(usuario2);
        em.persist(usuario3);
        em.persist(usuario4);
        em.persist(usuario5);

        Prestamo prestamo = new Prestamo(new PrestamoId(libro.getId(), usuario.getId()), valueOf("2020-01-01"), valueOf("2020-02-01"));
        Prestamo prestamo2 = new Prestamo(new PrestamoId(libro2.getId(), usuario2.getId()), valueOf("2020-02-01"), valueOf("2020-03-01"));
        Prestamo prestamo3 = new Prestamo(new PrestamoId(libro3.getId(), usuario3.getId()), valueOf("2020-03-01"), valueOf("2020-04-01"));
        Prestamo prestamo4 = new Prestamo(new PrestamoId(libro4.getId(), usuario4.getId()), valueOf("2020-04-01"), valueOf("2020-05-01"));
        Prestamo prestamo5 = new Prestamo(new PrestamoId(libro5.getId(), usuario5.getId()), valueOf("2020-05-01"), valueOf("2020-06-01"));
        Prestamo prestamo6 = new Prestamo(new PrestamoId(libro.getId(), usuario2.getId()), valueOf("2020-06-01"), valueOf("2020-07-01"));
        Prestamo prestamo7 = new Prestamo(new PrestamoId(libro2.getId(), usuario3.getId()), valueOf("2020-07-01"), valueOf("2020-08-01"));
        Prestamo prestamo8 = new Prestamo(new PrestamoId(libro3.getId(), usuario4.getId()), valueOf("2020-08-01"), valueOf("2020-09-01"));
        Prestamo prestamo9 = new Prestamo(new PrestamoId(libro4.getId(), usuario5.getId()), valueOf("2020-09-01"), valueOf("2020-10-01"));
        Prestamo prestamo10 = new Prestamo(new PrestamoId(libro5.getId(), usuario.getId()), valueOf("2020-10-01"), valueOf("2020-11-01"));

        em.persist(prestamo);
        em.persist(prestamo2);
        em.persist(prestamo3);
        em.persist(prestamo4);
        em.persist(prestamo5);
        em.persist(prestamo6);
        em.persist(prestamo7);
        em.persist(prestamo8);
        em.persist(prestamo9);
        em.persist(prestamo10);

        em.getTransaction().commit();
    }

    public void modifiarLibro(int id, String estado) {
        em.getTransaction().begin();
        Libro libro = em.find(Libro.class, id);
        libro.setEstado(estado);
        em.getTransaction().commit();
    }

    //Aumenta un 25% la categoría del usuario con el id=3.
    public void aumentarCategoriaUsuario(int id){
        em.getTransaction().begin();
        Usuario usuario = em.find(Usuario.class, id);
        usuario.setCategoria(usuario.getCategoria() * 1.25 );
        em.getTransaction().commit();
    }

    //Modifica la fecha_fin de un préstamo.
    public void modificarFechaFin(int id_libro, int id_usuario, Date nevaFecha){
        em.getTransaction().begin();
        PrestamoId pId = new PrestamoId(id_libro, id_usuario);
        Prestamo prestamo = em.find(Prestamo.class, pId);
        prestamo.setFecha_fin(nevaFecha);
        em.getTransaction().commit();
    }

    //Elimina todas al usuario con id=5 y todos sus préstamos asociados.
    public void EliminarUsuario(int idUsu){
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Prestamo p WHERE p.prestamoId.id_usuario = :idUsu")
        .setParameter("idUsu", idUsu).executeUpdate();
        Usuario usuario = em.find(Usuario.class, idUsu);
        if(usuario != null){
            em.remove(usuario);
        }
        em.getTransaction().commit();
    }

    public void EliminarPrestamo(int idUsu){
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Prestamo p WHERE p.prestamoId.id_usuario = :idUsu")
        .setParameter("idUsu", idUsu).executeUpdate();
        em.getTransaction().commit();
    }

    public void cerrar(){
        em.close();
    }

}
