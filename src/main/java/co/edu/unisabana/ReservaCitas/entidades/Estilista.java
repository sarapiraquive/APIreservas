package co.edu.unisabana.ReservaCitas.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "estilistas")
@Data
public class Estilista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstilista;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String nacionalidad;

    @Column(nullable = false)
    private String especialidad;


}