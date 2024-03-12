package co.edu.unisabana.ReservaCitas.Entidades;

import co.edu.unisabana.ReservaCitas.Entidades.Cita;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "servicios")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private int duracion;

    @Column(nullable = false)
    private double precio;

    @OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL)
    private List<Cita> citas;
}
