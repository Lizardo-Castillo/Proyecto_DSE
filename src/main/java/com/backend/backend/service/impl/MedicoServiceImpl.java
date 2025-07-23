package com.backend.backend.service.impl;

import com.backend.backend.domain.model.Medico;
import com.backend.backend.domain.repository.MedicoRepository;
import com.backend.backend.dto.MedicoRequest;
import com.backend.backend.dto.MedicoResponse;
import com.backend.backend.service.MedicoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoServiceImpl implements MedicoService {

    private final MedicoRepository medicoRepository;

    public MedicoServiceImpl(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @Override
    public MedicoResponse registrarMedico(MedicoRequest request) {
        Medico medico = new Medico();
        medico.setNombre(request.getNombre());
        medico.setCorreo(request.getCorreo()); // ✅ Guardamos correo
        medico.setEspecialidad(request.getEspecialidad());
        medico.setNumeroColegiatura(request.getNumeroColegiatura());

        Medico guardado = medicoRepository.save(medico);

        MedicoResponse response = new MedicoResponse();
        response.setId(guardado.getId());
        response.setNombre(guardado.getNombre());
        response.setCorreo(guardado.getCorreo()); // ✅ Incluimos en la respuesta
        response.setEspecialidad(guardado.getEspecialidad());
        response.setMensaje("Médico registrado exitosamente");

        return response;
    }

    @Override
    public List<MedicoResponse> listarMedicos() {
        return medicoRepository.findAll().stream().map(medico -> {
            MedicoResponse response = new MedicoResponse();
            response.setId(medico.getId());
            response.setNombre(medico.getNombre());
            response.setCorreo(medico.getCorreo()); // ✅ Incluir en listado
            response.setEspecialidad(medico.getEspecialidad());
            response.setMensaje("Médico cargado correctamente");
            return response;
        }).toList();
    }
}
