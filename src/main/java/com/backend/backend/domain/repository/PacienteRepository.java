package com.backend.backend.domain.repository;

import com.backend.backend.domain.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
