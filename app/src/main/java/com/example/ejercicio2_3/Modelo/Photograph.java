package com.example.ejercicio2_3.Modelo;

public class Photograph {

    Integer id;
    String Descripcion;
    String imagen;

    public Photograph(){
    }

    public Photograph(Integer id, String descripcion, String imagen){
        this.id = id;
        Descripcion = descripcion;
        this.imagen = imagen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
