package co.edu.unisabana.ReservaCitas.controlador;



import co.edu.unisabana.ReservaCitas.entidades.Servicio;
import co.edu.unisabana.ReservaCitas.services.ServicioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Data
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/servicios")
@Api(tags = "Servicios", description = "Operaciones de servicios")
public class ServicioControlador {

    private final ServicioService servicioService;

    public ServicioControlador(ServicioService servicioService) {
        this.servicioService = servicioService;
    }

    @ApiOperation("Obtener todos los servicios")
    @GetMapping
    public List<Servicio> getAllServicios()
    {
        return servicioService.getAllServicios();
    }

    @ApiOperation("Crear nueva servicio")
    @PostMapping
    public ResponseEntity<Servicio> crearServicio(@RequestBody Servicio servicio) {
        Servicio servicioCreado = servicioService.crearServicio(servicio);
        return new ResponseEntity<>(servicioCreado, HttpStatus.CREATED);
    }
    @DeleteMapping("/{servicioId}")
    public ResponseEntity<Void> eliminarServicio(@PathVariable Long servicioId) {
        servicioService.eliminarServicio(servicioId);
        return ResponseEntity.noContent().build();
    }
}