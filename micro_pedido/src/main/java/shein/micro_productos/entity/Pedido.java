package shein.micro_productos.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

@Entity
@Table(name = "pedido")
@Data
@Schema(description = "Entidad que representa un pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del pedido", example = "1")
    private Integer idPedido;

    @Column(name = "numero_pedido", nullable = false)
    @NotBlank(message = "El número de pedido es obligatorio")
    @Schema(description = "Número del pedido", example = "PED-12345")
    private String numeroPedido;

    @Column(name = "fecha_pedido", nullable = false)
    @NotNull(message = "La fecha del pedido es obligatoria")
    @Schema(description = "Fecha del pedido", example = "2023-10-01")
    @Temporal(TemporalType.DATE)
    private Date fechaPedido;

    @Column(name = "fecha_llegada")
    @Schema(description = "Fecha de llegada del pedido", example = "2023-10-10")
    @Temporal(TemporalType.DATE)
    private Date fechaLlegada;

    @Column(name = "total_pedido")
    @Schema(description = "Total del pedido", example = "150.75")
    private Double totalPedido;

    @Column(name = "nota")
    @Schema(description = "Nota adicional sobre el pedido", example = "Entregar en horario laboral")
    private String nota;

    @Column(name = "id_correo_pedido", nullable = false)
    @NotNull(message = "El ID del correo es obligatorio")
    @Schema(description = "ID del correo asociado al pedido", example = "1")
    private Integer idCorreoPedido;
}
