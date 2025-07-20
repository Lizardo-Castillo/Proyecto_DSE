package com.backend.backend.infrastructure.external;

import org.springframework.stereotype.Component;

@Component
public class NotificacionClient {
    public void enviarConfirmacion(String correo, String mensaje) {
        // Lógica para enviar notificación
        System.out.println("Correo enviado a " + correo + ": " + mensaje);
    }
}
