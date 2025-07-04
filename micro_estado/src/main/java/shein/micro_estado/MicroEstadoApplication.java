package shein.micro_estado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "shein.micro_estado")
public class MicroEstadoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroEstadoApplication.class, args);
    }
}
