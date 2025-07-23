package com.backend.backend.service.impl;

import com.backend.backend.domain.model.Paciente;
import com.backend.backend.domain.repository.PacienteRepository;
import com.backend.backend.dto.PacienteRequest;
import com.backend.backend.dto.PacienteResponse;
import com.backend.backend.service.PacienteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public PacienteResponse registrarPaciente(PacienteRequest request) {
        Paciente paciente = new Paciente();
        paciente.setDni(request.getDni());
        paciente.setNombres(request.getNombres());
        paciente.setApellidos(request.getApellidos());
        paciente.setCorreo(request.getCorreo());
        paciente.setTelefono(request.getTelefono());

        Paciente guardado = pacienteRepository.save(paciente);

        PacienteResponse response = new PacienteResponse();
        response.setId(guardado.getId());
        response.setNombres(guardado.getNombres());
        response.setApellidos(guardado.getApellidos());
        response.setMensaje("Paciente registrado correctamente");

        return response;
    }

    @Override
    public List<PacienteResponse> listarPacientes() {
        return pacienteRepository.findAll().stream().map(paciente -> {
            PacienteResponse response = new PacienteResponse();
            response.setId(paciente.getId());
            response.setNombres(paciente.getNombres());
            response.setApellidos(paciente.getApellidos());
            response.setMensaje("Paciente cargado");
            return response;
        }).toList();
    }
}
