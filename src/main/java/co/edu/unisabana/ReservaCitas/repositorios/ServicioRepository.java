package co.edu.unisabana.ReservaCitas.repositorios;

import co.edu.unisabana.ReservaCitas.entidades.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Long> {
}
