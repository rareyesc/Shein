package shein.micro_productos.service;

import shein.micro_productos.entity.Producto;
import shein.micro_productos.exception.ResourceNotFoundException;
import shein.micro_productos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto obtenerProductoPorId(Integer id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con ID: " + id));
    }

    @Override
    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto actualizarProducto(Integer id, Producto detallesProducto) {
        Producto producto = obtenerProductoPorId(id);
        producto.setNombreProducto(detallesProducto.getNombreProducto());
        producto.setDescripcion(detallesProducto.getDescripcion());
        producto.setSku(detallesProducto.getSku());
        producto.setImagen(detallesProducto.getImagen());
        producto.setPrecioCompra(detallesProducto.getPrecioCompra());
        producto.setPrecioSinDescuento(detallesProducto.getPrecioSinDescuento());
        producto.setPrecioVenta(detallesProducto.getPrecioVenta());
        producto.setIdCategoria(detallesProducto.getIdCategoria());
        producto.setIdSubcategoria(detallesProducto.getIdSubcategoria());
        producto.setIdGenero(detallesProducto.getIdGenero());
        producto.setIdColor(detallesProducto.getIdColor());
        producto.setIdTalla(detallesProducto.getIdTalla());
        producto.setIdEstado(detallesProducto.getIdEstado());
        producto.setIdPedido(detallesProducto.getIdPedido());
        return productoRepository.save(producto);
    }

    @Override
    public void eliminarProducto(Integer id) {
        Producto producto = obtenerProductoPorId(id);
        productoRepository.delete(producto);
    }

    @Override
    public List<Producto> buscarProductosPorNombre(String nombre) {
        return productoRepository.findByNombreProductoContaining(nombre);
    }

    @Override
    public Producto obtenerProductoPorSku(String sku) {
        return productoRepository.findBySku(sku);
    }
}
