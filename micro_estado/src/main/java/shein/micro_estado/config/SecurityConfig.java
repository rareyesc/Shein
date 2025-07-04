package shein.micro_estado.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Leemos las propiedades desde el application.properties
    @Value("${spring.mvc.cors.allowed-origins}")
    private String allowedOrigins;

    @Value("${spring.mvc.cors.allowed-methods}")
    private String allowedMethods;

    @Value("${spring.mvc.cors.allowed-headers}")
    private String allowedHeaders;

    @Value("${spring.mvc.cors.allow-credentials}")
    private boolean allowCredentials;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Habilitamos CORS (y usará nuestro corsConfigurationSource)
                .cors(Customizer.withDefaults())

                // Deshabilitamos CSRF si tu API no requiere manejo de formularios
                .csrf(AbstractHttpConfigurer::disable)

                // Configuramos las reglas de autorización
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
                );

        // Construimos el HttpSecurity final
        return http.build();
    }

    /**
     * Define la fuente de configuración de CORS, usando las propiedades
     * leídas de application.properties.
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        // Parseamos las cadenas (allowedMethods, allowedHeaders, allowedOrigins)
        // para convertirlas en listas.
        List<String> originsList = Arrays.asList(allowedOrigins.split(","));
        List<String> methodsList = Arrays.asList(allowedMethods.split(","));
        List<String> headersList = Arrays.asList(allowedHeaders.split(","));

        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(originsList);
        configuration.setAllowedMethods(methodsList);
        configuration.setAllowedHeaders(headersList);
        configuration.setAllowCredentials(allowCredentials);

        configuration.setMaxAge(3600L); // 1 hora

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}
