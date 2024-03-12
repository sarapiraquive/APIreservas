package co.edu.unisabana.ReservaCitas.Controlador;

import co.edu.unisabana.ReservaCitas.Entidades.Cita;
import co.edu.unisabana.ReservaCitas.Repositorios.CitaRepository;
import co.edu.unisabana.ReservaCitas.Services.CitaService;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Data
@RestController
@RequestMapping("/citas")
public class CitaControlador {

    private final CitaService citaService;

    public CitaControlador(CitaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping
    public List<Cita> getAllCitas()
    {
        return CitaService.getAllCitas();
    }
}
