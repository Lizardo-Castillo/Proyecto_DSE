package com.backend.backend.dto;

public class CitaResponse {
    private boolean asegurado;
    private String estado;
    private String centroAsignado;
    private String fechaConfirmada;
    private String mensaje;

    public boolean isAsegurado() {
        return asegurado;
    }
    public void setAsegurado(boolean asegurado) {
        this.asegurado = asegurado;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getCentroAsignado() {
        return centroAsignado;
    }
    public void setCentroAsignado(String centroAsignado) {
        this.centroAsignado = centroAsignado;
    }
    public String getFechaConfirmada() {
        return fechaConfirmada;
    }
    public void setFechaConfirmada(String fechaConfirmada) {
        this.fechaConfirmada = fechaConfirmada;
    }
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
