package co.edu.unisabana.ReservaCitas.entidades;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioTest {

    @Test
    void testGettersAndSetters() {
        // Arrange
        Servicio servicio = new Servicio();
        servicio.setIdServicio(1L);
        servicio.setNombre("Corte de cabello");
        servicio.setDescripcion("Corte de cabello para hombres");
        servicio.setDuracion(30);
        servicio.setPrecio(20.0);

        // Act & Assert
        assertEquals(1L, servicio.getIdServicio());
        assertEquals("Corte de cabello", servicio.getNombre());
        assertEquals("Corte de cabello para hombres", servicio.getDescripcion());
        assertEquals(30, servicio.getDuracion());
        assertEquals(20.0, servicio.getPrecio());
    }
}
