package co.edu.unisabana.ReservaCitas.Services;

import co.edu.unisabana.ReservaCitas.Entidades.Cita;
import co.edu.unisabana.ReservaCitas.Repositorios.CitaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CitaService {
    private final CitaRepository citaRepository;

    public CitaService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public List<Cita> getAllCitas() {
        return citaRepository.findAll();
    }

    public Cita getCitaById(Long citaId) {
        return citaRepository.findById(citaId)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada con ID: " + citaId));
    }

    public Cita crearCita(Cita cita) {
        return citaRepository.save(cita);
    }

    public void eliminarCita(Long citaId) {
        citaRepository.deleteById(citaId);
    }

    public Cita actualizarFechaCita(Long citaId, LocalDateTime nuevaFecha) {
        Cita cita = citaRepository.findById(citaId).orElseThrow(() -> new EntityNotFoundException("Cita no encontrada"));
        cita.setFechaHora(nuevaFecha);
        return citaRepository.save(cita);
    }
}
