package shein.micro_pedido.service;

import shein.micro_pedido.entity.Pedido;
import shein.micro_pedido.entity.ProductoPedido;
import java.util.List;

public interface PedidoService {
    List<Pedido> obtenerTodosLosPedidos();
    Pedido obtenerPedidoPorId(Integer id);
    Pedido crearPedido(Pedido pedido, List<ProductoPedido> productos);
    Pedido actualizarPedido(Integer id, Pedido pedido, List<ProductoPedido> productos);
    void eliminarPedido(Integer id);
    List<ProductoPedido> obtenerProductosPorPedido(Integer idPedido);
}
