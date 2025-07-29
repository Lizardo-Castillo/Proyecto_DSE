package com.backend.backend.service;

import com.backend.backend.dto.CitaRequest;
import com.backend.backend.dto.CitaResponse;

public interface CitaService {
    CitaResponse programarCita(CitaRequest request);
}
