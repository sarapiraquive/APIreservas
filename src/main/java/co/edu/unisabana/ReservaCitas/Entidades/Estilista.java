package co.edu.unisabana.ReservaCitas.Entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "estilistas")
public class Estilista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String nacionalidad;

    @Column(nullable = false)
    private String especialidad;

    @OneToMany(mappedBy = "estilista", cascade = CascadeType.ALL)
    private List<Cita> citas;
}