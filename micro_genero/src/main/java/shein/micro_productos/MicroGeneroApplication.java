package shein.micro_productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "shein.micro_productos")
public class MicroGeneroApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroGeneroApplication.class, args);
    }
}
