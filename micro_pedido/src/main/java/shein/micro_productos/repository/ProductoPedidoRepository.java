package shein.micro_productos.repository;

import shein.micro_productos.entity.ProductoPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoPedidoRepository extends JpaRepository<ProductoPedido, Integer> {
    List<ProductoPedido> findByIdPedido(Integer idPedido);
}
