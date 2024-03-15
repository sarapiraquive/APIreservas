package co.edu.unisabana.ReservaCitas.Entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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