package com.backend.backend.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "asegurado")
public class Asegurado {

    @Id
    private Integer dni;      // Clave primaria

    private String credencial;

    // Getters y Setters
    public Integer getDni() { return dni; }
    public void setDni(Integer dni) { this.dni = dni; }

    public String getCredencial() { return credencial; }
    public void setCredencial(String credencial) { this.credencial = credencial; }
}
