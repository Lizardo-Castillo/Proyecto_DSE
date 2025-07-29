package com.backend.backend.service.impl;

import com.backend.backend.domain.model.Cita;
import com.backend.backend.dto.CitaRequest;
import com.backend.backend.dto.CitaResponse;
import com.backend.backend.infrastructure.repository.CitaRepository;
import com.backend.backend.service.CitaService;
import org.springframework.stereotype.Service;

@Service
public class CitaServiceImpl implements CitaService {

    private final CitaRepository citaRepository;

    public CitaServiceImpl(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    @Override
    public CitaResponse programarCita(CitaRequest request) {
        Cita cita = new Cita();
        cita.setDni(request.getDni());
        cita.setNombre(request.getNombre());
        cita.setApellidoPaterno(request.getApellidoPaterno());
        cita.setApellidoMaterno(request.getApellidoMaterno());
        cita.setEspecialidad(request.getEspecialidad());
        cita.setTelefono(request.getTelefono());
        cita.setCorreo(request.getCorreo());
        cita.setFecha(request.getFecha());

        citaRepository.save(cita);

        return new CitaResponse(
                "Cita registrada para: " + request.getNombre() + " " + request.getApellidoPaterno(),
                request.getFecha()
        );
    }
}
