package co.edu.unisabana.ReservaCitas.Services;

import co.edu.unisabana.ReservaCitas.Entidades.Estilista;
import co.edu.unisabana.ReservaCitas.Repositorios.EstilistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstilistaService {
    private final EstilistaRepository estilistaRepository;

    public EstilistaService(EstilistaRepository estilistaRepository) {
        this.estilistaRepository = estilistaRepository;
    }

    public List<Estilista> getAllEstilistas() {
        return estilistaRepository.findAll();
    }

    public Estilista getEstilistaById(Long estilistaId) {
        return estilistaRepository.findById(estilistaId)
                .orElseThrow(() -> new RuntimeException("Estilista no encontrado con ID: " + estilistaId));
    }

    public Estilista crearEstilista(Estilista estilista) {
        return estilistaRepository.save(estilista);
    }

    public void eliminarEstilista(Long estilistaId) {
        estilistaRepository.deleteById(estilistaId);
    }
}
