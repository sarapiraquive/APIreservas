package co.edu.unisabana.ReservaCitas.controlador;



import co.edu.unisabana.ReservaCitas.entidades.Servicio;
import co.edu.unisabana.ReservaCitas.services.ServicioService;

import lombok.Data;


import java.util.List;

@Data
@RestController
@RequestMapping("/servicios")
public class ServicioControlador {

    private final ServicioService servicioService;

    public ServicioControlador(ServicioService servicioService) {
        this.servicioService = servicioService;
    }

    @GetMapping
    public List<Servicio> getAllServicios()
    {
        return servicioService.getAllServicios();
    }
    @PostMapping("/crear")
    public ResponseEntity<Servicio> crearServicio(@RequestBody Servicio servicio) {
        Servicio servicioCreado = servicioService.crearServicio(servicio);
        return new ResponseEntity<>(servicioCreado, HttpStatus.CREATED);
    }
    @DeleteMapping("/eliminar/{servicioId}")
    public ResponseEntity<Void> eliminarServicio(@PathVariable Long servicioId) {
        servicioService.eliminarServicio(servicioId);
        return ResponseEntity.noContent().build();
    }
}