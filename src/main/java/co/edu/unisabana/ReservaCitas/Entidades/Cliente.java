package co.edu.unisabana.ReservaCitas.Entidades;

import jakarta.persistence.*;
import lombok.Data;


import java.util.List;

@Entity
@Table(name = "clientes")
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String correoElectronico;

    @Column(nullable = false)
    private String telefono;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Cita> citas;
}