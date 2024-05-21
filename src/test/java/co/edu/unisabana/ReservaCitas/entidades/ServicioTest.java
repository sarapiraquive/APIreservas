package co.edu.unisabana.ReservaCitas.entidades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicioTest {

    private Servicio servicio;

    @BeforeEach
    void setUp() {
        servicio = new Servicio();
        servicio.setIdServicio(1L);
        servicio.setNombre("Corte de pelo");
        servicio.setDescripcion("Corte de cabello estándar");
        servicio.setDuracion(30);
        servicio.setPrecio(20.0);
    }

    @Test
    void testGettersAndSetters() {
        assertEquals(1L, servicio.getIdServicio());
        assertEquals("Corte de pelo", servicio.getNombre());
        assertEquals("Corte de cabello estándar", servicio.getDescripcion());
        assertEquals(30, servicio.getDuracion());
        assertEquals(20.0, servicio.getPrecio());
    }

    @Test
    void testNombreNotNull() {
        servicio.setNombre(null);
        assertNotNull(servicio.getNombre(), "El nombre del servicio no debería ser nulo");
    }

    @Test
    void testDescripcionNotNull() {
        servicio.setDescripcion(null);
        assertNotNull(servicio.getDescripcion(), "La descripción del servicio no debería ser nula");
    }

    @Test
    void testDuracionPositive() {
        servicio.setDuracion(-10);
        assertTrue(servicio.getDuracion() > 0, "La duración del servicio debería ser positiva");
    }

    @Test
    void testPrecioPositive() {
        servicio.setPrecio(-15.0);
        assertTrue(servicio.getPrecio() > 0, "El precio del servicio debería ser positivo");
    }
}
