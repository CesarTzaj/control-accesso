
package com.registro.control_acceso.repository;

import com.registro.control_acceso.entity.RegistroAcceso;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RegistroAccesoRepository extends JpaRepository<RegistroAcceso, Integer> {
    //List<RegistroAcceso> findAllByOrderByHoraAccesoDESC();
}

