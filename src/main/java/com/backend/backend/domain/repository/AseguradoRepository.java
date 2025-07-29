package com.backend.backend.infrastructure.repository;

import com.backend.backend.domain.model.Asegurado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AseguradoRepository extends JpaRepository<Asegurado, Integer> {
}
