package co.edu.unisabana.ReservaCitas.Repositorios;

import co.edu.unisabana.ReservaCitas.Entidades.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Long> {
}
