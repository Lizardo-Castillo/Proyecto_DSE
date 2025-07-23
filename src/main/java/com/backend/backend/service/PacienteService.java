package com.backend.backend.service;

import com.backend.backend.dto.PacienteRequest;
import com.backend.backend.dto.PacienteResponse;

import java.util.List;

public interface PacienteService {
    PacienteResponse registrarPaciente(PacienteRequest request);
    List<PacienteResponse> listarPacientes();
}
