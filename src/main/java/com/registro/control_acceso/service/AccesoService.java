
package com.registro.control_acceso.service;

import com.registro.control_acceso.entity.Lector;
import com.registro.control_acceso.entity.Puerta;
import com.registro.control_acceso.entity.RegistroAcceso;
import com.registro.control_acceso.entity.TarjetaFRIDEntity;
import com.registro.control_acceso.entity.Usuario;
import com.registro.control_acceso.repository.LectorRepository;
import com.registro.control_acceso.repository.RegistroAccesoRepository;
import com.registro.control_acceso.repository.TarjetaFRIDRespository;
import com.registro.control_acceso.repository.UsuarioRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccesoService {

    @Autowired
    private TarjetaFRIDRespository lectorRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RegistroAccesoRepository registroAccesoRepository;


  public boolean validarYRegistrarAcceso(String tarjetarfid, int puertaId) {
        // Buscar la tarjeta RFID activa
        Optional<TarjetaFRIDEntity> lectorOpt = lectorRepository.findByTarjetaFRIDAndEstadoTrue(tarjetarfid);
        // Buscar el usuario por su ID
        Optional<Usuario> usuarioOpt = usuarioRepository.findByPuertasPermitidas_Id(puertaId);

        // Verificar si tanto la tarjeta como el usuario existen
        if (lectorOpt.isPresent() && usuarioOpt.isPresent()) {
            TarjetaFRIDEntity lector = lectorOpt.get();
            Usuario usuario = usuarioOpt.get();

            // Iterar sobre las puertas permitidas del usuario
            for (Puerta puertaPermitida : usuario.getPuertasPermitidas()) {
                // Verificar si la puerta permitida coincide con la puerta del lector
                if (lector.getUsuario().getPuertasPermitidas().contains(puertaPermitida)) {
                    // Registrar el acceso si la puerta está permitida
                    RegistroAcceso registro = new RegistroAcceso();
                    registro.setUsuario(usuario);
                    registro.setPuerta(puertaPermitida); // Usar la puerta permitida correspondiente
                    registro.setHoraAcceso(LocalDateTime.now());
                    registroAccesoRepository.save(registro);

                    return true; // Acceso permitido
                }
            }
        }

        return false; // Acceso denegado
    }
}


