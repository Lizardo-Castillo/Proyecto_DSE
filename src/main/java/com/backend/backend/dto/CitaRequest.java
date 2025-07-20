package com.backend.backend.dto;

public class CitaRequest {
    private String dni;
    private String fecha;
    private String especialidad;
    private String fechaDeseada;

    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public String getFechaDeseada() {
        return fechaDeseada;
    }
    public void setFechaDeseada(String fechaDeseada) {
        this.fechaDeseada = fechaDeseada;
    }

}
