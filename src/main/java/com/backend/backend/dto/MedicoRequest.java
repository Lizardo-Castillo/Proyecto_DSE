package com.backend.backend.dto;

public class MedicoRequest {
    private String nombre;
    private String correo; // ✅ Añadido
    private String especialidad;
    private String numeroColegiatura;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() { // ✅ Getter
        return correo;
    }

    public void setCorreo(String correo) { // ✅ Setter
        this.correo = correo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getNumeroColegiatura() {
        return numeroColegiatura;
    }

    public void setNumeroColegiatura(String numeroColegiatura) {
        this.numeroColegiatura = numeroColegiatura;
    }
}
