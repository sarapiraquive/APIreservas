package co.edu.unisabana.ReservaCitas.entidades;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EstilistaTest {

    @Test
    void testGettersAndSetters() {
        // Arrange
        Estilista estilista = new Estilista();
        estilista.setIdEstilista(1L);
        estilista.setNombre("Jane Doe");
        estilista.setNacionalidad("Estadounidense");
        estilista.setEspecialidad("Corte de cabello");

        // Act & Assert
        assertEquals(1L, estilista.getIdEstilista());
        assertEquals("Jane Doe", estilista.getNombre());
        assertEquals("Estadounidense", estilista.getNacionalidad());
        assertEquals("Corte de cabello", estilista.getEspecialidad());
    }
}
