package co.edu.unisabana.ReservaCitas.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EstilistaDTOTest {

    @Test
    void testGettersAndSetters() {
        Long id = 1L;
        String nombre = "Maria Gonzalez";
        String nacionalidad = "Colombiana";
        String especialidad = "Coloración";

        EstilistaDTO estilistaDTO = new EstilistaDTO();
        estilistaDTO.setId(id);
        estilistaDTO.setNombre(nombre);
        estilistaDTO.setNacionalidad(nacionalidad);
        estilistaDTO.setEspecialidad(especialidad);

        assertEquals(id, estilistaDTO.getId());
        assertEquals(nombre, estilistaDTO.getNombre());
        assertEquals(nacionalidad, estilistaDTO.getNacionalidad());
        assertEquals(especialidad, estilistaDTO.getEspecialidad());
    }
}
