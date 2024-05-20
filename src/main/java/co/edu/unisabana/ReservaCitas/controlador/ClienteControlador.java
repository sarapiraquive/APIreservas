package co.edu.unisabana.ReservaCitas.controlador;

import co.edu.unisabana.ReservaCitas.entidades.Cliente;
import co.edu.unisabana.ReservaCitas.services.ClienteService;
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
@RequestMapping("/clientes")
@Api(tags = "Clientes", description = "Operaciones de clientes")
public class ClienteControlador {

    private final ClienteService clienteService;

    public ClienteControlador(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @ApiOperation("Obtener todos los clientes")
    @GetMapping
    public List<Cliente> getAllClientes()
    {
        return clienteService.getAllCliente();
    }

    @ApiOperation("Crear nuevo cliente")
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
