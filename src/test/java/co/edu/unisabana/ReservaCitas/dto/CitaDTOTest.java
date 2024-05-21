package co.edu.unisabana.ReservaCitas.dto;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.time.LocalDateTime;

public class CitaDTOTest {

    @Test
    public void testConstructor() {
        LocalDateTime fecha = LocalDateTime.now();
        ClienteDTO cliente = new ClienteDTO();
        EstilistaDTO estilista = new EstilistaDTO();
        ServicioDTO servicio = new ServicioDTO();

        CitaDTO cita = new CitaDTO();
        cita.setId(1L);
        cita.setFecha(fecha);
        cita.setCliente(cliente);
        cita.setEstilista(estilista);
        cita.setServicio(servicio);

        assertEquals(1L, cita.getId().longValue());
        assertEquals(fecha, cita.getFecha());
        assertEquals(cliente, cita.getCliente());
        assertEquals(estilista, cita.getEstilista());
        assertEquals(servicio, cita.getServicio());
    }
}
