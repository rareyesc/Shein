package shein.micro_productos.repository;

import shein.micro_productos.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    // Buscar por nombre del producto
    List<Producto> findByNombreProductoContaining(String nombreProducto);

    // Buscar por SKU
    Producto findBySku(String sku);
}
