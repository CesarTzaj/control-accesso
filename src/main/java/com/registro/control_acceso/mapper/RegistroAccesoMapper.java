
package com.registro.control_acceso.mapper;

import com.registro.control_acceso.dto.RegistroAccesoDTO;
import com.registro.control_acceso.entity.RegistroAcceso;
import java.util.List;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface RegistroAccesoMapper {

    @Mappings({
        @Mapping(source = "horaAcceso", target = "date", dateFormat = "dd-MM-yyyy HH:mm:ss"),
        @Mapping(source = "usuario.nombre", target = "nombre"),
        @Mapping(source = "puerta.nombre", target = "puerta")
    })
    RegistroAccesoDTO toRegistroAccesoDTO(RegistroAcceso registroAcceso);
    List<RegistroAccesoDTO> toRegistroAccesoDTOs(List<RegistroAcceso> registroAcceso);
}
