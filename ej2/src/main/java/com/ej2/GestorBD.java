package com.ej2;

import static java.sql.Date.valueOf;

import java.util.List;

import com.entities.Conferencia;
import com.entities.Investigador;
import com.entities.NombreCompleto;
import com.entities.Proyecto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class GestorBD {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("miBD_EJ2");
    EntityManager em;

    public GestorBD(){
        em = emf.createEntityManager();
    }

    public void datos(){
        Proyecto proyecto1 = new Proyecto("Proyecto 1", valueOf("2020-5-5"));
        Proyecto proyecto2 = new Proyecto("Proyecto 2", valueOf("2020-6-12"));
        Proyecto proyecto3 = new Proyecto("Proyecto 3", valueOf("2020-7-15"));
        Proyecto proyecto4 = new Proyecto("Proyecto 4", valueOf("2020-11-1"));
        Proyecto proyecto5 = new Proyecto("Proyecto 5", valueOf("2020-12-12"));
   
        NombreCompleto nc1 = new NombreCompleto("Juan ","Pérez ","Martínez");
        NombreCompleto nc2 = new NombreCompleto("Luisa ","Puertas ","Soto");
        NombreCompleto nc3 = new NombreCompleto("María ","Ruiz ","Sánchez");
        NombreCompleto nc4 = new NombreCompleto("Pablo ","Fernández ","Feria");
        NombreCompleto nc5 = new NombreCompleto("Sofía ","Luque ","Conde");
        NombreCompleto nc6 = new NombreCompleto("José ","López","");
        NombreCompleto nc7 = new NombreCompleto("Andrés ","Fernán ","Noria");
        NombreCompleto nc8 = new NombreCompleto("Sofía ","Martín ","Luz");

        Investigador investigador1 = new Investigador("30487452M", nc1, "C./ Desengaño 21", 623423523, "Cádiz", proyecto1);
        Investigador investigador2 = new Investigador("45768434R", nc2, "C./ Falsa 123", 693543252, "Cádiz", proyecto2);
        Investigador investigador3 = new Investigador("45642323B", nc3, "C./ Almiel 12", 623234523, "Cádiz", proyecto3);
        Investigador investigador4 = new Investigador("67534312A", nc4, "Avd. Inventada 15", 613442323, "Cádiz", proyecto2);
        Investigador investigador5 = new Investigador("65342316R", nc5, "C/ La Virtud 1", 664123623, "Cádiz", proyecto1);
        Investigador investigador6 = new Investigador("67323452B", nc6, "C./ Almiel 15", 723234523, "Cádiz", proyecto4);
        Investigador investigador7 = new Investigador("78953321A", nc7, "Avd. Inventada 11", 713442323, "Cádiz", proyecto3);
        Investigador investigador8 = new Investigador("98634571R", nc8, "C/ La Virtud 4", 764123623, "Cádiz", proyecto4);

        Conferencia conferencia1 = new Conferencia("Conferencia 1", valueOf("2020-11-2"), "San Fernando", 2.5);
        Conferencia conferencia2 = new Conferencia("Conferencia 2", valueOf("2021-1-12"), "Sevilla", 4);
        Conferencia conferencia3 = new Conferencia("Conferencia 3", valueOf("2021-7-1"), "San Fernando", 1.5);
        Conferencia conferencia4 = new Conferencia("Conferencia 4", valueOf("2021-11-2"), "Berlín", 3);
        Conferencia conferencia5 = new Conferencia("Conferencia5", valueOf("2021-12-5"), "Madrid", 3.5);

        investigador2.getConferencias().add(conferencia1);
        investigador3.getConferencias().add(conferencia1);
        investigador4.getConferencias().add(conferencia1);
        investigador5.getConferencias().add(conferencia1);

        investigador1.getConferencias().add(conferencia2);
        investigador3.getConferencias().add(conferencia2);
        investigador5.getConferencias().add(conferencia2);

        investigador2.getConferencias().add(conferencia3);
        investigador3.getConferencias().add(conferencia3);
        investigador5.getConferencias().add(conferencia3);

        investigador3.getConferencias().add(conferencia4);
        investigador5.getConferencias().add(conferencia4);

        investigador2.getConferencias().add(conferencia5);
        investigador3.getConferencias().add(conferencia5);
        investigador4.getConferencias().add(conferencia5);

        em.getTransaction().begin();
        em.persist(proyecto1);
        em.persist(proyecto2);
        em.persist(proyecto3);
        em.persist(proyecto4);
        em.persist(proyecto5);

        em.persist(investigador1);
        em.persist(investigador2);
        em.persist(investigador3);
        em.persist(investigador4);
        em.persist(investigador5);
        em.persist(investigador6);
        em.persist(investigador7);
        em.persist(investigador8);

        em.persist(conferencia1);
        em.persist(conferencia2);
        em.persist(conferencia3);
        em.persist(conferencia4);
        em.persist(conferencia5);
        em.getTransaction().commit();
    }

    public void mostrarDatos() {
        // 1.1. Los proyectos en los que trabaja cada investigador (Relación ManyToOne)
        System.out.println("--- 1.1 PROYECTOS DE CADA INVESTIGADOR ---");
        List<Investigador> investigadores = em.createQuery("SELECT i FROM Investigador i", Investigador.class).getResultList();
        for (Investigador inv : investigadores) {
            System.out.println(inv.getNombre().getNombre() + " (" + inv.getDNI() + ") -> " + inv.getProyecto().getNombre());
        }

        // 1.2. Los investigadores que trabajan en cada proyecto (Relación OneToMany)
        System.out.println("\n--- 1.2 INVESTIGADORES POR PROYECTO ---");
        List<Proyecto> proyectos = em.createQuery("SELECT p FROM Proyecto p", Proyecto.class).getResultList();
        for (Proyecto p : proyectos) {
            System.out.println("Proyecto: " + p.getNombre());
            for (Investigador inv : p.getInvestigadores()) {
                System.out.println("   - " + inv.getNombre().getNombre() + " " + inv.getNombre().getApellido1());
            }
        }

        // 1.3. Los investigadores que han ido a cada conferencia (Relación ManyToMany inverso)
        System.out.println("\n--- 1.3 INVESTIGADORES POR CONFERENCIA ---");
        List<Conferencia> conferencias = em.createQuery("SELECT c FROM Conferencia c", Conferencia.class).getResultList();
        for (Conferencia c : conferencias) {
            System.out.println("Conferencia: " + c.getNombre());
            for (Investigador inv : c.getInvestigadores()) {
                System.out.println("   - " + inv.getNombre().getNombre() + " " + inv.getNombre().getApellido1());
            }
        }

        // 1.4. Las conferencias en las que ha estado cada investigador (Relación ManyToMany propietario)
        System.out.println("\n--- 1.4 CONFERENCIAS DE CADA INVESTIGADOR ---");
        for (Investigador inv : investigadores) {
            System.out.println("Investigador: " + inv.getNombre().getNombre());
            for (Conferencia c : inv.getConferencias()) {
                System.out.println("   - " + c.getNombre() + " (" + c.getLugar() + ")");
            }
        }
    }

    public void actualizaciones() {
        em.getTransaction().begin();

        // 2.1. Haz que el investigador 2 haya asistido sólo a la conferencia 2.
        // Modificamos el lado propietario (Investigador) como indica el apartado 6.2.5 del PDF
        Investigador inv2 = em.find(Investigador.class, "45768434R");
        Conferencia conf2 = em.find(Conferencia.class, "Conferencia 2");
        if (inv2 != null && conf2 != null) {
            inv2.getConferencias().clear(); // Vaciamos todas las conferencias anteriores
            inv2.getConferencias().add(conf2); // Añadimos solo la Conferencia 2
        }

        // 2.2. Actualiza la fecha de la conferencia 4 poniendo la fecha actual.
        // Modificamos mediante setter sobre entidad gestionada (apartado 5.4 del PDF)
        Conferencia conf4 = em.find(Conferencia.class, "Conferencia 4");
        if (conf4 != null) {
            conf4.setFechaHoraInicio(new java.sql.Date(System.currentTimeMillis()));
        }

        // 2.3. Haz que todos los investigadores trabajen en el proyecto 3.
        // Modificamos el lado propietario de la relación 1:N (Investigador.setProyecto)
        Proyecto proy3 = em.find(Proyecto.class, "Proyecto 3");
        List<Investigador> todos = em.createQuery("SELECT i FROM Investigador i", Investigador.class).getResultList();
        if (proy3 != null) {
            for (Investigador inv : todos) {
                inv.setProyecto(proy3);
            }
        }

        em.getTransaction().commit();
    }

    public void eliminaciones() {
        em.getTransaction().begin();

        // 3.1. Eliminar Investigador 2
        Investigador inv2 = em.find(Investigador.class, "45768434R");
        if (inv2 != null) {
            em.remove(inv2);
        }

        // 3.2. Eliminar Proyecto 1
        Proyecto proy1 = em.find(Proyecto.class, "Proyecto 1");
        if (proy1 != null) {
            em.remove(proy1);
        }

        // 3.3. Eliminar Conferencia 4 (desvinculando primero el lado propietario)
        Conferencia conf4 = em.find(Conferencia.class, "Conferencia 4");
        if (conf4 != null) {
            for (Investigador inv : conf4.getInvestigadores()) {
                inv.getConferencias().remove(conf4);
            }
            em.remove(conf4);
        }

        em.getTransaction().commit();
    }

    // 1. El nombre de las conferencias cuya duración sea superior a las dos horas.
    public void consulta1() {
        List<String> nombres = em.createQuery(
            "SELECT c.nombre FROM Conferencia c WHERE c.numeroHoras > 2", String.class)
            .getResultList();
        System.out.println("1. Conferencias > 2h: " + nombres);
    }

    // 2. El nombre de los investigadores que participaron en la conferencia de la mayor duración.
    public void consulta2() {
        List<String> nombres = em.createQuery(
            "SELECT i.nombre.nombre FROM Investigador i JOIN i.conferencias c " +
            "WHERE c.numeroHoras = (SELECT MAX(c2.numeroHoras) FROM Conferencia c2)", String.class)
            .getResultList();
        System.out.println("2. Investigadores en conferencia de mayor duración: " + nombres);
    }

    // 3. Toda la información sobre la conferencia de menor duración.
    public void consulta3() {
        List<Conferencia> conferencias = em.createQuery(
            "SELECT c FROM Conferencia c " +
            "WHERE c.numeroHoras = (SELECT MIN(c2.numeroHoras) FROM Conferencia c2)", Conferencia.class)
            .getResultList();
        System.out.println("3. Conferencia(s) de menor duración:");
        for (Conferencia c : conferencias) {
            System.out.println("   - " + c.getNombre() + " | Fecha: " + c.getFechaHoraInicio() +
                            " | Lugar: " + c.getLugar() + " | Horas: " + c.getNumeroHoras());
        }
    }

    // 4. Los proyectos llevados a cabo por un determinado investigador.
    public void consulta4(String dniInvestigador) {
        List<Proyecto> proyectos = em.createQuery(
            "SELECT i.proyecto FROM Investigador i WHERE i.DNI = :dni", Proyecto.class)
            .setParameter("dni", dniInvestigador)
            .getResultList();
        System.out.println("4. Proyecto del investigador " + dniInvestigador + ":");
        for (Proyecto p : proyectos) {
            System.out.println("   - " + p.getNombre() + " (Inicio: " + p.getFecha_inicio() + ")");
        }
    }

    // 5. El número de conferencias en las que ha participado un determinado investigador.
    public void consulta5(String dniInvestigador) {
        Long total = em.createQuery(
            "SELECT COUNT(c) FROM Investigador i JOIN i.conferencias c WHERE i.DNI = :dni", Long.class)
            .setParameter("dni", dniInvestigador)
            .getSingleResult();
        System.out.println("5. Número de conferencias de " + dniInvestigador + ": " + total);
    }

    // 6. Dni, nombre y apellidos de los investigadores que trabajan en el proyecto 4.
    public void consulta6() {
        List<Object[]> resultados = em.createQuery(
            "SELECT i.DNI, i.nombre.nombre, i.nombre.apellido1, i.nombre.apellido2 " +
            "FROM Investigador i WHERE i.proyecto.nombre = 'Proyecto 4'", Object[].class)
            .getResultList();
        System.out.println("6. Investigadores del Proyecto 4:");
        for (Object[] fila : resultados) {
            System.out.println("   - DNI: " + fila[0] + " | Nombre: " + fila[1] + " " + fila[2] + " " + fila[3]);
        }
    }

    // 7. Toda la información sobre los proyectos en los que trabajan los investigadores que participaron en la conferencia 5.
    public void consulta7() {
        List<Proyecto> proyectos = em.createQuery(
            "SELECT DISTINCT i.proyecto FROM Investigador i JOIN i.conferencias c " +
            "WHERE c.nombre = 'Conferencia5'", Proyecto.class) // Ojo: en tus datos la llamaste "Conferencia5" sin espacio
            .getResultList();
        System.out.println("7. Proyectos de investigadores de Conferencia 5:");
        for (Proyecto p : proyectos) {
            System.out.println("   - " + p.getNombre() + " | Fecha inicio: " + p.getFecha_inicio());
        }
    }

    // 8. La misma información que el anterior, pero para una conferencia determinada.
    public void consulta8(String nombreConferencia) {
        List<Proyecto> proyectos = em.createQuery(
            "SELECT DISTINCT i.proyecto FROM Investigador i JOIN i.conferencias c " +
            "WHERE c.nombre = :nombreConf", Proyecto.class)
            .setParameter("nombreConf", nombreConferencia)
            .getResultList();
        System.out.println("8. Proyectos de investigadores de " + nombreConferencia + ":");
        for (Proyecto p : proyectos) {
            System.out.println("   - " + p.getNombre() + " | Fecha inicio: " + p.getFecha_inicio());
        }
    }

    // 9. El dni de los investigadores que trabajen en un proyecto cuya fecha de inicio sea menor a una fecha dada.
    public void consulta9(java.sql.Date fechaLimite) {
        List<String> dnis = em.createQuery(
            "SELECT i.DNI FROM Investigador i WHERE i.proyecto.fecha_inicio < :fecha", String.class)
            .setParameter("fecha", fechaLimite)
            .getResultList();
        System.out.println("9. DNIs en proyectos anteriores a " + fechaLimite + ": " + dnis);
    }

    // 10. Toda la información sobre las conferencias en las que haya participado un investigador con un apellido concreto.
    public void consulta10(String apellido) {
        List<Conferencia> conferencias = em.createQuery(
            "SELECT DISTINCT c FROM Investigador i JOIN i.conferencias c " +
            "WHERE i.nombre.apellido1 = :ap OR i.nombre.apellido2 = :ap", Conferencia.class)
            .setParameter("ap", apellido)
            .getResultList();
        System.out.println("10. Conferencias de investigadores con apellido '" + apellido + "':");
        for (Conferencia c : conferencias) {
            System.out.println("   - " + c.getNombre() + " | Fecha: " + c.getFechaHoraInicio() +
                            " | Lugar: " + c.getLugar() + " | Horas: " + c.getNumeroHoras());
        }
    }
}