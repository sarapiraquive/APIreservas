package co.edu.unisabana.ReservaCitas.controladores;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EstilistaControladorIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCrearEstilista() throws Exception {

        String estilistaJson = "{\"nombre\":\"Juan Perez\", \"nacionalidad\":\"Colombiana\", \"especialidad\":\"Corte de cabello\"}";
        mockMvc.perform(post("/estilistas/crear")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(estilistaJson))
                .andDo(print())
                .andExpect(status().isCreated());
    }
}