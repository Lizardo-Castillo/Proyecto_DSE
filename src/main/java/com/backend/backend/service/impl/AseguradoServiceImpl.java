package com.backend.backend.service.impl;

import com.backend.backend.domain.model.Asegurado;
import com.backend.backend.dto.AseguradoRequest;
import com.backend.backend.dto.AseguradoResponse;
import com.backend.backend.infrastructure.repository.AseguradoRepository;
import com.backend.backend.service.AseguradoService;
import org.springframework.stereotype.Service;

@Service
public class AseguradoServiceImpl implements AseguradoService {

    private final AseguradoRepository aseguradoRepository;

    public AseguradoServiceImpl(AseguradoRepository aseguradoRepository) {
        this.aseguradoRepository = aseguradoRepository;
    }

    @Override
    public AseguradoResponse registrarAsegurado(AseguradoRequest request) {
        Asegurado asegurado = new Asegurado();
        asegurado.setDni(request.getDni());
        asegurado.setCredencial(request.getCredencial());

        aseguradoRepository.save(asegurado);

        return new AseguradoResponse(
                "Asegurado registrado con DNI: " + request.getDni()
        );
    }
}
