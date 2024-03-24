package co.edu.unisabana.ReservaCitas;

import co.edu.unisabana.ReservaCitas.config.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SwaggerConfig.class)
public class ReservaCitasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservaCitasApplication.class, args);
	}


}
