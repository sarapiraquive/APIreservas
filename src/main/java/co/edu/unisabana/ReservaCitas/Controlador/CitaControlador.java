package co.edu.unisabana.ReservaCitas.Controlador;

import co.edu.unisabana.ReservaCitas.Entidades.Cita;
import co.edu.unisabana.ReservaCitas.Entidades.Cliente;
import co.edu.unisabana.ReservaCitas.Services.CitaService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return citaService.getAllCitas();
    }
    @PostMapping("/crear")
    public ResponseEntity<Cita> crearCita(@RequestBody Cita cita) {
        Cita citaCreada = citaService.crearCita(cita);
        return new ResponseEntity<>(citaCreada, HttpStatus.CREATED);
    }
    @DeleteMapping("/eliminar/{citaId}")
    public ResponseEntity<Void> eliminarCita(@PathVariable Long citaId) {
        citaService.eliminarCita(citaId);
        return ResponseEntity.noContent().build();
    }
}