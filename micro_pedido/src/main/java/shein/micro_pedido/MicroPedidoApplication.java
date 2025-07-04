package shein.micro_pedido;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "shein.micro_pedido")
public class MicroPedidoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroPedidoApplication.class, args);
    }
}
