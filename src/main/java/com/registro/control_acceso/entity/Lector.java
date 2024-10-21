
package com.registro.control_acceso.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Lector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LectorId")
    private Integer id;
    
    @Column(name = "identificador")
    private String tarjetaRfid;

    @ManyToOne
    @JoinColumn(name = "puerta_id", foreignKey = @ForeignKey(name = "FK_Lector_Puerta"))
    private Puerta puerta;

    // Getters y setters
}
