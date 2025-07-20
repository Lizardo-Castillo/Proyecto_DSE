package com.backend.backend.infrastructure.external;

import org.springframework.stereotype.Component;

@Component
public class ReferenciaClient {
    public String buscarCentroAlternativo(String especialidad) {
        // Simular búsqueda de otro centro
        return "Hospital Nacional Guillermo Almenara";
    }
}
