package com.backend.backend.service;

import com.backend.backend.dto.MedicoRequest;
import com.backend.backend.dto.MedicoResponse;

import java.util.List;

public interface MedicoService {
    MedicoResponse registrarMedico(MedicoRequest request);
    List<MedicoResponse> listarMedicos();
}
