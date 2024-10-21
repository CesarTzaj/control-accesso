
package com.registro.control_acceso.controller;

import com.registro.control_acceso.service.AccesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/acceso")
public class AccesoController {

    @Autowired
    private AccesoService accesoService;

    @PostMapping("/validar")
    public ResponseEntity<String> validarAcceso(@RequestParam String lectorId, @RequestParam Long usuarioId) {
        boolean accesoPermitido = accesoService.validarYRegistrarAcceso(lectorId, usuarioId);
        if (accesoPermitido) {
            return ResponseEntity.ok("Acceso permitido");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Acceso denegado");
        }
    }
}