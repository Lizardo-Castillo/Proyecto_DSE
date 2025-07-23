package com.backend.backend.controller;

import com.backend.backend.dto.MedicoRequest;
import com.backend.backend.dto.MedicoResponse;
import com.backend.backend.service.MedicoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @PostMapping
    public MedicoResponse registrar(@RequestBody MedicoRequest request) {
        return medicoService.registrarMedico(request);
    }

    @GetMapping
    public List<MedicoResponse> listar() {
        return medicoService.listarMedicos();
    }
}
