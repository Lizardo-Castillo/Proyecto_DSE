package com.backend.backend.dto;

public class AseguradoResponse {

    private String mensaje;

    public AseguradoResponse(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
}
