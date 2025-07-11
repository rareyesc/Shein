package shein.micro_genero.config;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Microservicio de Genero")
                        .version("1.0.0")
                        .description("API para gestionar los Géneros del E-Commerce"));
    }
}
