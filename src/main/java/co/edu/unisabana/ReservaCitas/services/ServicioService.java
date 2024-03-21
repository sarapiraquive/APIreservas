package co.edu.unisabana.ReservaCitas.services;


import co.edu.unisabana.ReservaCitas.entidades.Servicio;
import co.edu.unisabana.ReservaCitas.repositorios.ServicioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioService {
    private final ServicioRepository servicioRepository;

    public ServicioService(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    public List<Servicio> getAllServicios() {
        return servicioRepository.findAll();
    }

    public Servicio getServicioById(Long servicioId) {
        return servicioRepository.findById(servicioId)
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado con ID: " + servicioId));
    }

    public Servicio crearServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    public void eliminarServicio(Long servicioId) {
        servicioRepository.deleteById(servicioId);
    }
}