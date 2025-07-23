package com.backend.backend.domain.repository;

import com.backend.backend.domain.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
