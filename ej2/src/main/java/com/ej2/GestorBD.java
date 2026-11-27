package com.ej2;

import static java.sql.Date.valueOf;

import java.util.ArrayList;
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
        NombreCompleto nc6 = new NombreCompleto("José ","López","López");
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

        List<Investigador> conferencia1Investigadores = new ArrayList<>();
        List<Investigador> conferencia2Investigadores = new ArrayList<>();
        List<Investigador> conferencia3Investigadores = new ArrayList<>();
        List<Investigador> conferencia4Investigadores = new ArrayList<>();
        List<Investigador> conferencia5Investigadores = new ArrayList<>();

        conferencia1Investigadores.add(investigador2);
        conferencia1Investigadores.add(investigador3);
        conferencia1Investigadores.add(investigador4);
        conferencia1Investigadores.add(investigador5);

        conferencia2Investigadores.add(investigador1);
        conferencia2Investigadores.add(investigador3);
        conferencia2Investigadores.add(investigador5);

        conferencia3Investigadores.add(investigador2);
        conferencia3Investigadores.add(investigador3);
        conferencia3Investigadores.add(investigador5);

        conferencia4Investigadores.add(investigador3);
        conferencia4Investigadores.add(investigador5);

        conferencia5Investigadores.add(investigador2);
        conferencia5Investigadores.add(investigador3);
        conferencia5Investigadores.add(investigador4);

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

        conferencia1.setInvestigadores(conferencia1Investigadores);
        conferencia2.setInvestigadores(conferencia2Investigadores);
        conferencia3.setInvestigadores(conferencia3Investigadores);
        conferencia4.setInvestigadores(conferencia4Investigadores);
        conferencia5.setInvestigadores(conferencia5Investigadores);
        em.getTransaction().commit();
    }

}