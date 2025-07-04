package shein.micro_pedido.repository;

import shein.micro_pedido.entity.ProductoPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoPedidoRepository extends JpaRepository<ProductoPedido, Integer> {
    List<ProductoPedido> findByIdPedido(Integer idPedido);
}
