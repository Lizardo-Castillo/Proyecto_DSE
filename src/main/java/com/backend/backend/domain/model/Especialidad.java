package com.backend.backend.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Especialidad {
    @Id
    private String codigo;

    private String nombre;

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}