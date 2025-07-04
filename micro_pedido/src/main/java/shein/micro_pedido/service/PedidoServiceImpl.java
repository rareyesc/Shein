package shein.micro_pedido.service;

import shein.micro_pedido.entity.Pedido;
import shein.micro_pedido.entity.ProductoPedido;
import shein.micro_pedido.exception.ResourceNotFoundException;
import shein.micro_pedido.repository.PedidoRepository;
import shein.micro_pedido.repository.ProductoPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProductoPedidoRepository productoPedidoRepository;

    @Override
    public List<Pedido> obtenerTodosLosPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido obtenerPedidoPorId(Integer id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado con ID: " + id));
    }

    @Override
    @Transactional
    public Pedido crearPedido(Pedido pedido, List<ProductoPedido> productos) {
        Pedido nuevoPedido = pedidoRepository.save(pedido);
        for (ProductoPedido productoPedido : productos) {
            productoPedido.setIdPedido(nuevoPedido.getIdPedido());
            productoPedidoRepository.save(productoPedido);
        }
        return nuevoPedido;
    }

    @Override
    @Transactional
    public Pedido actualizarPedido(Integer id, Pedido detallesPedido, List<ProductoPedido> productos) {
        Pedido pedido = obtenerPedidoPorId(id);
        pedido.setNumeroPedido(detallesPedido.getNumeroPedido());
        pedido.setFechaPedido(detallesPedido.getFechaPedido());
        pedido.setFechaLlegada(detallesPedido.getFechaLlegada());
        pedido.setTotalPedido(detallesPedido.getTotalPedido());
        pedido.setNota(detallesPedido.getNota());
        pedido.setIdCorreoPedido(detallesPedido.getIdCorreoPedido());
        Pedido pedidoActualizado = pedidoRepository.save(pedido);

        // Actualizar productos asociados
        productoPedidoRepository.deleteAll(productoPedidoRepository.findByIdPedido(id));
        for (ProductoPedido productoPedido : productos) {
            productoPedido.setIdPedido(id);
            productoPedidoRepository.save(productoPedido);
        }

        return pedidoActualizado;
    }

    @Override
    @Transactional
    public void eliminarPedido(Integer id) {
        Pedido pedido = obtenerPedidoPorId(id);
        // Eliminar productos asociados
        productoPedidoRepository.deleteAll(productoPedidoRepository.findByIdPedido(id));
        pedidoRepository.delete(pedido);
    }

    @Override
    public List<ProductoPedido> obtenerProductosPorPedido(Integer idPedido) {
        return productoPedidoRepository.findByIdPedido(idPedido);
    }
}
