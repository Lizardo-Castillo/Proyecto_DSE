package com.backend.backend.controller;

import com.backend.backend.dto.CitaRequest;
import com.backend.backend.dto.CitaResponse;
import com.backend.backend.service.CitaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/citas")
@CrossOrigin(origins = "*") // Para permitir llamadas desde Bonita u otro front
public class CitaController {

    private final CitaService citaService;
    private static final Logger logger = LoggerFactory.getLogger(CitaController.class);

    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @PostMapping
    public ResponseEntity<CitaResponse> programarCita(@RequestBody CitaRequest request) {
        // Log de entrada
        logger.info("📩 [Nueva solicitud] Programar cita - Datos recibidos: {}", request);

        try {
            CitaResponse response = citaService.programarCita(request);

            // Log de salida
            logger.info("✅ [Cita registrada] ID: {}, DNI: {}, Especialidad: {}",
                    response.getId(), response.getDni(), response.getEspecialidad());

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Log del error completo
            logger.error("❌ [Error] No se pudo registrar la cita. Detalles: {}", e.getMessage(), e);

            // También puedes enviar un JSON de error si quieres
            return ResponseEntity.internalServerError().build();
        }
    }
}
