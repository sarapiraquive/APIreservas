package co.edu.unisabana.ReservaCitas.dto;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.time.LocalDateTime;

public class CambioFechaCitaDtoTest {

    @Test
    public void testConstructor() {
        LocalDateTime nuevaFecha = LocalDateTime.of(2024, 5, 20, 10, 0);

        CambioFechaCitaDto cambioFecha = new CambioFechaCitaDto();
        cambioFecha.setNuevaFecha(nuevaFecha);

        assertEquals(nuevaFecha, cambioFecha.getNuevaFecha());
    }
}
