package com.backend.backend.controller;

import com.backend.backend.dto.PacienteRequest;
import com.backend.backend.dto.PacienteResponse;
import com.backend.backend.service.PacienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public PacienteResponse registrarPaciente(@RequestBody PacienteRequest request) {
        return pacienteService.registrarPaciente(request);
    }

    @GetMapping
    public List<PacienteResponse> listarPacientes() {
        return pacienteService.listarPacientes();
    }
}
