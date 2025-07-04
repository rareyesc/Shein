package shein.micro_color;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "shein.micro_color")
public class MicroColorApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroColorApplication.class, args);
    }
}
