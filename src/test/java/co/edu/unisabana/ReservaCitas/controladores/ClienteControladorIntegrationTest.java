package co.edu.unisabana.ReservaCitas.controladores;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc

public class ClienteControladorIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllClientes() throws Exception {
        mockMvc.perform(get("/clientes")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testCrearCliente() throws Exception {
        String nuevoClienteJson = "{\"nombre\":\"John Doe\", \"email\":\"john@example.com\", \"telefono\":\"1234567890\"}";
        mockMvc.perform(post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(nuevoClienteJson))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void testEliminarCliente() throws Exception {
        // Asegúrate de que el cliente con este ID exista para que la prueba pase
        Long clienteId = 1L;
        mockMvc.perform(delete("/clientes/{clienteId}", clienteId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}