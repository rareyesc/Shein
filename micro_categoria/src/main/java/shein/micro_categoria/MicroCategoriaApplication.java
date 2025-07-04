package shein.micro_categoria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "shein.micro_categoria")
public class MicroCategoriaApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroCategoriaApplication.class, args);
    }
}
