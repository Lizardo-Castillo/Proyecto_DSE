package com.backend.backend.service;

import com.backend.backend.dto.AseguradoRequest;
import com.backend.backend.dto.AseguradoResponse;

public interface AseguradoService {
    AseguradoResponse registrarAsegurado(AseguradoRequest request);
}
