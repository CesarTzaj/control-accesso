
package com.registro.control_acceso.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;


@Entity
@Data
public class RegistroAcceso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "puerta_id")
    private Puerta puerta;

    private LocalDateTime horaAcceso;

    // Getters y setters
}