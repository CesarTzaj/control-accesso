package com.registro.control_acceso.repository;

import com.registro.control_acceso.entity.Lector;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectorRepository extends JpaRepository<Lector, Long> {
    Optional<Lector> findByTarjetaRfid(String tarjetarfid);
}
