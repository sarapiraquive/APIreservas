package co.edu.unisabana.ReservaCitas.Controlador;

import co.edu.unisabana.ReservaCitas.Entidades.Cita;
import co.edu.unisabana.ReservaCitas.Entidades.Estilista;
import co.edu.unisabana.ReservaCitas.Services.CitaService;
import co.edu.unisabana.ReservaCitas.Services.EstilistaService;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Data
@RestController
@RequestMapping("/estilistas")
public class EstilistaControlador {

    private final EstilistaService estilistaService;

    public EstilistaControlador(EstilistaService estilistaService) {
        this.estilistaService = estilistaService;
    }

    @GetMapping
    public List<Estilista> getAllEstilistas()
    {
        return estilistaService.getAllEstilistas();
    }
}