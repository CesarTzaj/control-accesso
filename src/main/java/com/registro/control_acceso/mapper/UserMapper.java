
package com.registro.control_acceso.mapper;

import com.registro.control_acceso.dto.UserDTO;
import com.registro.control_acceso.entity.Usuario;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;





@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
        @Mapping(source = "nombre", target = "name")
    })
    UserDTO toUserDTO(Usuario usuario);
    List<UserDTO> toUserDTOs(List<Usuario> usuarios);
}
