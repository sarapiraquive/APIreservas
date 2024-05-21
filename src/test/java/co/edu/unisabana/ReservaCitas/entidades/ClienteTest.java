package co.edu.unisabana.ReservaCitas.entidades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        cliente = new Cliente();
        cliente.setIdCliente(1);
        cliente.setNombre("Juan Perez");
        cliente.setCorreoElectronico("juan.perez@example.com");
        cliente.setTelefono(123456789);
    }

    @Test
    void testGettersAndSetters() {
        assertEquals(1, cliente.getIdCliente());
        assertEquals("Juan Perez", cliente.getNombre());
        assertEquals("juan.perez@example.com", cliente.getCorreoElectronico());
        assertEquals(123456789, cliente.getTelefono());
    }

    @Test
    void testNombreNotNull() {
        cliente.setNombre(null);
        assertNotNull(cliente.getNombre(), "El nombre del cliente no debería ser nulo");
    }

    @Test
    void testTelefonoNotNull() {
        cliente.setTelefono(0); // O algún otro valor que consideres no válido
        assertTrue(cliente.getTelefono() > 0, "El teléfono del cliente debería ser mayor que cero");
    }

    @Test
    void testCorreoElectronicoNull() {
        cliente.setCorreoElectronico(null);
        assertNull(cliente.getCorreoElectronico(), "El correo electrónico del cliente debería ser nulo si no se proporciona");
    }
}
