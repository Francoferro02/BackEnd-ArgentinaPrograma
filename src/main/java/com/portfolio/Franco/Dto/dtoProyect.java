package com.portfolio.Franco.Dto;

import javax.validation.constraints.NotBlank;

public class dtoProyect {

    @NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String img;

    public dtoProyect() {
    }

    public dtoProyect(String nombre, String descripcion, String img) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}
