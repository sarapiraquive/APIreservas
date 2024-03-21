package co.edu.unisabana.ReservaCitas.services;

import co.edu.unisabana.ReservaCitas.entidades.Cita;
import co.edu.unisabana.ReservaCitas.entidades.Cliente;
import co.edu.unisabana.ReservaCitas.entidades.Estilista;
import co.edu.unisabana.ReservaCitas.entidades.Servicio;
import co.edu.unisabana.ReservaCitas.repositorios.CitaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CitaServiceTest {

    @Mock
    private CitaRepository citaRepository;

    private CitaService citaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        citaService = new CitaService(citaRepository);
    }

    @Test
    void DadaCita_CuandoSeCrea_EntoncesDevuelveNuevaCita() {

        List<Cita> citas = Arrays.asList(new Cita(), new Cita());
        when(citaRepository.findAll()).thenReturn(citas);

        List<Cita> result = citaService.getAllCitas();

        assertEquals(citas, result);
    }

    @Test
    void DadaCita_CuandoExisteID_EntoncesDevuelveCita() {

        Long citaId = 1L;
        Cita cita = new Cita();
        when(citaRepository.findById(citaId)).thenReturn(Optional.of(cita));

        Cita result = citaService.getCitaById(citaId);

        assertEquals(cita, result);
    }

    @Test
    void DadaCita_CuandoNoExisteID_EntoncesDevuelveException() {

        Long citaId = 1L;
        when(citaRepository.findById(citaId)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> citaService.getCitaById(citaId));
    }

    @Test
    void DadoCita_CuandoSeCrea_EntoncesDevuelveNuevaCita() {

        Cita cita = new Cita();
        when(citaRepository.save(cita)).thenReturn(cita);

        Cita result = citaService.crearCita(cita);

        assertEquals(cita, result);
    }

    @Test
    void DadaCita_CuandoSeElimina_EntoncesVerificaEliminado() {

        Long citaId = 1L;

        citaService.eliminarCita(citaId);

        verify(citaRepository, times(1)).deleteById(citaId);
    }

    @Test
    void DadaFechaCita_CuandoActualiza_EntoncesDevuelveFechaActualizada() {

        Long citaId = 1L;
        LocalDateTime nuevaFecha = LocalDateTime.now();
        Cita cita = new Cita();
        when(citaRepository.findById(citaId)).thenReturn(Optional.of(cita));
        when(citaRepository.save(cita)).thenReturn(cita);

        Cita result = citaService.actualizarFechaCita(citaId, nuevaFecha);

        assertEquals(nuevaFecha, result.getFechaHora());
    }
}