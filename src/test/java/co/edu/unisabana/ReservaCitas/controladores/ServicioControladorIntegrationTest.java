package co.edu.unisabana.ReservaCitas.controladores;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import co.edu.unisabana.ReservaCitas.controlador.ServicioControlador;
import co.edu.unisabana.ReservaCitas.services.ServicioService;

@WebMvcTest(ServicioControlador.class)
public class ServicioControladorIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServicioService servicioService;

    @Test
    public void testCrearServicio() throws Exception {
        String servicioJson = "{\"nombre\":\"Servicio de coloración\", \"descripcion\":\"Coloración completa\", \"duracion\":\"60\", \"precio\":150000}";

        mockMvc.perform(post("/servicios/crear")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(servicioJson))
                .andDo(print())
                .andExpect(status().isCreated());
    }
}