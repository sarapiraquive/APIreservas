package co.edu.unisabana.ReservaCitas.DTO;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CitaDTO {
    private Long id;
    private LocalDateTime fecha;
    private ClienteDTO cliente;
    private EstilistaDTO estilista;
    private ServicioDTO servicio;
}
