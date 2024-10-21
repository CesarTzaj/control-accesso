package com.registro.control_acceso.entity;

import jakarta.persistence.*;
import java.util.List;
import lombok.Data;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToMany
    @JoinTable(
            name = "usuario_puerta",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "puerta_id")
    )
    private List<Puerta> puertasPermitidas;

    // Getters y setters
}
