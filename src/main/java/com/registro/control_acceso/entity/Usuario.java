package com.registro.control_acceso.entity;

import jakarta.persistence.*;
import java.util.List;
import lombok.Data;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuarioID")
    private Integer id;

    private String nombre;

    @ManyToMany
    @JoinTable(
            name = "usuario_puerta",
            joinColumns = @JoinColumn(name = "usuario_id", foreignKey = @ForeignKey(name = "FK_UsuarioPuerta_Usuario")),
            inverseJoinColumns = @JoinColumn(name = "puerta_id", foreignKey = @ForeignKey(name = "FK_UsuarioPuerta_Puerta"))
    )
    private List<Puerta> puertasPermitidas;

    // Getters y setters
}
