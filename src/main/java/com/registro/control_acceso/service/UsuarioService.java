package com.registro.control_acceso.service;

import com.registro.control_acceso.dto.RegistroAccesoDTO;
import com.registro.control_acceso.entity.RegistroAcceso;
import com.registro.control_acceso.mapper.RegistroAccesoMapper;
import com.registro.control_acceso.repository.RegistroAccesoRepository;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private RegistroAccesoMapper registroAccesoMapper;

    @Autowired
    private RegistroAccesoRepository registroAccesoRepository;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public List<RegistroAccesoDTO> getAll() {
        // Obtener todos los registros de la base de datos
        List<RegistroAcceso> registros = registroAccesoRepository.findAll();
        // Convertir las entidades a DTOs
        List<RegistroAccesoDTO> registroAccesoDTOs = registroAccesoMapper.toRegistroAccesoDTOs(registros);

        // Crear un mapa para agrupar registros por fecha
        Map<String, RegistroAccesoDTO> registrosUnicos = new LinkedHashMap<>();

        // Iterar sobre los DTOs y agruparlos por fecha
        for (RegistroAccesoDTO registro : registroAccesoDTOs) {
            String fecha = dateFormat.format(registro.getDate()); // Formatear la fecha del DTO

            // Obtener la hora de acceso como LocalDateTime
            LocalDateTime horaAcceso = convertToLocalDateTime(registro.getDate());

            // Si la fecha no está en el mapa, agregar un nuevo registro
            if (!registrosUnicos.containsKey(fecha)) {
                registro.setHoraEntrada(horaAcceso);
                registrosUnicos.put(fecha, registro);
            } else {
                // Si ya existe la fecha en el mapa, actualizar la hora de salida y la duración
                RegistroAccesoDTO registroExistente = registrosUnicos.get(fecha);
                registroExistente.setHoraSalida(horaAcceso);

                // Calcular la duración entre la hora de entrada y la hora de salida
                Duration duracion = Duration.between(registroExistente.getHoraEntrada(), registroExistente.getHoraSalida());
                registroExistente.setDuracion(duracion);
            }
        }

        // Devolver la lista de registros únicos agrupados por fecha
        return new ArrayList<>(registrosUnicos.values());
    }

    // Método para convertir Date a LocalDateTime
    private LocalDateTime convertToLocalDateTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
