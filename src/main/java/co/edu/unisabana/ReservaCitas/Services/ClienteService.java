package co.edu.unisabana.ReservaCitas.Services;

import co.edu.unisabana.ReservaCitas.DTO.ClienteDTO;
import co.edu.unisabana.ReservaCitas.Entidades.Cliente;
import co.edu.unisabana.ReservaCitas.Repositorios.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente getClienteById(Long clienteId) {
        return clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + clienteId));
    }

    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void eliminarCliente(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }
    public List<Cliente> getAllCliente() {
        return clienteRepository.findAll();
    }
}
