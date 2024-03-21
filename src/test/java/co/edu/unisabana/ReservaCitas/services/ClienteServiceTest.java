package co.edu.unisabana.ReservaCitas.services;

import co.edu.unisabana.ReservaCitas.entidades.Cliente;
import co.edu.unisabana.ReservaCitas.repositorios.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    private ClienteService clienteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        clienteService = new ClienteService(clienteRepository);
    }

    @Test
    void DadoCliente_CuandoLlamaTodos_EntoncesDevuelveTodos() {
        List<Cliente> clientes = Arrays.asList(new Cliente(), new Cliente());
        when(clienteRepository.findAll()).thenReturn(clientes);

        List<Cliente> result = clienteService.getAllCliente();

        assertEquals(clientes, result);
    }

    @Test
    void DadoCliente_CuandoExisteID_EntoncesDevuelveCliente() {
        Long clienteId = 1L;
        Cliente cliente = new Cliente();
        when(clienteRepository.findById(clienteId)).thenReturn(Optional.of(cliente));

        Cliente result = clienteService.getClienteById(clienteId);

        assertEquals(cliente, result);
    }

    @Test
    void DadoCliente_CuandoNoExisteID_EntoncesDevuelveException() {

        Long clienteId = 1L;
        when(clienteRepository.findById(clienteId)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> clienteService.getClienteById(clienteId));
    }

    @Test
    void DadoCliente_CuandoSeCrea_EntoncesDevuelveNuevoCliente() {
        Cliente cliente = new Cliente();
        when(clienteRepository.save(cliente)).thenReturn(cliente);

        Cliente result = clienteService.crearCliente(cliente);

        assertEquals(cliente, result);

    }

    @Test
    void DadoCliente_CuandoSeElimina_EntoncesVerificaEliminado() {
        Long clienteId = 1L;

        clienteService.eliminarCliente(clienteId);

        verify(clienteRepository, times(1)).deleteById(clienteId);
    }
}