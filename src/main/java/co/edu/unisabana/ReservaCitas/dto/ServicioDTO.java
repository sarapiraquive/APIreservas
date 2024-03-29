package co.edu.unisabana.ReservaCitas.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ServicioDTO {
    private Long id;
    private String nombre;
    private BigDecimal precio;
    private Integer duracion;
}
