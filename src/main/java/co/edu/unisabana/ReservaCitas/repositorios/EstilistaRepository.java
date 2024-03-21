package co.edu.unisabana.ReservaCitas.repositorios;

import co.edu.unisabana.ReservaCitas.entidades.Estilista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstilistaRepository extends JpaRepository<Estilista, Long> {
}
