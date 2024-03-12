package co.edu.unisabana.ReservaCitas.DTO;

import java.time.LocalDateTime;

public class CitaDTO {
    private Long id;
    private LocalDateTime fecha;
    private ClienteDTO cliente;
    private EstilistaDTO estilista;
    private ServicioDTO servicio;
}
