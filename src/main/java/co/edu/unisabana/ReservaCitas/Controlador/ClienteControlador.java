package co.edu.unisabana.ReservaCitas.Controlador;

import co.edu.unisabana.ReservaCitas.DTO.ClienteDTO;
import co.edu.unisabana.ReservaCitas.Entidades.Cita;
import co.edu.unisabana.ReservaCitas.Entidades.Cliente;
import co.edu.unisabana.ReservaCitas.Repositorios.CitaRepository;
import co.edu.unisabana.ReservaCitas.Services.CitaService;
import co.edu.unisabana.ReservaCitas.Services.ClienteService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/crear")
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        Cliente clienteCreado = clienteService.crearCliente(cliente);
        return new ResponseEntity<>(clienteCreado, HttpStatus.CREATED);
    }
}
