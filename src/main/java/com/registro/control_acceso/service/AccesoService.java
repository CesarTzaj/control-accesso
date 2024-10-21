
package com.registro.control_acceso.service;

import com.registro.control_acceso.entity.Lector;
import com.registro.control_acceso.entity.RegistroAcceso;
import com.registro.control_acceso.entity.Usuario;
import com.registro.control_acceso.repository.LectorRepository;
import com.registro.control_acceso.repository.RegistroAccesoRepository;
import com.registro.control_acceso.repository.UsuarioRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccesoService {

    @Autowired
    private LectorRepository lectorRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RegistroAccesoRepository registroAccesoRepository;

    public boolean validarYRegistrarAcceso(String tarjetarfid, Long usuarioId) {
        Optional<Lector> lectorOpt = lectorRepository.findByTarjetaRfid(tarjetarfid);
        Optional<Usuario> usuarioOpt = usuarioRepository.findByPuertasPermitidas_Id(usuarioId);

        if (lectorOpt.isPresent() && usuarioOpt.isPresent()) {
            Lector lector = lectorOpt.get();
            Usuario usuario = usuarioOpt.get();

            if (usuario.getPuertasPermitidas().contains(lector.getPuerta())) {
                // Registrar acceso
                RegistroAcceso registro = new RegistroAcceso();
                registro.setUsuario(usuario);
                registro.setPuerta(lector.getPuerta());
                registro.setHoraAcceso(LocalDateTime.now());
                registroAccesoRepository.save(registro);

                return true; // Acceso permitido
            }
        }

        return false; // Acceso denegado
    }
}

