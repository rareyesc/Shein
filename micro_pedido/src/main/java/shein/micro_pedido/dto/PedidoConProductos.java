package shein.micro_pedido.dto;

import shein.micro_pedido.entity.Pedido;
import shein.micro_pedido.entity.ProductoPedido;
import lombok.Data;

import java.util.List;

@Data
public class PedidoConProductos {
    private Pedido pedido;
    private List<ProductoPedido> productos;
}
