package co.edu.unisabana.ReservaCitas.controlador;

import co.edu.unisabana.ReservaCitas.dto.CambioFechaCitaDto;
import co.edu.unisabana.ReservaCitas.entidades.Cita;
import co.edu.unisabana.ReservaCitas.services.CitaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@Data
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/citas")
@Api(tags = "Citas", description = "Operaciones de citas")
public class CitaControlador {

    private final CitaService citaService;

    public CitaControlador(CitaService citaService) {
        this.citaService = citaService;
    }

    @ApiOperation("Obtener todas las citas")
    @GetMapping
    public List<Cita> getAllCitas()
    {
        return citaService.getAllCitas();
    }

    @ApiOperation("Crear nueva cita")
    @PostMapping
    public ResponseEntity<Cita> crearCita(@RequestBody Cita cita) {
        Cita citaCreada = citaService.crearCita(cita);
        return new ResponseEntity<>(citaCreada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/cambiarFecha")
    public ResponseEntity<Cita> cambiarFechaCita(@PathVariable Long id, @RequestBody CambioFechaCitaDto cambioFechaDto) {
        Cita citaActualizada = citaService.actualizarFechaCita(id, cambioFechaDto.getNuevaFecha());
        return ResponseEntity.ok(citaActualizada);
    }
    @DeleteMapping("/eliminar/{citaId}")
    public ResponseEntity<Void> eliminarCita(@PathVariable Long citaId) {
        citaService.eliminarCita(citaId);
        return ResponseEntity.noContent().build();

    }
}