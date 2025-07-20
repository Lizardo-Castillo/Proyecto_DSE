package com.backend.backend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.backend.backend.service.CitaService;
import com.backend.backend.dto.CitaRequest;
import com.backend.backend.dto.CitaResponse;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    private final CitaService citaService;

    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @PostMapping
    public ResponseEntity<CitaResponse> programarCita(@RequestBody CitaRequest request) {
        return ResponseEntity.ok(citaService.programarCita(request));
    }

}
