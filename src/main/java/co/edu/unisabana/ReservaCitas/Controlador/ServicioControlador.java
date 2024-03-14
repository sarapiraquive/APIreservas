package co.edu.unisabana.ReservaCitas.Controlador;


import co.edu.unisabana.ReservaCitas.Entidades.Servicio;
import co.edu.unisabana.ReservaCitas.Services.ServicioService;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}