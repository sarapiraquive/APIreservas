package co.edu.unisabana.ReservaCitas.entidades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstilistaTest {

    private Estilista estilista;

    @BeforeEach
    void setUp() {
        estilista = new Estilista();
        estilista.setIdEstilista(1L);
        estilista.setNombre("Maria Gonzalez");
        estilista.setNacionalidad("Colombiana");
        estilista.setEspecialidad("Coloración");
    }

    @Test
    void testGettersAndSetters() {
        assertEquals(1L, estilista.getIdEstilista());
        assertEquals("Maria Gonzalez", estilista.getNombre());
        assertEquals("Colombiana", estilista.getNacionalidad());
        assertEquals("Coloración", estilista.getEspecialidad());
    }

    @Test
    void testNombreNotNull() {
        estilista.setNombre(null);
        assertNotNull(estilista.getNombre(), "El nombre del estilista no debería ser nulo");
    }

    @Test
    void testNacionalidadNotNull() {
        estilista.setNacionalidad(null);
        assertNotNull(estilista.getNacionalidad(), "La nacionalidad del estilista no debería ser nula");
    }

    @Test
    void testEspecialidadNotNull() {
        estilista.setEspecialidad(null);
        assertNotNull(estilista.getEspecialidad(), "La especialidad del estilista no debería ser nula");
    }
}
