package co.edu.unisabana.ReservaCitas.Controlador;

import co.edu.unisabana.ReservaCitas.Entidades.Cita;
import co.edu.unisabana.ReservaCitas.Entidades.Cliente;
import co.edu.unisabana.ReservaCitas.Repositorios.CitaRepository;
import co.edu.unisabana.ReservaCitas.Services.CitaService;
import co.edu.unisabana.ReservaCitas.Services.ClienteService;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Data
@RestController
@RequestMapping("/clientes")
public class ClienteControlador {

    private final ClienteService clienteService;

    public ClienteControlador(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> getAllClientes()
    {
        return clienteService.getAllCliente();
    }
}