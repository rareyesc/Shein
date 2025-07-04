package shein.micro_pedido.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "producto_pedido")
@Data
@Schema(description = "Entidad que representa la relación entre productos y pedidos")
public class ProductoPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único de la relación", example = "1")
    private Integer id;

    @Column(name = "id_pedido", nullable = false)
    @NotNull(message = "El ID del pedido es obligatorio")
    @Schema(description = "ID del pedido", example = "1")
    private Integer idPedido;

    @Column(name = "id_producto", nullable = false)
    @NotNull(message = "El ID del producto es obligatorio")
    @Schema(description = "ID del producto", example = "1")
    private Integer idProducto;

    @Column(name = "cantidad", nullable = false)
    @NotNull(message = "La cantidad es obligatoria")
    @Schema(description = "Cantidad del producto en el pedido", example = "2")
    private Integer cantidad;

    @Column(name = "precio", nullable = false)
    @NotNull(message = "El precio es obligatorio")
    @Schema(description = "Precio unitario del producto en el pedido", example = "50.00")
    private Double precio;
}
