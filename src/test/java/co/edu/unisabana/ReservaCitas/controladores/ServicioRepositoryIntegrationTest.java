package co.edu.unisabana.ReservaCitas.controladores;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import co.edu.unisabana.ReservaCitas.entidades.Servicio;
import co.edu.unisabana.ReservaCitas.repositorios.ServicioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
public class ServicioRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ServicioRepository servicioRepository;

    @Test
    public void testGuardarYRecuperarServicio() {
        // Crear un nuevo servicio
        Servicio servicio = new Servicio();
        servicio.setNombre("Masaje relajante");
        servicio.setDescripcion("Masaje para relajar cuerpo y mente");
        servicio.setDuracion(60);
        servicio.setPrecio(50.0);

        // Guardar el servicio en la base de datos
        entityManager.persist(servicio);
        entityManager.flush();

        // Recuperar el servicio de la base de datos por su ID
        Servicio servicioRecuperado = servicioRepository.findById(servicio.getIdServicio()).orElse(null);

        // Verificar que el servicio recuperado no sea nulo
        assertNotNull(servicioRecuperado);

        // Verificar que los datos del servicio recuperado sean los mismos que los datos del servicio original
        assertEquals(servicio.getNombre(), servicioRecuperado.getNombre());
        assertEquals(servicio.getDescripcion(), servicioRecuperado.getDescripcion());
        assertEquals(servicio.getDuracion(), servicioRecuperado.getDuracion());
        assertEquals(servicio.getPrecio(), servicioRecuperado.getPrecio());
    }
}
