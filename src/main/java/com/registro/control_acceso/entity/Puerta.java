
package com.registro.control_acceso.entity;

import jakarta.persistence.*;
import java.util.List;
import lombok.Data;

@Entity
@Data
public class Puerta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "puretaID")
    private Integer id;

    private String nombre;

    @OneToMany(mappedBy = "puerta")
    private List<Lector> lectores;

    
}
