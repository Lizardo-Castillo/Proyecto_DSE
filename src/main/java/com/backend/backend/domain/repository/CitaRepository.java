package com.backend.backend.domain.repository;
import com.backend.backend.domain.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitaRepository extends JpaRepository<Cita, Long> {
    // Define any custom query methods if needed

}
