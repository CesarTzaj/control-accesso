package com.registro.control_acceso.mapper;

import com.registro.control_acceso.dto.UserDTO;
import com.registro.control_acceso.entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-25T23:31:38-0600",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toUserDTO(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setName( usuario.getNombre() );

        return userDTO;
    }

    @Override
    public List<UserDTO> toUserDTOs(List<Usuario> usuarios) {
        if ( usuarios == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( usuarios.size() );
        for ( Usuario usuario : usuarios ) {
            list.add( toUserDTO( usuario ) );
        }

        return list;
    }
}
