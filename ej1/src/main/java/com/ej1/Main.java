package com.ej1;

import static java.sql.Date.valueOf;

public class Main {
    public static void main(String[] args) {
        GestorBD gestor = new GestorBD();
        //gestor.crear();
        //gestor.modifiarLibro(1, "Prestado");
        //gestor.aumentarCategoriaUsuario(3);
        //gestor.modificarFechaFin(1, 1, valueOf("2026-12-21"));
        //gestor.EliminarUsuario(5);
        //gestor.EliminarPrestamo(3);
        gestor.cerrar();
    }
}