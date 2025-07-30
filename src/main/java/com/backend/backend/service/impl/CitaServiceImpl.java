package com.backend.backend.service.impl;

import com.backend.backend.domain.model.Cita;
import com.backend.backend.domain.repository.CitaRepository;
import com.backend.backend.dto.CitaRequest;
import com.backend.backend.dto.CitaResponse;
import com.backend.backend.service.CitaService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static com.backend.backend.config.RabbitConfig.*;

@Service
public class CitaServiceImpl implements CitaService {

    private final CitaRepository citaRepository;
    private final RabbitTemplate rabbitTemplate;

    public CitaServiceImpl(CitaRepository citaRepository, RabbitTemplate rabbitTemplate) {
        this.citaRepository = citaRepository;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public CitaResponse programarCita(CitaRequest request) {
        // Crear nueva cita
        Cita cita = new Cita();
        cita.setDni(request.getDni());
        cita.setNombre(request.getNombre());
        cita.setApellidoPaterno(request.getApellidoPaterno());
        cita.setApellidoMaterno(request.getApellidoMaterno());
        cita.setEspecialidad(request.getEspecialidad());
        cita.setTelefono(request.getTelefono());
        cita.setCorreo(request.getCorreo());
        cita.setFecha(request.getFecha());

        // Guardar en BD
        Cita citaGuardada = citaRepository.save(cita);

        // Crear mensaje para RabbitMQ
        String mensaje = String.format(
                "Cita registrada: ID=%d, DNI=%s, Especialidad=%s, Fecha=%s",
                citaGuardada.getId(),
                citaGuardada.getDni(),
                citaGuardada.getEspecialidad(),
                citaGuardada.getFecha()
        );

        // Enviar mensaje al Exchange con la Routing Key
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, mensaje);

        // Respuesta para Bonita
        return new CitaResponse(
                citaGuardada.getId(),
                citaGuardada.getDni(),
                citaGuardada.getNombre(),
                citaGuardada.getEspecialidad(),
                citaGuardada.getFecha(),
                "✅ Cita programada correctamente y enviada a RabbitMQ"
        );
    }
}
