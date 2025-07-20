package com.backend.backend.service;

import com.backend.backend.dto.CitaResponse;
import com.backend.backend.dto.CitaRequest;

public interface CitaService {
    CitaResponse programarCita(CitaRequest request);
}
