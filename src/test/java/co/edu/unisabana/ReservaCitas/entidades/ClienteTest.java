package co.edu.unisabana.ReservaCitas.entidades;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteTest {

    @Test
    void testGettersAndSetters() {
        // Arrange
        Cliente cliente = new Cliente();
        cliente.setIdCliente(1);
        cliente.setNombre("John Doe");
        cliente.setCorreoElectronico("john.doe@example.com");
        cliente.setTelefono(123456789);

        // Act & Assert
        assertEquals(1, cliente.getIdCliente());
        assertEquals("John Doe", cliente.getNombre());
        assertEquals("john.doe@example.com", cliente.getCorreoElectronico());
        assertEquals(123456789, cliente.getTelefono());
    }
}