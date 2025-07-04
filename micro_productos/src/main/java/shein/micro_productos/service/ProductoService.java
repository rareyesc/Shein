package shein.micro_productos.service;

import shein.micro_productos.entity.Producto;
import java.util.List;

public interface ProductoService {
    List<Producto> obtenerTodosLosProductos();
    Producto obtenerProductoPorId(Integer id);
    Producto crearProducto(Producto producto);
    Producto actualizarProducto(Integer id, Producto producto);
    void eliminarProducto(Integer id);
    List<Producto> buscarProductosPorNombre(String nombre);
    Producto obtenerProductoPorSku(String sku);
}
