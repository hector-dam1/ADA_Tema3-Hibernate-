package com.ej2;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
       GestorBD gbd = new GestorBD();
        //gbd.datos();
        //gbd.mostrarDatos();
        //gbd.actualizaciones();
        //gbd.eliminaciones();

        gbd.consulta1();
        gbd.consulta2();
        gbd.consulta3();
        gbd.consulta4("30487452M");
        gbd.consulta5("45642323B");
        gbd.consulta6();
        gbd.consulta7();
        gbd.consulta8("Conferencia 1");
        gbd.consulta9(Date.valueOf("2020-08-01"));
        gbd.consulta10("Ruiz");
    }
}