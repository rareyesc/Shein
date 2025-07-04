package shein.micro_genero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "shein.micro_genero")
public class MicroGeneroApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroGeneroApplication.class, args);
    }
}
