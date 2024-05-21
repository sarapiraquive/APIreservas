package co.edu.unisabana.ReservaCitas.controladores;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import co.edu.unisabana.ReservaCitas.controlador.CitaControlador;
import co.edu.unisabana.ReservaCitas.dto.CambioFechaCitaDto;
import co.edu.unisabana.ReservaCitas.entidades.Cita;
import co.edu.unisabana.ReservaCitas.services.CitaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.time.LocalDateTime;
import java.util.Collections;

@WebMvcTest(CitaControlador.class)
public class CitaControladorIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CitaService citaService;

    @Test
    public void testCrearCita() throws Exception {
        Cita cita = new Cita();
        cita.setFechaHora(LocalDateTime.now());
        cita.setEstado("Programada");

        when(citaService.crearCita(any(Cita.class))).thenReturn(cita);

        mockMvc.perform(post("/citas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"fechaHora\":\"2024-05-20T12:00:00\",\"estado\":\"Programada\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.fechaHora").isString()) // Verifica que la fecha sea una cadena
                .andExpect(jsonPath("$.estado").value("Programada"));
    }

    @Test
    public void testCambiarFechaCita() throws Exception {
        CambioFechaCitaDto cambioFechaDto = new CambioFechaCitaDto();
        cambioFechaDto.setNuevaFecha(LocalDateTime.now().plusHours(1));

        Cita citaActualizada = new Cita();
        citaActualizada.setFechaHora(cambioFechaDto.getNuevaFecha());

        when(citaService.actualizarFechaCita(anyLong(), any(LocalDateTime.class))).thenReturn(citaActualizada);

        mockMvc.perform(put("/citas/1/cambiarFecha")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nuevaFecha\":\"2024-05-20T13:00:00\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fechaHora").isString()) // Verifica que la fecha sea una cadena
                .andExpect(jsonPath("$.estado").doesNotExist()); // No verificamos el estado en esta prueba
    }
}
