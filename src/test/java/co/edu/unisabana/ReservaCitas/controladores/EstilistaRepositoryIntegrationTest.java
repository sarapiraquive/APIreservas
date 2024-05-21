package co.edu.unisabana.ReservaCitas.controladores;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import co.edu.unisabana.ReservaCitas.entidades.Estilista;
import co.edu.unisabana.ReservaCitas.repositorios.EstilistaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
public class EstilistaRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EstilistaRepository estilistaRepository;

    @Test
    public void testGuardarYRecuperarEstilista() {
        // Crear un nuevo estilista
        Estilista estilista = new Estilista();
        estilista.setNombre("Juan Pérez");
        estilista.setNacionalidad("Colombiano");
        estilista.setEspecialidad("Corte de cabello");

        // Guardar el estilista en la base de datos
        entityManager.persist(estilista);
        entityManager.flush();

        // Recuperar el estilista de la base de datos por su ID
        Estilista estilistaRecuperado = estilistaRepository.findById(estilista.getIdEstilista()).orElse(null);

        // Verificar que el estilista recuperado no sea nulo
        assertNotNull(estilistaRecuperado);

        // Verificar que los datos del estilista recuperado sean los mismos que los datos del estilista original
        assertEquals(estilista.getNombre(), estilistaRecuperado.getNombre());
        assertEquals(estilista.getNacionalidad(), estilistaRecuperado.getNacionalidad());
        assertEquals(estilista.getEspecialidad(), estilistaRecuperado.getEspecialidad());
    }
}
