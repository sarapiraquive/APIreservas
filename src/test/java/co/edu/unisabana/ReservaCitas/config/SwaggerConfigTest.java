package co.edu.unisabana.ReservaCitas.config;

import org.junit.jupiter.api.Test;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SwaggerConfigTest {

    @Test
    void testSwaggerDocketConfiguration() {
        SwaggerConfig swaggerConfig = new SwaggerConfig();
        Docket docket = swaggerConfig.api();

        assertNotNull(docket);
        assertEquals(DocumentationType.SWAGGER_2, docket.getDocumentationType());

        // Verificar la configuración del paquete base
        String basePackage = "co.edu.unisabana.ReservaCitas.controlador";
        assertEquals(basePackage, swaggerConfig.basePackage);

        // Verificar la información de la API sin usar getApiInfo()
        ApiInfo expectedApiInfo = new ApiInfoBuilder()
                .title("API de Reservas de Citas")
                .description("API para realizar reservas de citas en línea")
                .version("1.0")
                .build();
        assertEquals(expectedApiInfo.getTitle(), swaggerConfig.apiTitle);
        assertEquals(expectedApiInfo.getDescription(), swaggerConfig.apiDescription);
        assertEquals(expectedApiInfo.getVersion(), swaggerConfig.apiVersion);
    }
}
