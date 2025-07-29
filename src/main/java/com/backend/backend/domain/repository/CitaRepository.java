package com.backend.backend.domain.repository;

import com.backend.backend.domain.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
    // Puedes agregar consultas personalizadas si es necesario
}
