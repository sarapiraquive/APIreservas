package co.edu.unisabana.ReservaCitas.controladores;

import co.edu.unisabana.ReservaCitas.controlador.CitaControlador;
import com.fasterxml.jackson.databind.ObjectMapper;
import co.edu.unisabana.ReservaCitas.dto.CambioFechaCitaDto;
import co.edu.unisabana.ReservaCitas.entidades.Cita;
import co.edu.unisabana.ReservaCitas.services.CitaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CitaControlador.class)

public class CitaControladorIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CitaService citaService;

    @Autowired
    private ObjectMapper objectMapper;

    private Cita cita;



    @Test
    public void testCrearCita() throws Exception {
        Mockito.when(citaService.crearCita(Mockito.any(Cita.class))).thenReturn(cita);

        mockMvc.perform(post("/citas/crear")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cita)))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void testCambiarFechaCita() throws Exception {
        CambioFechaCitaDto cambioFechaDto = new CambioFechaCitaDto();
        cambioFechaDto.setNuevaFecha(LocalDate.now().atStartOfDay());

        Mockito.when(citaService.actualizarFechaCita(Mockito.anyLong(), Mockito.any(LocalDate.class).atStartOfDay())).thenReturn(cita);

        mockMvc.perform(put("/citas/{id}/cambiarFecha", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cambioFechaDto)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testEliminarCita() throws Exception {
        Mockito.doNothing().when(citaService).eliminarCita(Mockito.anyLong());

        mockMvc.perform(delete("/citas/eliminar/{citaId}", 1))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}