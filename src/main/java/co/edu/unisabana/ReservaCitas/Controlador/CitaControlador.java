package co.edu.unisabana.ReservaCitas.Controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador {
    @GetMapping("/")
    public String hello() {
        return "Hello, World!";
    }
}
