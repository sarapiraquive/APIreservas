package co.edu.unisabana.ReservaCitas.dto;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.math.BigDecimal;

public class ServicioDTOTest {

    @Test
    public void testConstructor() {
        Long id = 1L;
        String nombre = "Corte de pelo";
        BigDecimal precio = BigDecimal.valueOf(20.00);
        Integer duracion = 30;

        ServicioDTO servicio = new ServicioDTO();
        servicio.setId(id);
        servicio.setNombre(nombre);
        servicio.setPrecio(precio);
        servicio.setDuracion(duracion);

        assertEquals(id, servicio.getId());
        assertEquals(nombre, servicio.getNombre());
        assertEquals(precio, servicio.getPrecio());
        assertEquals(duracion, servicio.getDuracion());
    }
}
