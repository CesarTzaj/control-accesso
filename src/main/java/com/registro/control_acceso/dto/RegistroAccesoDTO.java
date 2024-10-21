
package com.registro.control_acceso.dto;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;

@Data
public class RegistroAccesoDTO {

    private String nombre;
    private Date date;
    private LocalDateTime  horaEntrada;
    private LocalDateTime  horaSalida;
    private String puerta;
    private Duration duracion;
    
}
