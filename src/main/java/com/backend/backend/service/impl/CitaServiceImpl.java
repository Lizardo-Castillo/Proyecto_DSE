package com.backend.backend.service.impl;

import org.springframework.stereotype.Service;

import com.backend.backend.domain.repository.CitaRepository;
import com.backend.backend.dto.CitaResponse;
import com.backend.backend.infrastructure.external.NotificacionClient;
import com.backend.backend.infrastructure.external.ReferenciaClient;
import com.backend.backend.dto.CitaRequest;
import com.backend.backend.service.CitaService;

@Service
public class CitaServiceImpl implements CitaService {

    private final CitaRepository citaRepository;
    private final NotificacionClient notificacionClient;
    private final ReferenciaClient referenciaClient;

    public CitaServiceImpl(CitaRepository citaRepository, NotificacionClient notificacionClient, ReferenciaClient referenciaClient) {
        this.citaRepository = citaRepository;
        this.notificacionClient = notificacionClient;
        this.referenciaClient = referenciaClient;
    }

    @Override
    public CitaResponse programarCita(CitaRequest request) {
        
        CitaResponse response = new CitaResponse();

        response.setAsegurado(true); // Assuming the user is insured
        response.setEstado("Confirmado");
        response.setCentroAsignado("Centro de Salud Principal"); // Example center
        response.setFechaConfirmada(request.getFechaDeseada());
        response.setMensaje("Cita programada exitosamente");
        
        return response;
    }
}
