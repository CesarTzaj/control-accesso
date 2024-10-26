
package com.registro.control_acceso.controller;


import com.registro.control_acceso.dto.RegistroAccesoDTO;
import com.registro.control_acceso.dto.UserDTO;
import com.registro.control_acceso.entity.Usuario;
import com.registro.control_acceso.mapper.RegistroAccesoMapper;
import com.registro.control_acceso.mapper.UserMapper;
import com.registro.control_acceso.repository.RegistroAccesoRepository;
import com.registro.control_acceso.repository.UsuarioRepository;
import com.registro.control_acceso.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
  @CrossOrigin(origins = "http://localhost:3000") 
public class UsuarioController {

   
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping()
    public List<RegistroAccesoDTO> getAllUsuarioas() {
        return usuarioService.getAll();
    }
   

}

