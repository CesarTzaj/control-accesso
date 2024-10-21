
package com.registro.control_acceso.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;


@Entity
@Data
public class RegistroAcceso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registroAccesoId")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", foreignKey = @ForeignKey(name = "FK_RegistroAcceso_Usurio"))
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "puerta_id", foreignKey = @ForeignKey(name = "FK_RegistroAccesso_Puerta"))
    private Puerta puerta;

    private LocalDateTime horaAcceso;

    // Getters y setters
}