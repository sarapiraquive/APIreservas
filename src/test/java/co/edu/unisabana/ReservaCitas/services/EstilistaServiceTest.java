package co.edu.unisabana.ReservaCitas.services;

import co.edu.unisabana.ReservaCitas.entidades.Estilista;
import co.edu.unisabana.ReservaCitas.repositorios.EstilistaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EstilistaServiceTest {

    @Mock
    private EstilistaRepository estilistaRepository;

    private EstilistaService estilistaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        estilistaService = new EstilistaService(estilistaRepository);
    }

    @Test
        void DadoEstilista_CuandoLlamaTodos_EntoncesDevuelveTodos() {

        List<Estilista> estilistas = Arrays.asList(new Estilista(), new Estilista());
        when(estilistaRepository.findAll()).thenReturn(estilistas);

        List<Estilista> result = estilistaService.getAllEstilistas();

        assertEquals(estilistas, result);
    }

    @Test
    void DadoEstilista_CuandoExisteID_EntoncesDevuelveEstilista() {

        Long estilistaId = 1L;
        Estilista estilista = new Estilista();
        when(estilistaRepository.findById(estilistaId)).thenReturn(Optional.of(estilista));

        Estilista result = estilistaService.getEstilistaById(estilistaId);

        assertEquals(estilista, result);
    }
    @Test
    void DadoEstilista_CuandoNoExisteID_EntoncesDevuelveException() {

        Long estilistaId = 1L;
        when(estilistaRepository.findById(estilistaId)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> estilistaService.getEstilistaById(estilistaId));
    }

    @Test
    void DadoEstilista_CuandoSeCrea_EntoncesDevuelveNuevoEstilista() {

        Estilista estilista = new Estilista();
        when(estilistaRepository.save(estilista)).thenReturn(estilista);

        Estilista result = estilistaService.crearEstilista(estilista);

        assertEquals(estilista, result);
    }

    @Test
    void DadoEstilista_CuandoSeElimina_EntoncesVerificaEliminado() {

        Long estilistaId = 1L;

        estilistaService.eliminarEstilista(estilistaId);

        verify(estilistaRepository, times(1)).deleteById(estilistaId);
    }
}