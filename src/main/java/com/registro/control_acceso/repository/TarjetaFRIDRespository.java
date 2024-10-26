
package com.registro.control_acceso.repository;

import com.registro.control_acceso.entity.TarjetaFRIDEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TarjetaFRIDRespository extends JpaRepository<TarjetaFRIDEntity, Integer>{
    Optional<TarjetaFRIDEntity> findByTarjetaFRIDAndEstadoTrue(String tajeta);
}
