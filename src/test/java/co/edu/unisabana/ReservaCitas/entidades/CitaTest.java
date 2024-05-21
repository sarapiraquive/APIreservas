package co.edu.unisabana.ReservaCitas.entidades;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CitaTest {

    @Test
    void testGettersAndSetters() {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(1);

        Estilista estilista = new Estilista();
        estilista.setIdEstilista(1L);

        Servicio servicio = new Servicio();
        servicio.setIdServicio(1L);

        LocalDateTime fechaHora = LocalDateTime.now();
        String estado = "Agendada";

        Cita cita = new Cita();
        cita.setIdCita(1);
        cita.setCliente(cliente);
        cita.setEstilista(estilista);
        cita.setServicio(servicio);
        cita.setFechaHora(fechaHora);
        cita.setEstado(estado);

        assertEquals(1, cita.getIdCita());
        assertEquals(cliente, cita.getCliente());
        assertEquals(estilista, cita.getEstilista());
        assertEquals(servicio, cita.getServicio());
        assertEquals(fechaHora, cita.getFechaHora());
        assertEquals(estado, cita.getEstado());
    }
}
