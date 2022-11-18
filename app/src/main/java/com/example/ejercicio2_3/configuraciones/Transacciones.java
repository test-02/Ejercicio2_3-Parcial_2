package com.example.ejercicio2_3.configuraciones;

public class Transacciones {
    public static final String NameDatabase = "Photographs";
    public static final String tablaPhotograph = "Photograph";
    public static final String id = "id";
    public static final String descripcion = "descripcion";
    public static final String imagen = "imagen";

    public static final String CreateTablePhotograph = "CREATE TABLE " + tablaPhotograph + "(id INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "descripcion TEXT, imagen BLOB)";

    public static final String DropTablePhotograph = "DROP TABLE IF EXISTS "+ tablaPhotograph;
}
