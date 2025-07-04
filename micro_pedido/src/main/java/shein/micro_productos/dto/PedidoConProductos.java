package shein.micro_productos.dto;

import shein.micro_productos.entity.Pedido;
import shein.micro_productos.entity.ProductoPedido;
import lombok.Data;

import java.util.List;

@Data
public class PedidoConProductos {
    private Pedido pedido;
    private List<ProductoPedido> productos;
}
