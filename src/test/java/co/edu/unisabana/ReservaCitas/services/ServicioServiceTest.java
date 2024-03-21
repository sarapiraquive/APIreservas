package co.edu.unisabana.ReservaCitas.services;

import co.edu.unisabana.ReservaCitas.entidades.Servicio;
import co.edu.unisabana.ReservaCitas.repositorios.ServicioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ServicioServiceTest {
    @Mock
    private ServicioRepository servicioRepository;

    private ServicioService servicioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        servicioService = new ServicioService(servicioRepository);
    }

    @Test
    void DadoServicio_CuandoLlamaTodos_EntoncesDevuelveTodos() {

        List<Servicio> servicios = Arrays.asList(new Servicio(), new Servicio());
        when(servicioRepository.findAll()).thenReturn(servicios);

        List<Servicio> result = servicioService.getAllServicios();

        assertEquals(servicios, result);
    }

    @Test
    void DadoServicio_CuandoExisteID_EntoncesDevuelveServicio() {

        Long servicioId = 1L;
        Servicio servicio = new Servicio();
        when(servicioRepository.findById(servicioId)).thenReturn(Optional.of(servicio));

        Servicio result = servicioService.getServicioById(servicioId);

        assertEquals(servicio, result);
    }

    @Test
    void DadoServicio_CuandoNoExisteID_EntoncesDevuelveException() {

        Long servicioId = 1L;
        when(servicioRepository.findById(servicioId)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> servicioService.getServicioById(servicioId));
    }

    @Test
    void DadoServicio_CuandoSeCrea_EntoncesDevuelveNuevoServicio() {

        Servicio servicio = new Servicio();
        when(servicioRepository.save(servicio)).thenReturn(servicio);

        Servicio result = servicioService.crearServicio(servicio);

        assertEquals(servicio, result);
    }

    @Test
    void DadoServicio_CuandoSeElimina_EntoncesVerificaEliminado() {

        Long servicioId = 1L;

        servicioService.eliminarServicio(servicioId);

        verify(servicioRepository, times(1)).deleteById(servicioId);
    }
}