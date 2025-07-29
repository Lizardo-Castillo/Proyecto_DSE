package com.backend.backend.dto;

public class CitaResponse {

    private Long id;
    private String dni;
    private String nombre;
    private String especialidad;
    private String fecha;
    private String mensaje;

    public CitaResponse(Long id, String dni, String nombre, String especialidad, String fecha, String mensaje) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.fecha = fecha;
        this.mensaje = mensaje;
    }

    // Getters
    public Long getId() { return id; }
    public String getDni() { return dni; }
    public String getNombre() { return nombre; }
    public String getEspecialidad() { return especialidad; }
    public String getFecha() { return fecha; }
    public String getMensaje() { return mensaje; }
}
