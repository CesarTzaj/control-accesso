package com.registro.control_acceso.mapper;

import com.registro.control_acceso.dto.RegistroAccesoDTO;
import com.registro.control_acceso.entity.Puerta;
import com.registro.control_acceso.entity.RegistroAcceso;
import com.registro.control_acceso.entity.Usuario;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-25T23:31:37-0600",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class RegistroAccesoMapperImpl implements RegistroAccesoMapper {

    @Override
    public RegistroAccesoDTO toRegistroAccesoDTO(RegistroAcceso registroAcceso) {
        if ( registroAcceso == null ) {
            return null;
        }

        RegistroAccesoDTO registroAccesoDTO = new RegistroAccesoDTO();

        if ( registroAcceso.getHoraAcceso() != null ) {
            registroAccesoDTO.setDate( Date.from( registroAcceso.getHoraAcceso().toInstant( ZoneOffset.UTC ) ) );
        }
        registroAccesoDTO.setNombre( registroAccesoUsuarioNombre( registroAcceso ) );
        registroAccesoDTO.setPuerta( registroAccesoPuertaNombre( registroAcceso ) );

        return registroAccesoDTO;
    }

    @Override
    public List<RegistroAccesoDTO> toRegistroAccesoDTOs(List<RegistroAcceso> registroAcceso) {
        if ( registroAcceso == null ) {
            return null;
        }

        List<RegistroAccesoDTO> list = new ArrayList<RegistroAccesoDTO>( registroAcceso.size() );
        for ( RegistroAcceso registroAcceso1 : registroAcceso ) {
            list.add( toRegistroAccesoDTO( registroAcceso1 ) );
        }

        return list;
    }

    private String registroAccesoUsuarioNombre(RegistroAcceso registroAcceso) {
        if ( registroAcceso == null ) {
            return null;
        }
        Usuario usuario = registroAcceso.getUsuario();
        if ( usuario == null ) {
            return null;
        }
        String nombre = usuario.getNombre();
        if ( nombre == null ) {
            return null;
        }
        return nombre;
    }

    private String registroAccesoPuertaNombre(RegistroAcceso registroAcceso) {
        if ( registroAcceso == null ) {
            return null;
        }
        Puerta puerta = registroAcceso.getPuerta();
        if ( puerta == null ) {
            return null;
        }
        String nombre = puerta.getNombre();
        if ( nombre == null ) {
            return null;
        }
        return nombre;
    }
}
