package co.edu.unisabana.ReservaCitas.Repositorios;

import co.edu.unisabana.ReservaCitas.Entidades.Estilista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstilistaRepository extends JpaRepository<Estilista, Long> {
}
