package shein.micro_correopedido.repository;

import shein.micro_correopedido.entity.CorreoPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorreoPedidoRepository extends JpaRepository<CorreoPedido, Integer> {
}
