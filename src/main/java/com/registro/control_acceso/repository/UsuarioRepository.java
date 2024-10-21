
package com.registro.control_acceso.repository;

import com.registro.control_acceso.entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByPuertasPermitidas_Id(Long puertaId);
}
