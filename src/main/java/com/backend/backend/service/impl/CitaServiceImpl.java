package com.backend.backend.service.impl;

import org.springframework.stereotype.Service;

import com.backend.backend.domain.model.Cita;
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
        // 1. Crear entidad Cita desde los datos del request
        Cita cita = new Cita();
        cita.setDni(request.getDni());
        cita.setFecha(request.getFechaDeseada());
        cita.setEspecialidad(request.getEspecialidad());
        cita.setCentroAsignado("Centro de Salud Principal");  // Puedes personalizar si quieres

        // 2. Guardar la cita en la base de datos
        citaRepository.save(cita);

        // 3. Construir y devolver la respuesta
        CitaResponse response = new CitaResponse();
        response.setAsegurado(true);
        response.setEstado("Confirmado");
        response.setCentroAsignado(cita.getCentroAsignado());
        response.setFechaConfirmada(cita.getFecha());
        response.setMensaje("Cita programada exitosamente");

        return response;
    }
}
