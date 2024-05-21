package co.edu.unisabana.ReservaCitas.controladores;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import co.edu.unisabana.ReservaCitas.controlador.ClienteControlador;
import co.edu.unisabana.ReservaCitas.entidades.Cliente;
import co.edu.unisabana.ReservaCitas.services.ClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Collections;

@WebMvcTest(ClienteControlador.class)
public class ClienteControladorIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteService clienteService;

    @Test
    public void testGetAllClientes() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(1);
        cliente.setNombre("Juan");
        cliente.setCorreoElectronico("juan@example.com");
        cliente.setTelefono(123456789);

        when(clienteService.getAllCliente()).thenReturn(Collections.singletonList(cliente));

        mockMvc.perform(get("/clientes")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").value("Juan"))
                .andExpect(jsonPath("$[0].correoElectronico").value("juan@example.com"))
                .andExpect(jsonPath("$[0].telefono").value(123456789));
    }

    @Test
    public void testCrearCliente() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setNombre("Maria");
        cliente.setCorreoElectronico("maria@example.com");
        cliente.setTelefono(987654321);

        when(clienteService.crearCliente(any(Cliente.class))).thenReturn(cliente);

        mockMvc.perform(post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nombre\":\"Maria\",\"correoElectronico\":\"maria@example.com\",\"telefono\":987654321}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nombre").value("Maria"))
                .andExpect(jsonPath("$.correoElectronico").value("maria@example.com"))
                .andExpect(jsonPath("$.telefono").value(987654321));
    }

    @Test
    public void testEliminarCliente() throws Exception {
        mockMvc.perform(delete("/clientes/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(clienteService, times(1)).eliminarCliente(1L);
    }
}
