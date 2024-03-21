package co.edu.unisabana.ReservaCitas.dto;

import lombok.Data;

@Data
public class ClienteDTO {
    private Long id;
    private String nombre;
    private String correo;
    private Integer telefono;
}
