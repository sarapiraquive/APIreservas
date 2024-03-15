package co.edu.unisabana.ReservaCitas.Controlador;


import co.edu.unisabana.ReservaCitas.Entidades.Cliente;
import co.edu.unisabana.ReservaCitas.Entidades.Servicio;
import co.edu.unisabana.ReservaCitas.Services.ServicioService;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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