package com.backend.backend.service.impl;

import com.backend.backend.domain.model.Cita;
import com.backend.backend.domain.repository.CitaRepository;
import com.backend.backend.dto.CitaRequest;
import com.backend.backend.dto.CitaResponse;
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

        // Guardar en BD
        Cita citaGuardada = citaRepository.save(cita);

        return new CitaResponse(
                citaGuardada.getId(),
                citaGuardada.getDni(),
                citaGuardada.getNombre(),
                citaGuardada.getEspecialidad(),
                citaGuardada.getFecha(),
                "Cita programada correctamente"
        );
    }
}
