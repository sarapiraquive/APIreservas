package co.edu.unisabana.ReservaCitas.controlador;

import co.edu.unisabana.ReservaCitas.entidades.Cliente;
import co.edu.unisabana.ReservaCitas.services.ClienteService;
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

    @PostMapping
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        Cliente clienteCreado = clienteService.crearCliente(cliente);
        return new ResponseEntity<>(clienteCreado, HttpStatus.CREATED);
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long clienteId) {
        clienteService.eliminarCliente(clienteId);
        return ResponseEntity.noContent().build();
    }
}
