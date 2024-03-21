package co.edu.unisabana.ReservaCitas.repositorios;

import co.edu.unisabana.ReservaCitas.entidades.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
}
