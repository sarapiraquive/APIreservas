package co.edu.unisabana.ReservaCitas.Controlador;

import co.edu.unisabana.ReservaCitas.Entidades.Cita;
import co.edu.unisabana.ReservaCitas.Entidades.Cliente;
import co.edu.unisabana.ReservaCitas.Entidades.Estilista;
import co.edu.unisabana.ReservaCitas.Services.CitaService;
import co.edu.unisabana.ReservaCitas.Services.EstilistaService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/crear")
    public ResponseEntity<Estilista> crearEstilista(@RequestBody Estilista estilista) {
        Estilista estilistaCreado = estilistaService.crearEstilista(estilista);
        return new ResponseEntity<>(estilistaCreado, HttpStatus.CREATED);
    }
}