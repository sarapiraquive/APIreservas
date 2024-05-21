package co.edu.unisabana.ReservaCitas.dto;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ClienteDTOTest {

    @Test
    public void testConstructor() {
        Long id = 1L;
        String nombre = "Juan";
        String correo = "juan@example.com";
        Integer telefono = 123456789;

        ClienteDTO cliente = new ClienteDTO();
        cliente.setId(id);
        cliente.setNombre(nombre);
        cliente.setCorreo(correo);
        cliente.setTelefono(telefono);

        assertEquals(id, cliente.getId());
        assertEquals(nombre, cliente.getNombre());
        assertEquals(correo, cliente.getCorreo());
        assertEquals(telefono, cliente.getTelefono());
    }
}
