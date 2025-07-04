package shein.micro_correopedido.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "correopedido")
@Data
@Schema(description = "Entidad que representa un correo que hizo un pedido")
public class CorreoPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del correo de pedido", example = "1")
    private Integer idCorreoPedido;

    @Column(name = "correo", nullable = false)
    @NotBlank(message = "El nombre del correo es obligatorio")
    @Schema(description = "Nombre del correo que hizo un pedido", example = "example@example.com")
    private String nombreCorreoPedido;
}
