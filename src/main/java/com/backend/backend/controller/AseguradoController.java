package com.backend.backend.controller;

import com.backend.backend.dto.AseguradoRequest;
import com.backend.backend.dto.AseguradoResponse;
import com.backend.backend.service.AseguradoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/asegurados")
public class AseguradoController {

    private final AseguradoService aseguradoService;

    public AseguradoController(AseguradoService aseguradoService) {
        this.aseguradoService = aseguradoService;
    }

    @PostMapping
    public ResponseEntity<AseguradoResponse> registrarAsegurado(@RequestBody AseguradoRequest request) {
        return ResponseEntity.ok(aseguradoService.registrarAsegurado(request));
    }
}
